import {Component, OnInit} from '@angular/core';
import {MDBModalRef, MDBModalService} from 'angular-bootstrap-md';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {NzMessageService} from 'ng-zorro-antd/message';
import {ProjectService} from '../../service/project.service';
import {Exp, ProjectItem} from '../../enity/project';
import {AuthenticationService} from "../../service/authentication.service";
import {TeacherService} from "../../service/teacher.service";
import {NzModalRef, NzModalService} from 'ng-zorro-antd/modal';
import {Router} from '@angular/router';
import {DateUtils} from "../../utils/DateTerm";

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss'],
})
export class CardComponent implements OnInit {
  nowTerm = DateUtils.nowTerm();
  confirmModal: NzModalRef;
  //设置模态框的参数
  addItemVisible = false;
  addItemNum = 1; //增加表格的行数
  courseList = [];
  courseSelectSettings = {};
  projectItems: ProjectItem[];
  exps: Exp[]; // 实验卡片
  switch2: any;
  modalRef: MDBModalRef; // 模态
  expCardFG: FormGroup;
  id: number;
  headElements = ['课程名', '实验课程名', '仪器设备(数量)', '消耗材料(数量)', '实验总学时', '实验教材', '实验所用软件', '操作'];
  ProjectItemArray: Array<ProjectItem> = [];
  itemTitle: string;

  // 修改缓存
  editItemCache = {};
  editExpCache = {};

  // 学期列表
  termList = ['请选择学期', '2019/2020(2)', '2019/2020(1)', '2018/2019(2)', '2018/2019(1)']
  termSelected = '请选择学期';

  constructor(private fb: FormBuilder,
              private modalService: MDBModalService,
              private projectService: ProjectService,
              private authenticationService: AuthenticationService,
              private teacherService: TeacherService,
              private nzModal: NzModalService,
              private nzMessage: NzMessageService,
              public router: Router
  ) {
  }

  ngOnInit() {
    this.courseSelectSettings = {
      singleSelection: true, // 是否单选
      text: '选择课程',
      // enableCheckAll: true, // 是否可以全选
      // selectAllText: '全选',
      // unSelectAllText: '全不选',
      enableSearchFilter: false, // 查找过滤器
      // showCheckbox: false,
      // enableFilterSelectAll: true, // “全选”复选框可以选择所有过滤结果
      // limitSelection: 5,
      // searchPlaceholderText 搜索的默认文字
    };
    // 初始化数据
    this.teacherService.getTeaches(this.authenticationService.getUserNo(), DateUtils.nowTerm())
      .subscribe(result => {
        if (result.success) {
          for (let each of result.data)
            this.courseList.push({id: each.courseId, itemName: each.courseName});
        }
      });
    // 初始化实验卡片表单控制
    this.expCardFG = this.fb.group({
      courseSelected: ['', [Validators.required]],
      expCname: ['', [Validators.required]], // 实验课程名称
      expEqname: ['', [Validators.required]],// 设备
      eqnum: ['', [Validators.required, Validators.min(0), Validators.max(100)]],// 设备数量
      expMajor: ['', [Validators.required]],// 面向专业
      ssort: ['', [Validators.required]],// 学生类别
      expTime: ['', [Validators.required, Validators.min(1), Validators.max(100)]],// 实验总学时
      book: ['', [Validators.required]],// 实验教材
      software: ['', [Validators.required]],// 实验所用软件
      expTid: ['', [Validators.required]],// 教职工号
      cname: ['', [Validators.required]],// 课程名
      conName: ['', [Validators.required]],// 消耗材料名称
      conNum: ['', [Validators.required, Validators.min(0), Validators.max(100)]],// 消耗材料数量
    });

    this.ProjectItemArray.push(new ProjectItem());
  }

  onSubmit() {
    if (this.expCardFG.invalid) {
      this.nzMessage.error("请检查信息是否填写正确！")
      return;
    }
    const exp = new Exp();
    for (const key in this.expCardFG.controls) {
      if (key === 'courseSelected') {
        continue;
      }
      exp[key] = this.expCardFG.controls[key].value;
    }
    exp.status = 'AUDITING';
    exp.labStatus = 'UNCHECK';
    exp.term = DateUtils.nowTerm();

    console.log(exp);
    console.log(this.ProjectItemArray);
    /*this.projectService.addProject(exp).subscribe(result => {
      if (!result.success) {
        return;
      }
      console.log(result.data);
      this.ProjectItemArray.map(each=>each.proId=result.data);
      this.exps.push(exp);
      this.projectService.addProjectItems(this.ProjectItemArray).subscribe();
    })*/
    this.nzMessage.success('提交成功!!!,等待管理员审核');
    this.switch2 = false;
  }


  // 响应式更新 expItem 数据
  loadProjectItems(proId: number) {
    this.projectService.getProjectItems(proId)
      .subscribe(result => {
        if (result.success) {
          this.projectItems = result.data;
          this.updateItemEditCache();
        }
      });
  }

  // 重用往期卡片信息
  courseSelect(item: any) {
    this.projectService.reuseCard(this.authenticationService.getUserNo(), item.id).subscribe(result => {
      if (result.success) {
        this.nzModal.confirm({
          nzTitle: '是否导入上次开课卡片信息',
          nzContent: '导入往期信息后仍可修改',
          nzOnOk: () => {
            this.expCardFG.patchValue(result.data);
            this.projectService.getProjectItems(result.data.proId).subscribe(result => {
              if (result.success) {
                this.ProjectItemArray = result.data;
                this.nzMessage.success("导入成功！");
              }
            });
          }
        });
      }
    });
  }

