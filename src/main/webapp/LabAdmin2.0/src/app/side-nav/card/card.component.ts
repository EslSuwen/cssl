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
  // courseSelected = [];
  courseSelectSettings = {};
  projectItems: ProjectItem[];
  exps: Exp[]; // 实验卡片
  switch2: any;
  modalRef: MDBModalRef; // 模态
  expCardFG: FormGroup;
  id: number;
  headElements = ['课程名', '实验课程名', '仪器设备(数量)', '消耗材料(数量)', '实验总学时', '实验教材', '实验所用软件'];
  ProjectItemArray: Array<ProjectItem> = [];
  title: string;

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

    // 初始化细则
    const id = (this.ProjectItemArray.length > 0) ? this.ProjectItemArray[this.ProjectItemArray.length - 1].iid + 1 : 0;
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
      if (!result) {
        return;
      }
      console.log(result.data);
      for (let each of this.ProjectItemArray) {
        each.proId = result.data;
      }
      this.exps.push(exp);
      this.projectService.addProjectItems(this.ProjectItemArray).subscribe();
    })*/
  }


  // 响应式更改 expItem 数据
  loadProjectItems(proId: number) {
    this.projectService.getProjectItems(proId)
      .subscribe(result => {
        if (result.success) {
          this.projectItems = result.data;
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

                /*                expItems.map(each => {
                                  each.proId = 0;
                                  console.log(each);
                                  this.ProjectItemArray.push(each);
                                });*/
                this.nzMessage.success("导入成功！");
              }
            });
          }
        });
      }
    });
  }

  //获取实验项目名称
  getExpName(title1: string) {
    this.title = title1;
  }

  showModal(): void {
    this.addItemVisible = true;
  }

  // expItem 控制
  removeNewItem(id: any) {
    this.ProjectItemArray.splice(id, 1);
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

  success_Message(type: string): void { //提交成功后的显示
    this.nzMessage.create(type, `提交成功!!!,等待管理员审核`);
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
