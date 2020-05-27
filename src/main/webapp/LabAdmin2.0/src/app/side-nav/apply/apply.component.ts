import {Component, OnInit} from '@angular/core';
import {ApplyService} from '../../service/apply.service';
import {Exp} from '../../enity/project';
import {ProjectService} from 'src/app/service/project.service';
import {Teach} from '../../enity/teacher';
import {Arrange, ArrangePeriod} from '../../enity/arrange';
import {FormControl} from '@angular/forms';
import {AuthenticationService} from "../../service/authentication.service";
import { AuditService } from 'src/app/service/audit.service';

@Component({
  selector: 'app-apply',
  templateUrl: './apply.component.html',
  styleUrls: ['./apply.component.scss']
})
export class ApplyComponent implements OnInit {
  exps: Exp[]; // 实验卡片
  applysumbmit = new Arrange();
  arrangePeriod = new Array<ArrangePeriod>();
  // status: number;
  status = 0;
  // 周次
  weekList = [];
  weekselectedItems = [];
  weekSettings = {};
  // 星期
  dayList = [];
  dayselectedItems = [];
  daySettings = {};
  // 节次
  timeList = [];
  timeselectedItems = [];
  timeSettings = {};
  // 校区
  regionList = [];
  regionselectedItems = [];
  regionSettings = {};
  // 班级
  classList = [];
  classselectedItems = [];
  classSettings = {};
  // 年级
  gradeList = [];
  gradeselectedItems = [];
  gradeSettings = {};

  teacheList: Array<Teach>;
  beizhu: FormControl;

  constructor(private applyService: ApplyService,
     private projectService: ProjectService,
      private authenticationService: AuthenticationService,
      private auditService:AuditService) {
  }


  ngOnInit() {
    this.beizhu = new FormControl();

    this.projectService.getProjects(this.authenticationService.getUserNo())
      .subscribe(exps => {
        this.exps = exps;
      });

    this.auditService.getAuditProjects().subscribe(data => {
      console.log(data);
    })

    this.weekList = [
      {id: 1, itemName: '第一周'},
      {id: 2, itemName: '第二周'},
      {id: 3, itemName: '第三周'},
      {id: 4, itemName: '第四周'},
      {id: 5, itemName: '第五周'},
      {id: 6, itemName: '第六周'},
      {id: 7, itemName: '第七周'},
      {id: 8, itemName: '第八周'},
      {id: 9, itemName: '第九周'},
      {id: 10, itemName: '第十周'},
      {id: 11, itemName: '十一周'},
      {id: 12, itemName: '十二周'},
      {id: 13, itemName: '十三周'},
      {id: 14, itemName: '十四周'},
      {id: 15, itemName: '十五周'},
      {id: 16, itemName: '十六周'},
      {id: 17, itemName: '十七周'},
      {id: 18, itemName: '十八周'},
      {id: 19, itemName: '十九周'},
      {id: 20, itemName: '二十周'},
    ];
    this.weekSettings = {
      badgeShowLimit: 2,
      singleSelection: false, // 是否单选
      text: '选择周次',
      enableCheckAll: true, // 是否可以全选
      selectAllText: '全选',
      unSelectAllText: '全不选',
      enableSearchFilter: false, // 查找过滤器
      // showCheckbox: false,
      // enableFilterSelectAll: true, // “全选”复选框可以选择所有过滤结果
      // limitSelection 选择个数的限制
      // searchPlaceholderText 搜索的默认文字
    };
    this.dayList = [
      {id: '1', itemName: '星期一'},
      {id: '2', itemName: '星期二'},
      {id: '3', itemName: '星期三'},
      {id: '4', itemName: '星期四'},
      {id: '5', itemName: '星期五'},
      {id: '6', itemName: '星期六'},
      {id: '7', itemName: '星期天'},
    ];
    this.daySettings = {
      badgeShowLimit: 2,
      singleSelection: false, // 是否单选
      text: '选择星期',
      enableCheckAll: true, // 是否可以全选
      selectAllText: '全选',
      unSelectAllText: '全不选',
      enableSearchFilter: false, // 查找过滤器
      // showCheckbox: false,
      // enableFilterSelectAll: true, // “全选”复选框可以选择所有过滤结果
      // limitSelection: 5,
      // searchPlaceholderText 搜索的默认文字
    };
    this.timeList = [
      {id: '1', itemName: '上午第一节'},
      {id: '2', itemName: '上午第二节'},
      {id: '3', itemName: '下午第一节'},
      {id: '4', itemName: '下午第二节'},
      {id: '5', itemName: '晚上第一节'},
      {id: '6', itemName: '晚上第二节'},
    ];
    this.timeSettings = {
      singleSelection: true, // 是否单选
      text: '选择节次',
      // enableCheckAll: true, // 是否可以全选
      // selectAllText: '全选',
      // unSelectAllText: '全不选',
      enableSearchFilter: false, // 查找过滤器
      // showCheckbox: false,
      // enableFilterSelectAll: true, // “全选”复选框可以选择所有过滤结果
      // limitSelection: 5,
      // searchPlaceholderText 搜索的默认文字
    };
    this.regionList = [
      {id: '1', itemName: '双福校区'},
      {id: '2', itemName: '南岸校区'},
    ];
    this.regionSettings = {
      singleSelection: true, // 是否单选
      text: '选择校区',
      // enableCheckAll: true, // 是否可以全选
      // selectAllText: '全选',
      // unSelectAllText: '全不选',
      enableSearchFilter: false, // 查找过滤器
      // showCheckbox: false,
      // enableFilterSelectAll: true, // “全选”复选框可以选择所有过滤结果
      // limitSelection: 5,
      // searchPlaceholderText 搜索的默认文字
    };
    const date = new Date();
    this.gradeList = [
      {id: '1', itemName: date.getFullYear()}, // 20
      {id: '2', itemName: date.getFullYear() - 1}, // 19
      {id: '3', itemName: date.getFullYear() - 2}, // 18
      {id: '4', itemName: date.getFullYear() - 3}, // 17
      {id: '4', itemName: date.getFullYear() - 4}, // 16

    ];
    this.gradeSettings = {
      singleSelection: true, // 是否单选
      text: '选择年级',
      // enableCheckAll: true, // 是否可以全选
      // selectAllText: '全选',
      // unSelectAllText: '全不选',
      enableSearchFilter: false, // 查找过滤器
      // showCheckbox: false,
      // enableFilterSelectAll: true, // “全选”复选框可以选择所有过滤结果
      // limitSelection: 5,
      // searchPlaceholderText 搜索的默认文字
    };
    this.classList = [
      {id: '1', itemName: '计算机1班'},
      {id: '2', itemName: '计算机2班'},
      {id: '3', itemName: '计算机3班'},
      {id: '4', itemName: '计算机4班'},
      {id: '5', itemName: '物联网1班'},
      {id: '6', itemName: '物联网2班'},
      {id: '7', itemName: '电子信息1班'},
      {id: '8', itemName: '电子信息2班'},
      {id: '9', itemName: '电子信息3班'},
      {id: '10', itemName: '电子信息4班'},
      {id: '11', itemName: '电子信息5班'},
      {id: '12', itemName: '电子信息6班'},
      {id: '13', itemName: '曙光班'},
    ];
    this.classSettings = {
      badgeShowLimit: 2,
      singleSelection: false, // 是否单选
      text: '选择班级',
      enableCheckAll: true, // 是否可以全选
      selectAllText: '全选',
      unSelectAllText: '全不选',
      enableSearchFilter: false, // 查找过滤器
      // showCheckbox: false,
      // enableFilterSelectAll: true, // “全选”复选框可以选择所有过滤结果
      // limitSelection: 5,
      // searchPlaceholderText 搜索的默认文字
    };

  }

