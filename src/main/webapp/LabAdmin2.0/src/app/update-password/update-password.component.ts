import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from "../service/authentication.service";
import {TeacherService} from "../service/teacher.service";

@Component({
  selector: 'app-update-password',
  templateUrl: './update-password.component.html',
  styleUrls: ['./update-password.component.scss']
})
export class UpdatePasswordComponent implements OnInit {

  oldPw: string='';
  newPw: string='';

  constructor(private authenticationService: AuthenticationService,
              private teacherService: TeacherService,) {
  }

  ngOnInit() {
  }

  resolved(captchaResponse: string) {
    console.log(`Resolved captcha with response: ${captchaResponse}`);
  }

  updatePassword() {
    this.teacherService.updatePassword(this.authenticationService.getUserNo(), this.oldPw, this.newPw).subscribe(code => {
      switch (code) {
        case 1:
          console.log('修改密码成功！');
          break;
        case -1:
          console.log('原密码输入错误！');
          break;
        case 0:
          console.log('修改失败！');
          break;
        default:
          console.log('意料之外的错误！')
      }
    });
  }
}
