import {Injectable} from '@angular/core';
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {TeachPlan} from "../enity/teachPlan";

@Injectable({
  providedIn: 'root'
})
export class TeachPlanService {

  constructor(private http: HttpClient) {
  }

  private arrange_api = `${environment.apiUrl}/arrange`;

  getTeachingPlan(): Observable<TeachPlan[]> {
    const url = `${this.arrange_api}/getTeachingPlan`;
    return this.http.get<TeachPlan[]>(url);
  }
}
