
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';
import { RouterModule, Routes } from '@angular/router';


import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AngularMultiSelectModule } from 'angular2-multiselect-dropdown';
import { OwlDateTimeModule, OwlNativeDateTimeModule, OWL_DATE_TIME_LOCALE } from 'ng-pick-datetime';
// import {NoopAnimationsModule} from '@angular/platform-browser/animations';
import { Ng2FileInputModule } from 'ng2-file-input';
import { RECAPTCHA_V3_SITE_KEY, RecaptchaV3Module } from 'ng-recaptcha';
import { HttpClientModule } from '@angular/common/http';

import { LoginComponent } from './login/login.component';
import { SideNavComponent } from './side-nav/side-nav.component';
import { PersonalInfoComponent } from './side-nav/personal-info/personal-info.component';
import { NotifyComponent } from './side-nav/notify/notify.component';
import { UploadComponent } from './side-nav/upload/upload.component';
import { CardComponent } from './side-nav/card/card.component';
import { TeachTableComponent } from './side-nav/teach-table/teach-table.component';
import { ApplyComponent } from './side-nav/apply/apply.component';
import { FooterComponent } from './footer/footer.component';
import { SideCardComponent } from './side-nav/side-card/side-card.component';
import { ApplyExpRoomComponent } from './apply-exp-room/apply-exp-room.component';
import { UpdatePasswordComponent } from './update-password/update-password.component';
import { AuthGuard } from './auth/auth.guard';
import { ModalComponent } from './modal/modal.component';


const appRoutes: Routes = [
  { path: 'login', component: LoginComponent },
  {
    path: 'sidenav', component: SideNavComponent,
    // canActivate: [AuthGuard],
    children: [
      { path: 'personalinfo', component: PersonalInfoComponent, },
      { path: 'notify', component: NotifyComponent, },
      { path: 'upload', component: UploadComponent, },
      { path: 'card', component: CardComponent, },
      { path: 'teachtable', component: TeachTableComponent, },
      { path: 'apply', component: ApplyComponent, },
      { path: 'applyexproom', component: ApplyExpRoomComponent, },
      { path: 'updatepassword', component: UpdatePasswordComponent, },
    ],

  },
  {
    path: '', // 默认路由
    redirectTo: '/login',
    pathMatch: 'full'
  }];
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
  ],
  imports: [
    BrowserModule,
    // NoopAnimationsModule,
    BrowserAnimationsModule,
    MDBBootstrapModule.forRoot(),
    FormsModule,
    ReactiveFormsModule,
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
  ],
  entryComponents: [ModalComponent],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
