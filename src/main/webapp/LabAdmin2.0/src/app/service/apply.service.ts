import {Injectable} from '@angular/core';
import {Observable, of} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Teach} from '../side-nav/apply/apply'
import {environment} from "../../environments/environment";
import {log} from "util";
import {MessageService} from "./message.service";

@Injectable({
  providedIn: 'root'
})
export class ApplyService {

  constructor(private http: HttpClient,
              private messageService: MessageService
  ) {
  }

  private arrange_api = `${environment.apiUrl}/arrange/`;

  private teach_api = `${environment.apiUrl}/teach/`;

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

  private handleError<T>(operation = 'operation', result?: T) {
    return (errorResponse: any): Observable<T> => {
      console.error(errorResponse.error); // log to console instead

      log(`${operation} failed: ${errorResponse.error.message}`);

      // Let the app keep running by returning an empty result.
      if (result) {
        return of(result as T);
      }

      return of();
    }
  }

  private log(message: string) {
    this.messageService.add(`DemoService: ${message}`);
  }
}
