import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthService } from '../auth/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  validationForm: FormGroup;
  img: any;
  constructor(
    public fb: FormBuilder,
    public authService: AuthService,
    public router: Router,
  ) {
    this.validationForm = fb.group({
      userFormEx: [null, [Validators.required]],
      passwordFormEx: [null, Validators.required],
    });
  }
  get userFormEx() { return this.validationForm.get('userFormEx'); }
  get passwordFormEx() { return this.validationForm.get('passwordFormEx'); }
  onSubmit() {
    // this.validationForm.controls.input.markAsTouched();
  }
  ngOnInit() {
    this.img = 'http://localhost:8090/login/createImageCode';

  }
  login() {

    this.authService.login().subscribe(() => {
      if (this.authService.isLoggedIn) {
        // Get the redirect URL from our auth service
        // If no redirect has been set, use the default
        const redirect = this.authService.redirectUrl ? this.router.parseUrl(this.authService.redirectUrl) : '/sidenav/personalinfo';

        // Redirect the user
        this.router.navigateByUrl(redirect);
      }
    });
  }
  refresh() {
    this.img = 'http://localhost:8090/login/createImageCode' + '?' + Math.random();
  }
}
