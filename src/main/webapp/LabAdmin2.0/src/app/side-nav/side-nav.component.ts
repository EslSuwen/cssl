import {Component, OnInit} from '@angular/core';

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

  constructor() {
  }

  ngOnInit() {

  }

  logout() {

  }
}

