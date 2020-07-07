import {Component, OnInit} from '@angular/core';
import {MDBModalRef} from 'angular-bootstrap-md';
import {NzModalService} from 'ng-zorro-antd/modal';
import {NzMessageService} from 'ng-zorro-antd/message';
import {Router} from '@angular/router';
import {DateUtils} from "../../utils/DateTerm";
import {ProjectService} from "../../service/project.service";
import {AuthenticationService} from "../../service/authentication.service";
import {TeacherService} from "../../service/teacher.service";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.scss']
})
export class UploadComponent implements OnInit {
  modalRef: MDBModalRef;

  // 学期列表
  termList = ['请选择学期', '2019/2020(2)', '2019/2020(1)', '2018/2019(2)', '2018/2019(1)']
  termSelected = DateUtils.nowTerm();

  courseList = [];
  courseSelected: string;
  courseSelectSettings = {};

  statusList = [{fileName: '考勤名单'}, {fileName: '实验任务书'}, {fileName: '实验成绩'}, {fileName: '评分标准表'}];

  switch1: any;
  // 文件上传的控件
  fileInputName = ['考勤名单', '实验任务书', '实验成绩', '评分标准表', '实验报告'];

  fromData: FormData;

  constructor(
    private nzModal: NzModalService,
    private nzMessage: NzMessageService,
    private router: Router,
    private projectService: ProjectService,
    private authenticationService: AuthenticationService,
    private teacherService: TeacherService,
    public http: HttpClient,) {

  }

  ngOnInit(): void {
    this.courseSelectSettings = {
      singleSelection: true, // 是否单选
      text: '选择课程',
      enableSearchFilter: false, // 查找过滤器
    };
  }

  onsubmit() {
    this.showConfirm();
  }

  showConfirm(): void {
    this.nzModal.confirm({
      nzTitle: '确认提交吗',
      nzContent: '3秒内可以取消',
      nzOnOk: () =>
        new Promise((resolve, reject) => {
          setTimeout(Math.random() < 0.0 ? resolve : reject, 3000);
        }).catch(() => this.createMessage('success'))
    });
  }

  createMessage(type: string): void {
    this.nzMessage.create(type, `提交成功，等待管理员审核`);
    this.router.navigate(['sidenav/personalinfo']).then(r => null);
  }

  // 学期选择后加载课程信息
  onTermSelected() {
    console.log(this.termSelected);
    this.projectService.getProjects(this.authenticationService.getUserNo(), this.termSelected)
      .subscribe(result => {
        if (result.success) {
          this.courseList = [];
          result.data.forEach(each => {
            this.courseList.push({id: each.proId, itemName: each.expCname});
          });
          console.log(this.courseList);
        }
      });
  }

  // 选定课程
  courseSelect(item: any) {
    console.log(item.id);
    console.log(item.itemName);
  }

  fileChange(e) {
    let file = e.file; // 获取图片这里只操作一张图片
    console.log(e);
    console.log(file);
    let api = 'http://localhost:8090/cssl/file/upload'
    let formData = new FormData();
    formData.append('file', file);
    formData.append('test', '123456');
    console.log(formData.get('file'));
    this.http.post(api, formData).subscribe(result => console.log(result));
  }
}