  confirmAddItem(): void {
    for (let i = 0; i < this.addItemNum; i++) {
      this.ProjectItemArray.push(new ProjectItem());
    }
  }

  //确认提交的模态框
  showConfirm(): void {
    this.confirmModal = this.nzModal.confirm({
      nzTitle: '确认提交吗',
      nzContent: '确认后，窗口将在几秒后关闭，期间可以取消',
      nzOnOk: () =>
        new Promise((resolve, reject) => {
          setTimeout(Math.random() < 0.0 ? resolve : reject, 3000);
        }).catch(() => this.onSubmit())
    });
  }

  onTermSelected() {
    console.log(this.termSelected);
    this.projectService.getProjects(this.authenticationService.getUserNo(), this.termSelected)
      .subscribe(result => {
        if (result.success) {
          this.exps = result.data;
          this.updateExpEditCache();
        }
      });
  }

  startItemEdit(ino: number): void {
    this.editItemCache[ino].edit = true;
  }

  cancelItemEdit(ino: number): void {
    this.editItemCache[ino].edit = false;
  }

  saveItemEdit(ino: number): void {

    if (!this.saveItemCheck(this.editItemCache[ino].data)) {
      return;
    }

    // 判断有没有更新
    /*const index = this.dataSet.findIndex(item => item.key === key);
    const customer = this.dataSet[index];
    const editCustomer = this.editCache[key].data;
    if (customer.id === editCustomer.id
      && customer.name === editCustomer.name
      && customer.idCard === editCustomer.idCard
      && customer.phoneNo === editCustomer.phoneNo
      && customer.comment === editCustomer.comment) {
      this.editCache[key].edit = false;
      return;
    }

    // 调用修改服务
    this.customerService.updateCustomer(this.editCache[key].data as Customer).subscribe(result => {
      if (result !== undefined && result.success !== undefined && result.success) {
        const index = this.dataSet.findIndex(item => item.key === key);
        Object.assign(this.dataSet[index], result.data);
        this.editCache[key].edit = false;
      }
    });*/
    this.editItemCache[ino].edit = false;
    this.nzMessage.success("修改成功");
  }

  saveItemCheck(data: any): boolean {
    // 姓名
    /*if (data.name == null || !data.name.trim()) {
      this.message.error('姓名不能为空');
      return false;
    }

    // 校验身份证号
    if (data.idCard == null || !data.idCard.trim()) {
      this.message.error('身份证号不能为空');
      return false;
    }

    let regex = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
    if (!regex.test(data.idCard)) {
      this.message.error('身份证号不正确');
      return false;
    }

    // 校验手机号
    if (data.phoneNo == null || !data.phoneNo.trim()) {
      this.message.error('手机号不能为空');
      return false;
    }

    regex = /(^[1][3,4,5,7,8][0-9]{9}$)/;
    if (!regex.test(data.phoneNo)) {
      this.message.error('手机号不正确');
      return false;
    }*/

    return true;
  }

  deleteItem(ino: number) {
    this.nzMessage.success("删除成功！");
  }

  updateItemEditCache(edit: boolean = false): void {
    this.projectItems.forEach(item => {
      if (!this.editItemCache[item.ino]) {
        this.editItemCache[item.ino] = {
          edit: edit,
          data: item
        };
      }
    });
  }

  startExpEdit(proId: number): void {
    this.editExpCache[proId].edit = true;
  }

  cancelExpEdit(proId: number): void {
    this.editExpCache[proId].edit = false;
  }

  saveExpEdit(proId: number): void {

    if (!this.saveExpCheck(this.editExpCache[proId].data)) {
      return;
    }

    // 判断有没有更新
    /*const index = this.dataSet.findIndex(item => item.key === key);
    const customer = this.dataSet[index];
    const editCustomer = this.editCache[key].data;
    if (customer.id === editCustomer.id
      && customer.name === editCustomer.name
      && customer.idCard === editCustomer.idCard
      && customer.phoneNo === editCustomer.phoneNo
      && customer.comment === editCustomer.comment) {
      this.editCache[key].edit = false;
      return;
    }

    // 调用修改服务
    this.customerService.updateCustomer(this.editCache[key].data as Customer).subscribe(result => {
      if (result !== undefined && result.success !== undefined && result.success) {
        const index = this.dataSet.findIndex(item => item.key === key);
        Object.assign(this.dataSet[index], result.data);
        this.editCache[key].edit = false;
      }
    });*/
    this.editExpCache[proId].edit = false;
    this.nzMessage.success("修改成功");
  }

  saveExpCheck(data: any): boolean {
    // 姓名
    /*if (data.name == null || !data.name.trim()) {
      this.message.error('姓名不能为空');
      return false;
    }

    // 校验身份证号
    if (data.idCard == null || !data.idCard.trim()) {
      this.message.error('身份证号不能为空');
      return false;
    }

    let regex = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
    if (!regex.test(data.idCard)) {
      this.message.error('身份证号不正确');
      return false;
    }

    // 校验手机号
    if (data.phoneNo == null || !data.phoneNo.trim()) {
      this.message.error('手机号不能为空');
      return false;
    }

    regex = /(^[1][3,4,5,7,8][0-9]{9}$)/;
    if (!regex.test(data.phoneNo)) {
      this.message.error('手机号不正确');
      return false;
    }*/

    return true;
  }

  deleteExp(ino: number) {
    this.nzMessage.success("删除成功！");
  }

  updateExpEditCache(edit: boolean = false): void {
    this.exps.forEach(item => {
      if (!this.editExpCache[item.proId]) {
        this.editExpCache[item.proId] = {
          edit: edit,
          data: item
        };
      }
    });
  }
}