  // 提交申请
  submit(i) {
    console.log(this.regionselectedItems.length);
    if ((this.regionselectedItems.length && this.classselectedItems.length
      && this.weekselectedItems.length && this.dayselectedItems.length && this.timeselectedItems.length) !== 0) {
      // id
      this.applysumbmit.proId = this.exps[i].proId;
      // 校区
      this.applysumbmit.campus = this.regionselectedItems[0].itemName;
      // 教师编号
      this.applysumbmit.tid = this.authenticationService.getUserNo();
      // 备注
      this.applysumbmit.labRemark = this.beizhu.value;
      // 实验项目名称
      this.applysumbmit.expProname = this.exps[i].expCname;
      // 班级
      this.applysumbmit.labClass = this.classselectedItems[0].itemName;
      for (let k = 1; k < this.classselectedItems.length; k++) {
        this.applysumbmit.labClass = this.applysumbmit.labClass + '-' + this.classselectedItems[k].itemName;
      }
      // tslint:disable-next-line: prefer-for-of
      for (let m = 0; m < this.weekselectedItems.length; m++) {
        // 周次
        // tslint:disable-next-line: prefer-for-of
        for (let j = 0; j < this.dayselectedItems.length; j++) {
          // 星期
          const a = new ArrangePeriod();

          a.labWeek = this.weekselectedItems[m].id;

          a.labDay = this.dayselectedItems[j].id;

          // 节次
          a.labSession = this.timeselectedItems[0].id;
          this.arrangePeriod.push(a);
        }

      }
      this.applysumbmit.arrangePeriod = this.arrangePeriod;
      console.log(this.applysumbmit);

      this.applyService.addArrange(this.applysumbmit).subscribe();

      alert('己完成申请！');
      this.projectService.getProjects(this.authenticationService.getUserNo())
        .subscribe(exps => {
          this.exps = exps;
        });

    } else {
      alert('确保填写完整的信息哦！');
    }

    this.applysumbmit = new Arrange();
    this.arrangePeriod = new Array<ArrangePeriod>();

  }
}
