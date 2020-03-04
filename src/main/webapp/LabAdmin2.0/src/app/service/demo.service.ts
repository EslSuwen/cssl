/*
import {Injectable} from '@angular/core';
import {Observable, of} from "rxjs";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {MessageService} from "./message.service";
import {catchError, tap} from "rxjs/operators";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class DemoService {

  constructor(
    //HttpClient 是 Angular 通过 HTTP 与远程服务器通讯的机制
    private http: HttpClient,
    private messageService: MessageService
  ) {
  }

  // 发送给服务端的api。端口为server.port
  private api = `${environment.apiUrl}/demo/`;

  // 观察者模式方法。用post方法发送Demo类型数据，并等待返回的信息
  // 返回的是json格式，可以在本地建立数据模型，这里用any类型接受
  addToDatabase(demodata: Demo): Observable<any> {
    return this.http.post<any>(this.api + 'newConData/', demodata).pipe(
      tap((newDemo: Demo) => this.log(`added hero w/ id=${newDemo.id}`)),
      catchError(this.handleError<Demo>('addHero'))
    );
  }

  checkDatabase(): Observable<Demo[]> {
    return this.http.get<Demo[]>(this.api + 'getConData/');
  }

  clearDatabase(): Observable<any> {
    return this.http.delete(this.api + 'clearData/')
  }

  /!** GET heroes from the server *!/
  getHeroes(): Observable<Demo[]> {
    return this.http.get<Demo[]>(this.api + "getData")
      .pipe(
        tap(() => this.log('fetched data')),
        catchError(this.handleError<Demo[]>('getHeroes', []))
      );
  }


  /!** GET hero by id. Will 404 if id not found *!/
  getHero(id: number): Observable<Demo> {
    const url = `${this.api}getOneData/${id}`;
    return this.http.get<Demo>(url).pipe(
      tap(() => this.log(`fetched hero id=${id}`)),
      catchError(this.handleError<Demo>(`getHero id=${id}`))
    );
  }

  /!* GET heroes whose name contains search term *!/
  searchHeroes(term: string): Observable<Demo[]> {
    if (!term.trim()) {
      // if not search term, return empty hero array.
      return of([]);
    }
    return this.http.get<Demo[]>(`${this.api}/?name=${term}`).pipe(
      tap(() => this.log(`found heroes matching "${term}"`)),
      catchError(this.handleError<Demo[]>('searchHeroes', []))
    );
  }

  //////// Save methods //////////

  /!** POST: add a new hero to the server *!/
  addHero(demo: Demo): Observable<Demo> {
    return this.http.post<Demo>(this.api + "newData", demo, httpOptions).pipe(
      tap((newDemo: Demo) => this.log(`added hero w/ id=${newDemo.id}`)),
      catchError(this.handleError<Demo>('addHero'))
    );
  }

  /!** DELETE: delete the hero from the server *!/
  deleteHero(demo: Demo | number): Observable<Demo> {
    const id = typeof demo === 'number' ? demo : demo.id;
    const url = `${this.api}clearData/${id}`;

    return this.http.delete<Demo>(url, httpOptions).pipe(
      tap(() => this.log(`deleted hero id=${id}`)),
      catchError(this.handleError<Demo>('deleteHero'))
    );
  }

  /!** PUT: update the hero on the server *!/
  updateHero(demo: Demo): Observable<any> {
    return this.http.put(this.api, demo, httpOptions).pipe(
      tap(() => this.log(`updated hero id=${demo.id}`)),
      catchError(this.handleError<any>('updateHero'))
    );
  }

  /!**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   *!/
  private handleError<T>(operation = 'operation', result?: T) {
    return (errorResponse: any): Observable<T> => {
      console.error(errorResponse.error); // log to console instead

      this.log(`${operation} failed: ${errorResponse.error.message}`);

      // Let the app keep running by returning an empty result.
      if (result) {
        return of(result as T);
      }

      return of();
    };
  }

  /!** Log a HeroService message with the MessageService *!/
  private log(message: string) {
    this.messageService.add(`DemoService: ${message}`);
  }
}
*/
