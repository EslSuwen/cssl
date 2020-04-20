import { Component, OnInit } from '@angular/core';
import { TeacherService } from "../../service/teacher.service";
import { TeacherMsg } from "../../enity/teacher";
import { AuthenticationService } from "../../service/authentication.service";

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.scss']
})
export class MessageComponent implements OnInit {
  teacherMsgs: TeacherMsg[];
  x: TeacherMsg;
  have_read = 0;
  constructor(private authenticationService: AuthenticationService, private teacherService: TeacherService) {
  }

  ngOnInit() {
    this.teacherService.getMsgInfo(this.authenticationService.getUserNo()).subscribe(data => {
      this.teacherMsgs = data;
    });
  }

  isreaded(id: number) {
    this.teacherMsgs[id].mstatus = 1;
    this.teacherService.readMsg(this.teacherMsgs[id].mid).subscribe();
  }

  deleteMsg(id: number) {
    this.teacherService.deleteMsg(this.teacherMsgs[id].mid).subscribe();
    this.teacherMsgs.splice(id, 1);
  }
  getMessagenum() {  //遍历消息
    for (this.x of this.teacherMsgs) {
      if (this.x.mstatus == 1) {  //这里值应该设为0，我在这里只是测试
        this.have_read++;
      }
      console.log(this.have_read)

    }
  }

}
