import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Teach} from '../side-nav/apply/apply'

@Injectable({
  providedIn: 'root'
})
export class ApplyService {

  constructor(private http: HttpClient
  ) {
  }

  // 发送给服务端的api。端口为server.port
  private arrange_api = 'http://localhost:8090/arrange/';

  private teach_api = 'http://localhost:8090/teach/';

  // 观察者模式方法。用post方法发送Demo类型数据，并等待返回的信息
  // 返回的是json格式，可以在本地建立数据模型，这里用any类型接受
  addToDatabase(teach: Teach): Observable<any> {
    return this.http.post<any>(this.arrange_api + 'add/', teach);
  }

  getArranges(): Observable<Teach[]> {
    return this.http.get<Teach[]>(this.teach_api + 'getTeachInfo/256740953460');
  }

  clearDatabase(): Observable<any> {
    return this.http.delete(this.arrange_api + 'clearData/');
  }

}
