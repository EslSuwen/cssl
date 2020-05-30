import {TeachPlanService} from "../../service/teach-plan.service";
import {TeachPlan} from "../../enity/teachPlan";
import {environment} from "../../../environments/environment";
import {Component, OnInit} from "@angular/core";
import {Router} from "@angular/router";

@Component({
  selector: 'app-teach-table',
  templateUrl: './teach-table.component.html',
  styleUrls: ['./teach-table.component.scss']
})
export class TeachTableComponent implements OnInit {
  pageIndex = 1;
  pageSize = 5;
  total = 1;
  dataSet = [];
  loading = true;
  sortValue = null;
  sortKey = null;
  rooms = [];
  unused = 2;

  searchList = '';
  filterMajorStatus = [
    {text: '计算机科学与技术', value: '0'},
    {text: '物联网技术', value: '1'},
    {text: '通信技术', value: '2'},
  ];
  filterClassStatus = [
    {text: '计算机一班', value: '0'},
    {text: '计算机二班', value: '1'},
    {text: '计算机三班', value: '2'},
  ];
  public planPeriod: any = {
    year: '2019-2020(1)',
  };

  TEACH_PLAN_DOWNLOAD_URL = `${environment.apiUrl}/arrange/getTeachingPlanExcel`;

  teachPlans: TeachPlan[];

  constructor(private teachPlanService: TeachPlanService, private router: Router) {
  }

  ngOnInit() {
    this.teachPlanService.getTeachingPlan().subscribe(
      result => {
        if (result.success) {
          this.teachPlans = result.data;
          console.log(result.data);
          this.updateData(true);
        }
      }
    );
  }

  download() {
    window.location.href = this.TEACH_PLAN_DOWNLOAD_URL;
  }

  updateData(reset: boolean = false): void {
    if (reset) {
      this.pageIndex = 1;
    }

    this.loading = true;
    this.dataSet = this.teachPlans;
    if (this.searchList.length > 0) {
      this.dataSet = this.teachPlans.filter((each) => each.expMajor !== this.searchList);
      this.searchList = '';
    }
    this.total = this.dataSet.length;

    // 排序不影响条目数量
    if (this.sortKey && this.sortValue) {
      this.dataSet = this.dataSet.sort((a, b) => (this.sortValue === 'ascend') ? (a[this.sortKey] > b[this.sortKey] ? 1 : -1)
        : (b[this.sortKey] > a[this.sortKey] ? 1 : -1));
    }

    this.dataSet = this.dataSet.slice((this.pageIndex - 1) * this.pageSize, (this.pageIndex - 1) * this.pageSize + this.pageSize);
    this.loading = false;
  }

  sort(sort: { key: string, value: string }): void {
    this.sortKey = sort.key;
    this.sortValue = sort.value;
    this.updateData(true);
  }

  updateFilter(value: string): void {
    this.searchList = value;
    this.updateData(true);
  }
}
