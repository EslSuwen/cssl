import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {TeachPlan} from '../enity/teachPlan';
import {HandleError} from './handle-error';
import {NzMessageService} from 'ng-zorro-antd';
import {catchError, tap} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TeachPlanService extends HandleError {

  constructor(private http: HttpClient, message: NzMessageService) {
    super(message);
  }

  private ARRANGE_API = `${environment.apiUrl}/arrange`;

  /**
   * @description 获取教学计划表
   *
   * @return 教学计划表
   * @author suwen
   * @date 2020/5/27 上午11:01
   */
  getTeachingPlan(): Observable<TeachPlan[]> {
    const url = `${this.ARRANGE_API}/getTeachingPlan`;
    return this.http.get<any>(url).pipe(
      tap(response => {
        if (response.success) {
          this.success(response.message);
        } else {
          this.error('获取教学计划表失败');
        }
      }),
      catchError(this.handleError<TeachPlan[]>('获取教学计划表失败', []))
    );
  }
}
