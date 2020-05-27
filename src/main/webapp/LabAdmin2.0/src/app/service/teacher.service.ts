import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';
import {Teach, Teacher, TeacherMsg} from '../enity/teacher';
import {catchError, tap} from 'rxjs/operators';
import {Curriculum} from '../enity/arrange';
import {HandleError} from './handle-error';
import {NzMessageService} from 'ng-zorro-antd';
import {MESSAGETEXTS} from '../const/MessageConsts';
import { result } from '../enity/result';

@Injectable({
  providedIn: 'root'
})
export class TeacherService extends HandleError {

  constructor(private http: HttpClient, message: NzMessageService) {
    super(message);
  }

  private TEACHER_API = `${environment.apiUrl}/teacher`;
  private TEACH_API = `${environment.apiUrl}/teach`;


  /**
   * @description 根据教师编号获得教师信息
   *
   * @param tid 教师编号
   * @return 教师信息
   * @author suwen
   * @date 2020/5/27 下午2:02
   */
  getTeacherInfo(tid: string): Observable<Teacher> {
    const url = `${this.TEACHER_API}/getTeacherInfo/${tid}`;
    return this.http.get<any>(url).pipe(
      tap(response => {
          if (response.success) {
            this.success(MESSAGETEXTS.FETCH_SUCCESS);
          } else {
            this.error('根据教师编号获得教师信息失败');
          }
        }
      ),
      catchError(this.handleError<Teacher>(`根据教师编号获得教师信息，教师编号为：${tid}`, null))
    );
  }

  /**
   * @description 根据教师编号获得教师授课信息
   *
   * @param tid 教师编号
   * @return 教师授课信息
   * @author suwen
   * @date 2020/5/27 下午2:04
   */
  getTeaches(tid: string): Observable<Teach[]> {
    const url = `${this.TEACH_API}/getTeachInfo/${tid}`;
    return this.http.get<any>(url).pipe(
      tap(response => {
          if (response.success) {
            this.success(MESSAGETEXTS.FETCH_SUCCESS);
            return response.data;
          } else {
            this.error('根据教师编号获得教师信息失败');
            return [];
          }
        }
      ),
      catchError(this.handleError<Teach[]>(`根据教师编号获得教师信息，教师编号为：${tid}`, []))
    );
  }

  /**
   * @description 根据教师编号获得消息
   *
   * @param tid 教师编号
   * @return 消息
   * @author suwen
   * @date 2020/5/27 下午2:08
   */
  getMsgInfo(tid: string): Observable<TeacherMsg[]> {
    const url = `${this.TEACHER_API}/getMsgInfo/${tid}`;
    return this.http.get<any>(url).pipe(
      tap(response => {
          if (response.success) {
            this.success(MESSAGETEXTS.FETCH_SUCCESS);
            return response.data;
          } else {
            this.error('根据教师编号获得教师信息失败');
            return [];
          }
        }
      ),
      catchError(this.handleError<TeacherMsg[]>(`getMsgInfo id=${tid}`))
    );
  }

  /**
   * @description 根据消息编号已读消息
   *
   * @param mid 消息编号
   * @return 执行结果（true: 成功；false: 失败）
   * @author suwen
   * @date 2020/5/27 下午2:12
   */
  readMsg(mid: number): Observable<boolean> {
    const url = `${this.TEACHER_API}/readMsg/${mid}`;
    return this.http.get<any>(url).pipe(
      tap(response => {
          if (response.success) {
            this.success(MESSAGETEXTS.FETCH_SUCCESS);
            return true;
          } else {
            this.error('根据消息编号已读消息失败');
            return false;
          }
        }
      ),
      catchError(this.handleError<boolean>(`根据消息编号已读消息失败, mid=${mid}`, false))
    );
  }

  /**
   * @description 根据消息编号删除消息
   *
   * @param mid 消息编号
   * @return 执行结果（true: 成功；false: 失败）
   * @author suwen
   * @date 2020/5/27 下午2:15
   */
  deleteMsg(mid: number): Observable<boolean> {
    const url = `${this.TEACHER_API}/deleteMsg/${mid}`;
    return this.http.get<any>(url).pipe(
      tap(response => {
          if (response.success) {
            this.success(MESSAGETEXTS.FETCH_SUCCESS);
            return true;
          } else {
            this.error('根据消息编号删除消息失败');
            return false;
          }
        }
      ),
      catchError(this.handleError<boolean>(`根据消息编号删除消息, mid=${mid}`, false))
    );
  }

  /**
   * @description 用户更新密码
   *
   * @param tid 教师密码
   * @param oldPw 当前密码
   * @param newPw 新密码
   * @return 执行结果（true: 成功；false: 失败）
   * @author suwen
   * @date 2020/5/27 下午2:16
   */
  updatePassword(tid: string, oldPw: string, newPw: string): Observable<boolean> {
    const url = this.TEACHER_API + '/updatePassword';
    return this.http.get<any>(url, {
      params: {
        tid, oldPw, newPw
      }
    }).pipe(
      tap(response => {
          if (response.success) {
            this.success(MESSAGETEXTS.FETCH_SUCCESS);
            return true;
          } else {
            this.error('用户更新密码消息失败');
            return false;
          }
        }
      ),
      catchError(this.handleError<boolean>(`用户更新密码, tid=${tid}`, false))
    );
  }

  /**
   * @description 获取教师某周的排课信息
   *
   * @param tid 教师编号
   * @param week 周次
   * @return 排课信息
   * @author suwen
   * @date 2020/5/27 下午2:18
   */
  getCurriculum(tid: string, week: string): Observable<result> {
    const url = this.TEACHER_API + '/getCurriculum';
    return this.http.get<any>(url, {
      params: {
        tid, week
      }
    }).pipe(
      tap(response => {
          if (response.success) {
            this.success(response.message);
          } else {
            this.error('获取教师某周的排课信息失败');
          }
        }
      ),
      catchError(this.handleError<result>(`获取教师某周的排课信息, tid= ${tid},week= ${week}`))
    );
  }


}
