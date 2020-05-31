import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Exp, ProjectItem} from '../enity/project';
import {environment} from '../../environments/environment';
import {NzMessageService} from 'ng-zorro-antd';
import {HandleError} from './handle-error';
import {catchError, tap} from 'rxjs/operators';
import {result} from "../enity/result";

@Injectable({
  providedIn: 'root'
})
export class ProjectService extends HandleError {

  constructor(
    private http: HttpClient, message: NzMessageService) {
    super(message);
  }

  private PROJECT_API = `${environment.apiUrl}/project`;
  private ITEM_API = `${environment.apiUrl}/projectItem`;

  /**
   * @description 增加项目卡片
   *
   * @param project 项目卡片信息
   * @return 执行结果（true: 成功；false: 失败）
   * @author suwen
   * @date 2020/5/27 上午10:49
   */
  addProject(project: Exp): Observable<result> {
    return this.http.post<result>(this.PROJECT_API + '/addProject', project).pipe(
      tap(response => {
        if (response.success) {
          this.success(response.message);
        } else {
          this.error('增加项目卡片失败');
        }
      }),
      catchError(this.handleError<result>('增加项目卡片'))
    );
  }

  /**
   * @description 增加实验卡片项目项
   *
   * @param projectItems 实验卡片项目项
   * @return 执行结果（true: 成功；false: 失败）
   * @author suwen
   * @date 2020/5/27 上午10:51
   */
  addProjectItems(projectItems: ProjectItem[]): Observable<result> {
    return this.http.post<result>(this.ITEM_API + '/addProjectItems', projectItems).pipe(
      tap(response => {
        if (response.success) {
          this.success(response.message);
        } else {
          this.error('增加实验卡片项目项失败');
        }
      }),
      catchError(this.handleError<result>('增加实验卡片项目项'))
    );
  }

  /**
   * @description 根据教师编号获取项目卡片
   *
   * @param tid 教师编号
   * @param term 学期
   * @return 项目卡片
   * @author suwen
   * @date 2020/5/27 上午10:53
   */
  getProjects(tid: string, term: string): Observable<result> {
    const url = `${this.PROJECT_API}/getProject`;


    return this.http.get<result>(url, {params: {tid, term}}).pipe(
      tap(response => {
        if (response.success) {
          this.success(response.message);
        } else {
          this.error(`根据教师编号获取项目卡片失败，教师编号：${tid}`);
        }
      }),
      catchError(this.handleError<result>(`根据教师编号获取项目卡片失败,教师编号${tid}`))
    );
  }

  /**
   * @description 根据教师编号获取项目卡片项
   *
   * @param proId 项目卡片编号
   * @return 项目卡片项
   * @author suwen
   * @date 2020/5/27 上午10:55
   */
  getProjectItems(proId: number): Observable<result> {
    const url = `${this.ITEM_API}/getProjectItem/${proId}`;
    return this.http.get<result>(url).pipe(
      tap(response => {
        if (response.success) {
          this.success(response.message);
        } else {
          this.error(`根据教师编号获取项目卡片项，项目卡片编号：${proId}`);
        }
      }),
      catchError(this.handleError<result>(`根据教师编号获取项目卡片项，项目卡片编号：${proId}`))
    );
  }

}
