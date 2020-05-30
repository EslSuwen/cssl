import {Injectable} from '@angular/core';
import {HandleError} from "./handle-error";
import {HttpClient} from "@angular/common/http";
import {NzMessageService} from "ng-zorro-antd";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {result} from "../enity/result";
import {catchError, tap} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class LabService extends HandleError {

  constructor(private http: HttpClient, message: NzMessageService) {
    super(message);
  }

  private LAB_API = `${environment.apiUrl}/lab`;

  /**
   * @description 根据实验室编号获取实验室信息
   *
   * @param labId 实验室编号
   * @return 项目卡片
   * @author suwen
   * @date 2020/5/29 上午10:00
   */
  getLab(labId: string): Observable<result> {
    const url = `${this.LAB_API}/getLab`;
    return this.http.get<result>(url, {params: {labId}}).pipe(
      tap(response => {
        if (response.success) {
          this.success(response.message);
        } else {
          this.error(`根据实验室编号获取实验室信息失败， labId：${labId}`);
        }
      }),
      catchError(this.handleError<result>(`根据实验室编号获取实验室信息失败， labId：${labId}`))
    );
  }

  /**
   * @description 根据实验室类型编号获取实验室信息
   *
   * @param typeId 实验室类型编号
   * @return 项目卡片
   * @author suwen
   * @date 2020/5/29 上午10:00
   */
  getLabByType(typeId: string): Observable<result> {
    const url = `${this.LAB_API}/getLabByTypeId`;
    return this.http.get<result>(url, {params: {typeId}}).pipe(
      tap(response => {
        if (response.success) {
          this.success(response.message);
        } else {
          this.error(`根据实验室类型编号获取实验室信息，  typeId：${typeId}`);
        }
      }),
      catchError(this.handleError<result>(`根据实验室类型编号获取实验室信息，typeId：${typeId}`))
    );
  }

  /**
   * @description 根据实验室类型编号校区获取实验室信息
   *
   * @param typeId 实验室类型编号
   * @param campus 校区
   * @return 项目卡片
   * @author suwen
   * @date 2020/5/29 上午10:00
   */
  getLabByTypeCampus(typeId: string, campus: string): Observable<result> {
    const url = `${this.LAB_API}/getLabByTypeIdCampus`;
    return this.http.get<result>(url, {params: {typeId, campus}}).pipe(
      tap(response => {
        if (response.success) {
          this.success(response.message);
        } else {
          this.error(`根据实验室类型编号获取实验室信息，  typeId：${typeId}，campus: ${campus}`);
        }
      }),
      catchError(this.handleError<result>(`根据实验室类型编号校区获取实验室信息，typeId：${typeId}，campus: ${campus}`))
    );
  }

}
