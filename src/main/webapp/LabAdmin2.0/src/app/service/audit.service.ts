import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {Exp} from "../enity/project";
import {Arrange} from "../enity/arrange";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class AuditService {


  constructor(
    private http: HttpClient
  ) {
  }

  private PROJECT_API = `${environment.apiUrl}/project`;
  private ARRANGE_API = `${environment.apiUrl}/arrange`;

  /**
   * @description 获取待审核卡片数据
   *
   * @author suwen
   * @date 2020/5/23 下午7:17
   */
  getAuditProjects(): Observable<Exp[]> {
    const url = `${this.PROJECT_API}/getAuditProject`
    return this.http.get<Exp[]>(url);
  }

  
  /**
   * @description 审核卡片
   *
   * @param proId 卡片编号
   * @param status 审核结果（1：通过；0：拒绝）
   * @return 执行结果（true: 成功；false: 失败）
   * @author suwen
   * @date 2020/5/23 下午7:19
   */
  auditProject(proId: number, status: string): Observable<boolean> {
    const url = `${this.PROJECT_API}/auditProject`
    return this.http.get<boolean>(url, {
      params: {
        "proId": ''+proId,
        "status": status
      }
    });
  }

  /**
   * @description 获取待审核实验室时间安排数据
   *
   * @author suwen
   * @date 2020/5/23 下午7:17
   */
  getAuditArrange(): Observable<Arrange[]> {
    const url = `${this.ARRANGE_API}/auditArrange`
    return this.http.get<Arrange[]>(url);
  }

  /**
   * @description 审核实验室时间安排
   *
   * @param aid 实验室时间安排编号
   * @param status 审核结果（1：通过；0：拒绝）
   * @return 执行结果（true: 成功；false: 失败）
   * @author suwen
   * @date 2020/5/23 下午7:19
   */
  auditArrange(aid: string, status: string): Observable<boolean> {
    const url = `${this.ARRANGE_API}/auditProject`
    return this.http.get<boolean>(url, {
      params: {
        "aid": aid,
        "status": status
      }
    });
  }
}
