import { Component, OnInit } from '@angular/core';
import { DateTimeAdapter } from 'ng-pick-datetime';
import { MDBModalRef, MDBModalService } from 'angular-bootstrap-md';
import { ModalComponent } from 'src/app/modal/modal.component';
@Component({
  selector: 'app-notify',
  templateUrl: './notify.component.html',
  styleUrls: ['./notify.component.scss']
})

export class NotifyComponent implements OnInit {
  modalRef: MDBModalRef;
  // 专业
  majorList = [];
  majorselectedItems = [];
  majorSettings = {};

  majorselectedItems1 = [];
  // 班级
  classList = [];
  classselectedItems = [];
  classSettings = {};
  // 年级
  gradeList = [];
  gradeselectedItems = [];
  gradeSettings = {};
  switch1: any;


  constructor(
    dateTimeAdapter: DateTimeAdapter<any>,
    private modalService: MDBModalService
  ) {
    dateTimeAdapter.setLocale('zh-cn'); // change locale to Japanese
  }
  ngOnInit() {

    this.majorList = [
      { id: 1, itemName: '计算机科学与技术' },
      { id: 2, itemName: '物联网工程' },
      { id: 3, itemName: '通信工程' },
      { id: 4, itemName: '电子工程' },
      { id: 5, itemName: '大数据与人工智能' },
    ];

    this.majorSettings = {
      singleSelection: false, // 是否单选
      text: '选择专业',
      enableCheckAll: true, // 是否可以全选
      selectAllText: '全选',
      unSelectAllText: '全不选',
      enableSearchFilter: false, // 查找过滤器
      classes: 'font-weight-bold', // 添加的类
      // showCheckbox: false,
      // enableFilterSelectAll: true, // “全选”复选框可以选择所有过滤结果
      // limitSelection 选择个数的限制
      // searchPlaceholderText 搜索的默认文字
    };
    // 年级
    this.gradeList = [
      { id: 1, itemName: 2016 },
      { id: 2, itemName: 2017 },
      { id: 3, itemName: 2018 },
      { id: 4, itemName: 2019 },
    ];
    this.gradeSettings = {
      singleSelection: false, // 是否单选
      text: '选择年级',
      enableCheckAll: true, // 是否可以全选
      selectAllText: '全选',
      unSelectAllText: '全不选',
      enableSearchFilter: false, // 查找过滤器
      classes: 'font-weight-bold', // 添加的类
      // showCheckbox: false,
      // enableFilterSelectAll: true, // “全选”复选框可以选择所有过滤结果
      // limitSelection 选择个数的限制
      // searchPlaceholderText 搜索的默认文字
    };
    // 班级
    this.classList = [
      { id: 1, itemName: '1班' },
      { id: 2, itemName: '2班' },
      { id: 3, itemName: '3班' },
      { id: 4, itemName: '4班' },
      { id: 5, itemName: '5班' },
    ];
    this.classSettings = {
      singleSelection: false, // 是否单选
      text: '选择班级',
      enableCheckAll: true, // 是否可以全选
      selectAllText: '全选',
      unSelectAllText: '全不选',
      enableSearchFilter: false, // 查找过滤器
      classes: 'font-weight-bold', // 添加的类
      // showCheckbox: false,
      // enableFilterSelectAll: true, // “全选”复选框可以选择所有过滤结果
      // limitSelection 选择个数的限制
      // searchPlaceholderText 搜索的默认文字
    };
  }
  // 他们的点击函数
  onItemSelect(item: any) {
    console.log(item);
  }
  OnItemDeSelect(item: any) {
    console.log(item);
  }
  onSelectAll(items: any) {
    console.log(items);
  }
  onDeSelectAll(items: any) {
    console.log(items);
  }
  onsubmit() {
    this.modalRef = this.modalService.show(ModalComponent, {
      backdrop: true, // 背景蒙版
      focus: true,
      ignoreBackdropClick: false,
      class: 'modal-top-right',
      containerClass: 'right',
      animated: true,
      data: {
        heading: '提交成功！！',
        content: { heading: '', description: '' },
        displaybody: false,
        secondarybtn: false,
      }
    });
    // 这里是操作
  }
}
