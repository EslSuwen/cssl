import {Component, OnInit} from '@angular/core';
import {ModalComponent} from 'src/app/modal/modal.component';
import {MDBModalRef, MDBModalService} from 'angular-bootstrap-md';
import {FormControl, FormGroup, Validators} from '@angular/forms';

import {Exp, ProjectItem} from '../../enity/enity';
import {ProjectService} from 'src/app/service/project.service';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})
export class CardComponent implements OnInit {
  projectItems: ProjectItem[];
  exps: Exp[]; // 实验卡片
  switch2: any;
  modalRef: MDBModalRef; // 模态
  element: FormGroup;
  element1: FormGroup;
  id: number;
  headElements = ['实验课程名', '仪器设备(数量)', '消耗材料(数量)', '实验总学时', '实验教材', '实验所用软件'];
  controlArray: Array<{
    id: number, iName: string, iType: string, iTime: number, cType: string, num: number, intend: string,
  }> = [];

  // myList: Array<ProjectItem> = [];

  remove(id: any) {
    this.controlArray.splice(id, 1);
  }

  add() {
    const id = (this.controlArray.length > 0) ? this.controlArray[this.controlArray.length - 1].id + 1 : 0;
    const control = {
      id,
      // 实验项目名
      iName: '',
      // 实验类型
      iType: '',
      // 实验项目学时
      iTime: 0,
      // 必修或选修
      cType: '',
      // 分组人数
      num: 0,
      // 实验目的
      intend: '',
    };
    this.controlArray.push(control);
  }

  constructor(
    private modalService: MDBModalService,
    private projectService: ProjectService) {
  }

  ngOnInit() {
    // 初始化数据
    this.projectService.getProjects()
      .subscribe(exps => {
        this.exps = exps;
        console.log('exps : ' + exps.length);
      });
    // 初始化实验卡片表单控制
    this.element = new FormGroup({
      // 实验课程名称
      expCname: new FormControl(null, Validators.required),
      // 设备
      expEqname: new FormControl(null, Validators.required),
      // 设备数量
      eqNum: new FormControl(null, [Validators.required, Validators.min(1), Validators.max(100)]),
      // 面向专业
      expMajor: new FormControl(null, Validators.required),
      // 学生类别
      sSort: new FormControl(null, Validators.required),
      // 实验总学时
      expTime: new FormControl(null, [Validators.required, Validators.min(1), Validators.max(100)]),
      // 实验教材
      book: new FormControl(null, Validators.required),
      // 实验所用软件
      sSorsoftWaret: new FormControl(null, Validators.required),
      // 教职工号
      tId: new FormControl(null, Validators.required),
      // 课程名
      cName: new FormControl(null, Validators.required),
      // 消耗材料名称
      conName: new FormControl(null, Validators.required),
      // 消耗材料数量
      conNum: new FormControl(null, [Validators.required, Validators.min(1), Validators.max(100)]),
    });
    // 初始化细则
    const id = (this.controlArray.length > 0) ? this.controlArray[this.controlArray.length - 1].id + 1 : 0;
    const control = {
      id,
      // 实验项目名
      iName: '',
      // 实验类型
      iType: '',
      // 实验项目学时
      iTime: 0,
      // 必修或选修
      cType: '',
      // 分组人数
      num: 0,
      // 实验目的
      intend: '',
    };
    this.controlArray.push(control);
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
    console.log(this.controlArray);
    // 这里是提交操作
  }

  loadProjectItems(proId: number) {
    this.projectService.getProjectItems(proId)
      .subscribe(datas => {
        this.projectItems = datas;
        console.log('projectItems : ' + datas.length);
      });
  }

  get expCname() {
    return this.element.get('expCname');
  }

  get expEqname() {
    return this.element.get('expEqname');
  }

  get eqNum() {
    return this.element.get('eqNum');
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

  get sSorsoftWaret() {
    return this.element.get('sSorsoftWaret');
  }
}
