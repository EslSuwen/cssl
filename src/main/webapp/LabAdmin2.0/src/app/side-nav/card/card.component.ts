import {Component, OnInit} from '@angular/core';
import {ModalComponent} from 'src/app/modal/modal.component';
import {MDBModalRef, MDBModalService} from 'angular-bootstrap-md';
import {FormControl, FormGroup, Validators, FormBuilder, FormArray} from '@angular/forms';

import {ProjectService} from '../../service/project.service';
import {Exp, ProjectItem} from '../../enity/project';
import {AuthenticationService} from "../../service/authentication.service";
import {TeacherService} from "../../service/teacher.service";

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})
export class CardComponent implements OnInit {
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

  // myList: Array<ProjectItem> = [];

  remove(id: any) {
    this.controlArray.splice(id, 1);
  }

  add() {
    const id = (this.controlArray.length > 0) ? this.controlArray[this.controlArray.length - 1].iid + 1 : 0;
    this.controlArray.push(new ProjectItem());
  }

  constructor(
    private modalService: MDBModalService,
    private projectService: ProjectService,
    private authenticationService: AuthenticationService,
    private teacherService: TeacherService,
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
    this.projectService.getProjects()
      .subscribe(exps => {
        this.exps = exps;
        console.log('exps : ' + exps.length);
      });
    this.teacherService.getTeaches(this.authenticationService.getUserNo())
      .subscribe(data => {
        for (let each of data)
          this.courseList.push({id: each.courseId, itemName: each.courseName});
      });
    // 初始化实验卡片表单控制
    this.element = new FormGroup({
      selectedItems1: new FormControl(),
      // 实验课程名称
      expCname: new FormControl(null, Validators.required),
      // 设备
      expEqname: new FormControl(null, Validators.required),
      // 设备数量
      eqnum: new FormControl(null, [Validators.required, Validators.min(1), Validators.max(100)]),
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
      conNum: new FormControl(null, [Validators.required, Validators.min(1), Validators.max(100)]),
    });
    // 初始化细则
    const id = (this.controlArray.length > 0) ? this.controlArray[this.controlArray.length - 1].iid + 1 : 0;
    this.controlArray.push(new ProjectItem());
  }

  onsubmit() {
    this.modalRef = this.modalService.show(ModalComponent, {
      backdrop: false, // 背景蒙版
      focus: true,
      ignoreBackdropClick: false,
      class: 'modal-top-right',
      containerClass: 'right',
      animated: true,
      data: {
        heading: '提交成功！！',
        content: {heading: '', description: ''},
        displaybody: false,
        secondarybtn: false,
      }
    });
    this.saveNewExp();
    console.log(this.controlArray);
    console.log(this.newExp);
    this.projectService.addProject(this.newExp).subscribe(proId => {
      if (proId == -1) {
        return;
      }
      for (let each of this.controlArray) {
        each.proId = proId;
      }
      this.exps.push(this.newExp);
      this.projectService.addProjectItems(this.controlArray).subscribe();
    })
  }

  loadProjectItems(proId: number) {
    this.projectService.getProjectItems(proId)
      .subscribe(datas => {
        this.projectItems = datas;
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
}
