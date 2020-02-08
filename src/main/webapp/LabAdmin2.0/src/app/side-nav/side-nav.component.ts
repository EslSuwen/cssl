import { Component, OnInit, ViewChild } from '@angular/core';
import { AuthService } from '../auth/auth.service';

@Component({
  selector: 'app-side-nav',
  templateUrl: './side-nav.component.html',
  styleUrls: ['./side-nav.component.scss'],
})

export class SideNavComponent implements OnInit {

  toggleFlag = true;
  onToggle() {
    this.toggleFlag = (this.toggleFlag === true) ? false : true;
  }
  constructor(public authService: AuthService, ) { }

  ngOnInit() {

  }
  logout() {
    this.authService.logout();
  }
}

