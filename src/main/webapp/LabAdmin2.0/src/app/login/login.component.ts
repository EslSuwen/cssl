import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { environment } from "../../environments/environment";
import { AuthenticationService } from "../service/authentication.service";
import { MessageService } from "../service/message.service";
import { ModalComponent } from '../modal/modal.component';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  @ViewChild('demoBasic', { static: true }) failing: ModalComponent;
  @ViewChild('demoBasi1', { static: true }) success: ModalComponent;
  validationForm: FormGroup;
  authModel: any = {};
  imgUrl: string = `${environment.apiUrl}/api/createImageCode`;
  username: string;
  constructor(

    public fb: FormBuilder,
    public router: Router,
    private authenticationService: AuthenticationService,
    private messageService: MessageService
  ) {
    this.validationForm = fb.group({
      userFormEx: [null, [Validators.required]],
      passwordFormEx: [null, Validators.required],
      codeFormEx: [null, Validators.required],
    });
  }

  get userFormEx() {
    return this.validationForm.get('userFormEx');
  }

  get passwordFormEx() {
    return this.validationForm.get('passwordFormEx');
  }
  get codeFormEx() {
    return this.validationForm.get('codeFormEx');
  }

  onSubmit() {
    // this.validationForm.controls.input.markAsTouched();
  }

  ngOnInit() {
    this.authenticationService.logout();

  }

  login() {
    this.authenticationService.login(this.authModel.username, this.authModel.password, this.authModel.imgCode)
      .subscribe(result => {
        this.username = this.authenticationService.getUsername();// 判断验证码是否输入正确
        const judge = this.authenticationService.isLoggedIn();  
        if (result) {
          // login successful
          // this.router.navigate(['sidenav/personalinfo']);
          if (judge) {
            this.showAndHideModal1();
            
            }else{
              alert('验证码错误');//验证码输入错误
          }

        } else {
          // login failed
          this.log('Username or password is incorrect');
          this.showAndHideModal();
        }
      });
  }

  private log(message: string) {
    this.messageService.add('Login: ' + message);
  }

  refresh() {
    this.imgUrl = this.imgUrl + '?' + Math.random();
  }
  showAndHideModal() {   //登录失败显示的模态
    this.failing.show();

    setTimeout(() => {
      this.failing.hide();
    }, 3000);
  }
  showAndHideModal1() {   //登录成功显示的模态
    this.success.show();
  }
  successlogin() {  //输入正确，确认进入
    this.router.navigate(['sidenav/personalinfo']);
  }
}
