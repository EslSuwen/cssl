import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Teach} from '../enity/teacher';
import {Arrange} from '../enity/arrange';
import {NzMessageService} from 'ng-zorro-antd';
import {MESSAGETEXTS} from '../const/MessageConsts';
import {catchError, tap} from 'rxjs/operators';
import {HandleError} from './handle-error';

@Injectable({
  providedIn: 'root'
})
export class ApplyService extends HandleError {

  constructor(private http: HttpClient,
              message: NzMessageService) {
    super(message);
  }

  private ARRANGE_API = `${environment.apiUrl}/arrange`;
  private TEACH_API = `${environment.apiUrl}/teach`;

  addToDatabase(teach: Teach): Observable<any> {
    return this.http.post<any>(this.ARRANGE_API + 'add/', teach);
  }

  /**
   * 新增实验时间安排
   *
   * @param arrange  时间安排
   * @return 执行结果（true: 成功；false: 失败）
   * @author suwen
   * @date 2020/5/27 上午9:53
   */
  addArrange(arrange: Arrange): Observable<boolean> {
    const url = `${this.ARRANGE_API}/addArrange`;
    return this.http.post<any>(url, arrange).pipe(
      tap(response => {
          if (response.success) {
            this.success(MESSAGETEXTS.FETCH_SUCCESS);
          } else {
            this.error('新增实验时间安排失败');
          }
        }
      ),
      catchError(this.handleError<boolean>('新增实验时间安排', false))
    );
  }

  getArranges(): Observable<Teach[]> {
    return this.http.get<Teach[]>(this.TEACH_API + '/getTeachInfo/256740953460');
  }

  clearDatabase(): Observable<any> {
    return this.http.delete(this.ARRANGE_API + '/clearData/');
  }

}
