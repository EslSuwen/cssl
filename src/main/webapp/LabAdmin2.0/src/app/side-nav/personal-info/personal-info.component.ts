import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-personal-info',
  templateUrl: './personal-info.component.html',
  styleUrls: ['./personal-info.component.scss']
})
export class PersonalInfoComponent implements OnInit {
  elements: any = [
    {id: '第一大节', first: 'Ma11111111111rk', last: 'Ot1111111to', handle: '111111@mdo', handle2: '111111@mdo', handle3: '111111@mdo'},
    {id: '第二大节', first: 'Jacob', last: 'Thornton', handle: '@fat'},
    {id: '第三大节', first: 'Larry', last: 'the Bird', handle: '@twitter'},
    {id: '第四大节', first: 'Larry', last: 'the Bird', handle: '@twitter'},
    {id: '晚上第一大节', first: 'Larry', last: 'the Bird', handle: '@twitter'},
    {id: '晚上第二大节', first: 'Larry', last: 'the Bird', handle: '@twitter'},

  ];

  headElements = ['节数/星期', '星期一', '星期二', '星期三', '星期四', '星期五', ];

  constructor() { }

  ngOnInit() {
  }

}
