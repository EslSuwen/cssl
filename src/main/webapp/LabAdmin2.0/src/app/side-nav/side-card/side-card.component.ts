import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-side-card',
  templateUrl: './side-card.component.html',
  styleUrls: ['./side-card.component.scss']
})
export class SideCardComponent implements OnInit {
  isclick:boolean;
  constructor() { }

  ngOnInit() {
    this.isclick=false;
  }
  is_click(){
    this.isclick=!this.isclick;
  }

}
