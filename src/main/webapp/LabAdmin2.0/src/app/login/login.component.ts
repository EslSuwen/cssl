import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {environment} from "../../environments/environment";
import {AuthenticationService} from "../service/authentication.service";
import {MessageService} from "../service/message.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  validationForm: FormGroup;
  authModel: any = {};
  imgUrl: string = `${environment.apiUrl}/login/createImageCode`;

  constructor(
    public fb: FormBuilder,
    public router: Router,
    private authenticationService: AuthenticationService,
    private messageService: MessageService
  ) {
    this.validationForm = fb.group({
      userFormEx: [null, [Validators.required]],
      passwordFormEx: [null, Validators.required],
    });
  }

  get userFormEx() {
    return this.validationForm.get('userFormEx');
  }

  get passwordFormEx() {
    return this.validationForm.get('passwordFormEx');
  }

  onSubmit() {
    // this.validationForm.controls.input.markAsTouched();
  }

  ngOnInit() {
    this.authenticationService.logout();

  }

  login() {
    this.authenticationService.login(this.authModel.username, this.authModel.password)
      .subscribe(result => {
        if (result) {
          // login successful
          this.router.navigate(['sidenav/personalinfo']);
        } else {
          // login failed
          this.log('Username or password is incorrect');
        }
      });
  }

  private log(message: string) {
    this.messageService.add('Login: ' + message);
  }

  refresh() {
    this.imgUrl = this.imgUrl + '?' + Math.random();
  }
}
