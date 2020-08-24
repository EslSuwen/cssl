import {Component, OnInit} from '@angular/core';
import {ApplyService} from '../../service/apply.service';
import {Exp} from '../../enity/project';
import {ProjectService} from 'src/app/service/project.service';
import {Arrange, ArrangePeriod} from '../../enity/arrange';
import {FormControl} from '@angular/forms';
import {AuthenticationService} from "../../service/authentication.service";
import {AuditService} from 'src/app/service/audit.service';
import {LabService} from "../../service/lab.service";
import {DateUtils} from "../../utils/DateUtils";

@Component({
  selector: 'app-apply',
  templateUrl: './apply.component.html',
  styleUrls: ['./apply.component.scss']
})
export class ApplyComponent implements OnInit {
  exps: Exp[]; // 实验卡片
  applySubmit = new Arrange();
  arrangePeriod = new Array<ArrangePeriod>();
  // status: number;
  status = 0;
  // 周次
  weekList = [];
  weekSelectedItems = [];
  weekSettings = {};
  // 星期
  dayList = [];
  daySelectedItems = [];
  daySettings = {};
  // 节次
  timeList = [];
  timeSelectedItems = [];
  timeSettings = {};
  // 校区
  regionList = [];
  regionSelectedItems = [];
  regionSettings = {};
  // 班级
  classList = [];
  classSelectedItems = [];
  classSettings = {};
  // 年级
  gradeList = [];
  gradeSelectedItems = [];
  gradeSettings = {};

  // 实验室类型
  labTypeList = [];
  labTypeSelectedItems = [];
  labTypeSettings = {};

  // 实验室名
  labNameList = [];
  labNameSelectedItems = [];
  labNameSettings = {};
  beizhu: FormControl;

  constructor(private applyService: ApplyService,
              private projectService: ProjectService,
              private authenticationService: AuthenticationService,
              private auditService: AuditService,
              private labService: LabService) {
  }


  ngOnInit() {
    this.beizhu = new FormControl();

    this.projectService.getProjects(this.authenticationService.getUserNo(), DateUtils.nowTerm())
      .subscribe(result => {
        if (result.success) {
          console.log(result.data);
          this.exps = result.data;
        }
      });

    this.labService.getLab("60102").subscribe(
      result => {
        if (result.success) {
          console.log(result.data);
        }
      });

    this.labService.getLabByType("123").subscribe(
      result => {
        if (result.success) {
          console.log(result.data);
        }
      });

    this.labService.getLabByTypeCampus("123", "南岸").subscribe(
      result => {
        if (result.success) {
          console.log(result.data);
        }
      });

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

    this.labTypeList = [
      {id: '123', itemName: '电子实验室'},
      {id: '456', itemName: '计算机实验室'},
    ];
    this.labTypeSettings = {
      singleSelection: true, // 是否单选
      text: '选择实验室类型',
      enableSearchFilter: true, // 查找过滤器
    }

    this.labNameList = [
      {id: '60101', itemName: '软件开放实验室'},
      {id: '60102', itemName: '嵌入式系统实验室'},
      {id: '60103', itemName: '硬件开放实验室'},
      {id: '60104', itemName: '通信技术实验室'},
      {id: '60105', itemName: '网络技术实验室'},
      {id: '60201', itemName: '轨道交通实验室'},
      {id: '60202', itemName: '计算机联锁实验室'},
    ];
    this.labNameSettings = {
      singleSelection: true, // 是否单选
      text: '选择实验室',
      enableSearchFilter: true, // 查找过滤器
    }
  }

  onCampusSelected() {

  }

  onLabTypeSelected() {

  }

  // 提交申请
  submit(i) {
    console.log(this.regionSelectedItems.length);
    if ((this.regionSelectedItems.length && this.classSelectedItems.length
      && this.weekSelectedItems.length && this.daySelectedItems.length && this.timeSelectedItems.length) !== 0) {
      // id
      this.applySubmit.proId = this.exps[i].proId;
      // 校区
      this.applySubmit.campus = this.regionSelectedItems[0].itemName;
      // 教师编号
      this.applySubmit.tid = this.authenticationService.getUserNo();
      // 备注
      this.applySubmit.labRemark = this.beizhu.value;
      // 实验项目名称
      this.applySubmit.expProname = this.exps[i].expCname;
      // 班级
      this.applySubmit.labClass = this.classSelectedItems[0].itemName;
      for (let k = 1; k < this.classSelectedItems.length; k++) {
        this.applySubmit.labClass = this.applySubmit.labClass + '-' + this.classSelectedItems[k].itemName;
      }
      // tslint:disable-next-line: prefer-for-of
      for (let m = 0; m < this.weekSelectedItems.length; m++) {
        // 周次
        // tslint:disable-next-line: prefer-for-of
        for (let j = 0; j < this.daySelectedItems.length; j++) {
          // 星期
          const a = new ArrangePeriod();

          a.labWeek = this.weekSelectedItems[m].id;

          a.labDay = this.daySelectedItems[j].id;

          // 节次
          a.labSession = this.timeSelectedItems[0].id;
          this.arrangePeriod.push(a);
        }

      }
      this.applySubmit.arrangePeriod = this.arrangePeriod;
      console.log(this.applySubmit);

      // this.applyService.addArrange(this.applySubmit).subscribe();

      alert('己完成申请！');
      /*this.projectService.getProjects(this.authenticationService.getUserNo(), DateUtils.nowTerm())
        .subscribe(result => {
          if (result.success)
            this.exps = result.data;
        });*/

    } else {
      alert('确保填写完整的信息哦！');
    }

    this.applySubmit = new Arrange();
    this.arrangePeriod = new Array<ArrangePeriod>();

  }
}
