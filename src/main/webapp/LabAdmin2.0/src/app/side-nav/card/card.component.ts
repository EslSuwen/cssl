import {Component, OnInit} from '@angular/core';
import {MDBModalRef, MDBModalService} from 'angular-bootstrap-md';
import {FormControl, FormGroup, Validators} from '@angular/forms';
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
  confirmModal: NzModalRef; // For testing by now
  //设置模态框的参数
  isVisible = false;
  isConfirmLoading = false;
  value1 = 1; //增加表格的行数
  courseList = [];
  selectedItems1 = [];
  Settings1 = {};
  projectItems: ProjectItem[];
  exps: Exp[]; // 实验卡片
  newExp = new Exp();
  switch2: any;
  modalRef: MDBModalRef; // 模态
  element: FormGroup;
  element1: FormGroup;
  id: number;
  headElements = ['课程名', '实验课程名', '仪器设备(数量)', '消耗材料(数量)', '实验总学时', '实验教材', '实验所用软件'];
  controlArray: Array<ProjectItem> = [];
  title: string;

  // 学期列表
  termList = ['请选择学期', '2019/2020(2)', '2019/2020(1)', '2018/2019(2)', '2018/2019(1)']
  termSelected = '请选择学期';

  // myList: Array<ProjectItem> = [];

  remove(id: any) {
    this.controlArray.splice(id, 1);
  }

  add() {
    // const id = (this.controlArray.length > 0) ? this.controlArray[this.controlArray.length - 1].iid + 1 : 0;
    this.controlArray.push(new ProjectItem());
  }

  constructor(
    private modalService: MDBModalService,
    private projectService: ProjectService,
    private authenticationService: AuthenticationService,
    private teacherService: TeacherService,
    private modal: NzModalService,
    private message: NzMessageService,
    public router: Router
  ) {
  }

  ngOnInit() {
    this.Settings1 = {
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
    this.element = new FormGroup({
      selectedItems1: new FormControl(),
      // 实验课程名称
      expCname: new FormControl(null, Validators.required),
      // 设备
      expEqname: new FormControl(null, Validators.required),
      // 设备数量
      eqnum: new FormControl(null, [Validators.required, Validators.min(0), Validators.max(100)]),
      // 面向专业
      expMajor: new FormControl(null, Validators.required),
      // 学生类别
      sSort: new FormControl(null, Validators.required),
      // 实验总学时
      expTime: new FormControl(null, [Validators.required, Validators.min(1), Validators.max(100)]),
      // 实验教材
      book: new FormControl(null, Validators.required),
      // 实验所用软件
      software: new FormControl(null, Validators.required),
      // 教职工号
      expTid: new FormControl(null, Validators.required),
      // 课程名
      cname: new FormControl(null, Validators.required),
      // 消耗材料名称
      conName: new FormControl(null, Validators.required),
      // 消耗材料数量
      conNum: new FormControl(null, [Validators.required, Validators.min(0), Validators.max(100)]),
    });
    // 初始化细则
    const id = (this.controlArray.length > 0) ? this.controlArray[this.controlArray.length - 1].iid + 1 : 0;
    this.controlArray.push(new ProjectItem());
  }

  onsubmit() {
    // this.success_Message('success');
    this.saveNewExp();
    console.log(this.controlArray);
    console.log(this.newExp);
    this.projectService.addProject(this.newExp).subscribe(result => {
      if (!result) {
        return;
      }
      console.log(result.data);
      for (let each of this.controlArray) {
        each.proId = result.data;
      }
      this.exps.push(this.newExp);
      this.projectService.addProjectItems(this.controlArray).subscribe();
    })
  }

  loadProjectItems(proId: number) {
    this.projectService.getProjectItems(proId)
      .subscribe(result => {
        if (result.success) {
          this.projectItems = result.data;
        }
      });
  }

  courseSelect(item: any) {
    this.newExp.courseId = item.id;
    this.newExp.cname = item.itemName;
  }

  saveNewExp() {
    this.newExp.expTid = this.authenticationService.getUserNo();
    this.newExp.expCname = this.expCname.value;
    this.newExp.expEqname = this.expEqname.value;
    this.newExp.eqnum = this.eqNum.value;
    this.newExp.conName = this.conName.value;
    this.newExp.conNum = this.conNum.value;
    this.newExp.book = this.book.value;
    this.newExp.software = this.software.value;
    this.newExp.expTime = this.expTime.value;
    this.newExp.status = 'AUDITING';
    this.newExp.labStatus = 'UNCHECK';
  }

  get expCname() {
    return this.element.get('expCname');
  }

  get expEqname() {
    return this.element.get('expEqname');
  }

  get eqNum() {
    return this.element.get('eqnum');
  }

  get conName() {
    return this.element.get('conName');
  }

  get conNum() {
    return this.element.get('conNum');
  }

  get expTime() {
    return this.element.get('expTime');
  }

  get book() {
    return this.element.get('book');
  }

  get software() {
    return this.element.get('software');
  }

  getExpName(title1: string)  //获取实验项目名称
  {
    this.title = title1;
  }

  confirm(): void {
    this.remove(this.id);
  }

  showModal(): void {
    this.isVisible = true;
  }

  handleOk(): void {
    this.isConfirmLoading = true;
    this.addItem(this.value1);
    setTimeout(() => {
      this.isVisible = false;
      this.isConfirmLoading = false;
    }, 500);
  }

  handleCancel(): void {
    this.isVisible = false;
  }

  addItem(time: number) {
    for (let i = 0; i < time; i++) {
      this.add();
    }
  }

  showConfirm(): void {  //确认提交的模态框
    this.confirmModal = this.modal.confirm({
      nzTitle: '确认提交吗',
      nzContent: '确认后，窗口将在几秒后关闭，期间可以取消',
      nzOnOk: () =>
        new Promise((resolve, reject) => {
          setTimeout(Math.random() < 0.0 ? resolve : reject, 3000);
        }).catch(() => this.onsubmit())
    });
  }

  success_Message(type: string): void { //提交成功后的显示
    this.message.create(type, `提交成功!!!,等待管理员审核`);
    // this.router.navigate(['sidenav/personalinfo']);
  }

  onTermSelected() {
    console.log(this.termSelected);
    this.projectService.getProjects(this.authenticationService.getUserNo(), this.termSelected)
      .subscribe(result => {
        if (result.success) {
          this.exps = result.data;
        }
        console.log('exps : ' + result.data);
      });
  }
}
