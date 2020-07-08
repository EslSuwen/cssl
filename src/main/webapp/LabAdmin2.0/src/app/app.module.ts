import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {AppComponent} from './app.component';
import {RouterModule, Routes} from '@angular/router';


import {MDBBootstrapModule} from 'angular-bootstrap-md';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {AngularMultiSelectModule} from 'angular2-multiselect-dropdown';
import {OwlDateTimeModule, OwlNativeDateTimeModule} from 'ng-pick-datetime';
import { QuillModule } from 'ngx-quill';

// import {NoopAnimationsModule} from '@angular/platform-browser/animations';
import {Ng2FileInputModule} from 'ng2-file-input';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';

import {LoginComponent} from './login/login.component';
import {SideNavComponent} from './side-nav/side-nav.component';
import {PersonalInfoComponent} from './side-nav/personal-info/personal-info.component';
import {NotifyComponent} from './side-nav/notify/notify.component';
import {UploadComponent} from './side-nav/upload/upload.component';
import {CardComponent} from './side-nav/card/card.component';
import {TeachTableComponent} from './side-nav/teach-table/teach-table.component';
import {ApplyComponent} from './side-nav/apply/apply.component';
import {FooterComponent} from './side-nav/footer/footer.component';
import {SideCardComponent} from './side-nav/side-card/side-card.component';
import {ApplyExpRoomComponent} from './apply-exp-room/apply-exp-room.component';
import {UpdatePasswordComponent} from './side-nav/update-password/update-password.component';
import {ModalComponent} from './modal/modal.component';
import {HasRoleDirective} from './auth/has-role.directive';
import {CanActivateAuthGuard} from "./auth/can-activate.authguard";
import {AuthenticationInterceptor} from "./auth/authentication-interceptor";
import {MessageComponent} from './side-nav/message/message.component';
import {NgZorroAntdModule, NZ_I18N, zh_CN} from 'ng-zorro-antd';
import {registerLocaleData} from '@angular/common';
import zh from '@angular/common/locales/zh';
import {ApplyManageComponent} from './side-nav/apply-manage/apply-manage.component';
import {Code404Component} from './code404/code404.component';
import {AuditLabComponent} from './side-nav/audit-lab/audit-lab.component';
import { FutextComponent } from './side-nav/futext/futext.component';

registerLocaleData(zh);


const appRoutes: Routes = [
  {
    path: '', // 默认路由
    redirectTo: '/login',
    pathMatch: 'full'
  },
  {path: 'login', component: LoginComponent},
  {
    path: 'sidenav', component: SideNavComponent,
    canActivate: [CanActivateAuthGuard],
    children: [
      {path: 'personalinfo', component: PersonalInfoComponent,},
      {path: 'notify', component: NotifyComponent,},
      {path: 'upload', component: UploadComponent,},
      {path: 'card', component: CardComponent,},
      {path: 'teachtable', component: TeachTableComponent,},
      {path: 'apply', component: ApplyComponent,},
      {path: 'applyexproom', component: ApplyExpRoomComponent,},
      {path: 'updatepassword', component: UpdatePasswordComponent,},
      {path: 'message', component: MessageComponent,},
      {path: "futext", component: FutextComponent},


      {path: "**", component: Code404Component},
      {path: "audit-lab", component: AuditLabComponent},
    ],
  },
  {path: "**", component: Code404Component},];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SideNavComponent,
    PersonalInfoComponent,
    NotifyComponent,
    UploadComponent,
    CardComponent,
    TeachTableComponent,
    ApplyComponent,
    FooterComponent,
    SideCardComponent,
    ApplyExpRoomComponent,
    UpdatePasswordComponent,
    ModalComponent,
    HasRoleDirective,
    MessageComponent,
    ApplyManageComponent,
    Code404Component,
    AuditLabComponent,
    FutextComponent,
  ],
  imports: [
    BrowserModule,
    // NoopAnimationsModule,
    BrowserAnimationsModule,
    MDBBootstrapModule.forRoot(),
    FormsModule,
    ReactiveFormsModule,
    FormsModule,
    QuillModule.forRoot(),  //新版的要这么引入
    RouterModule.forRoot(
      appRoutes,
    ),
    AngularMultiSelectModule,
    OwlDateTimeModule,
    OwlNativeDateTimeModule,
    Ng2FileInputModule.forRoot({
      // dropText: 'Drop file here',
      browseText: '选择',
      removeText: '删除',
      invalidFileText: '你上传了其他类型的文件',
      invalidFileTimeout: 8000,
      removable: true,
      multiple: false,
      showPreviews: true
    }),
    HttpClientModule,
    NgZorroAntdModule,
  ],
  entryComponents: [ModalComponent],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: AuthenticationInterceptor, multi: true}, {
    provide: NZ_I18N,
    useValue: zh_CN
  }],
  bootstrap: [AppComponent]
})
export class AppModule {
}
