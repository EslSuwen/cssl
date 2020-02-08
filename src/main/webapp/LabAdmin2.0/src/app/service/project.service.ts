import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Exp, ProjectItem} from '../side-nav/card/enity';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  constructor(
    // HttpClient 是 Angular 通过 HTTP 与远程服务器通讯的机制
    private http: HttpClient
  ) {
  }

  // 发送给服务端的api。端口为server.port
  private api = 'http://localhost:8090/project/';

  private item_api = 'http://localhost:8090/projectItem/';

  // 观察者模式方法。用post方法发送Demo类型数据，并等待返回的信息
  // 返回的是json格式，可以在本地建立数据模型，这里用any类型接受
  addToDatabase(project: Exp): Observable<any> {
    return this.http.post<any>(this.api + 'newData/', project);
  }

  getProjects(): Observable<Exp[]> {
    return this.http.get<Exp[]>(this.api + 'getProject/');
  }

  clearDatabase(): Observable<any> {
    return this.http.delete(this.api + 'clearData/');
  }

  getProjectItems(proId: number): Observable<ProjectItem[]> {
    // @ts-ignore
    return this.http.get<ProjectItem[]>(this.item_api + 'getProjectItem/' + proId);

  }
}
