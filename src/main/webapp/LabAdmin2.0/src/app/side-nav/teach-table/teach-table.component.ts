import {Component, OnInit} from '@angular/core';
import {TeachPlanService} from "../../service/teach-plan.service";
import {TeachPlan} from "../../enity/teachPlan";
import {environment} from "../../../environments/environment";
import {Router} from "@angular/router";

@Component({
  selector: 'app-teach-table',
  templateUrl: './teach-table.component.html',
  styleUrls: ['./teach-table.component.scss']
})
export class TeachTableComponent implements OnInit {
  public planPeriod: any = {
    year: '2019-2020',
  };

  TEACH_PLAN_DOWNLOAD_URL = `${environment.apiUrl}/arrange/getTeachingPlanExcel`;

  teachPlans: TeachPlan[];

  constructor(private teachPlanService: TeachPlanService, private router: Router) {
  }

  ngOnInit() {
    console.log(this.teachPlanService.getTeachingPlan().subscribe(
      result => {
        if (result.success) {
          this.teachPlans = result.data;
          console.log(result.data);
        }
      }
    ));
  }

  download() {
    window.location.href = this.TEACH_PLAN_DOWNLOAD_URL;
  }

}
