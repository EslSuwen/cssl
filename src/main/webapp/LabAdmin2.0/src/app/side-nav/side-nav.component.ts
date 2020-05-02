import { Component, OnInit,ViewChild } from '@angular/core';
import { AuthenticationService } from "../service/authentication.service";
import { MessageComponent } from './message/message.component';
@Component({
  selector: 'app-side-nav',
  templateUrl: './side-nav.component.html',
  styleUrls: ['./side-nav.component.scss'],
})

export class SideNavComponent implements OnInit {
  @ViewChild('MessageComponent', {static: true})  
  public messageComponent: MessageComponent;
  toggleFlag = true;
  userName = '';
  messagenum:number
  onToggle() {
    this.toggleFlag = (this.toggleFlag === true) ? false : true;
    this.getMessagenum();
  }

  constructor(private authenticationService: AuthenticationService) {
  }

  ngOnInit() {

    this.userName = this.authenticationService.getUserName();

  }
  getMessagenum(){  //父子组件之间进行传值
    this.messagenum=this.messageComponent.have_read;
    console.log(this.messagenum)
  }
  logout() {
  }
}

