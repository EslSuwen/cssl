import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-teach-table',
  templateUrl: './teach-table.component.html',
  styleUrls: ['./teach-table.component.scss']
})
export class TeachTableComponent implements OnInit {
  public planitem: any = {
    year: '2019-2020',
  };
  headElements = ['ID', 'First', 'Last', 'Handle'];
  elements: any = [
    {
      id: 1, expName: 'Mark', major: 'Otto', grade: '@mdo', class: 'Mark', courseCode: 'Otto', courseName: '@mdo', time: '64',
      beginToEnd: '1-18', college: '信息学院', region: '1-18', teacher: '信息学院', courseType: '1-18', remark: '信息学院',
    },
    {
      id: 2, expName: 'Mark', major: 'Otto', grade: '@mdo', class: 'Mark', courseCode: 'Otto', courseName: '@mdo', time: '64',
      beginToEnd: '1-18', college: '信息学院', region: '1-18', teacher: '信息学院', courseType: '1-18', remark: '信息学院',
    },
    {
      id: 3, expName: 'Mark', major: 'Otto', grade: '@mdo', class: 'Mark', courseCode: 'Otto', courseName: '@mdo', time: '64',
      beginToEnd: '1-18', college: '信息学院', region: '1-18', teacher: '信息学院', courseType: '1-18', remark: '信息学院',
    },
    {
      id: 1, expName: 'Mark', major: 'Otto', grade: '@mdo', class: 'Mark', courseCode: 'Otto', courseName: '@mdo', time: '64',
      beginToEnd: '1-18', college: '信息学院', region: '1-18', teacher: '信息学院', courseType: '1-18', remark: '信息学院',
    },
    {
      id: 2, expName: 'Mark', major: 'Otto', grade: '@mdo', class: 'Mark', courseCode: 'Otto', courseName: '@mdo', time: '64',
      beginToEnd: '1-18', college: '信息学院', region: '1-18', teacher: '信息学院', courseType: '1-18', remark: '信息学院',
    },
    {
      id: 3, expName: 'Mark', major: 'Otto', grade: '@mdo', class: 'Mark', courseCode: 'Otto', courseName: '@mdo', time: '64',
      beginToEnd: '1-18', college: '信息学院', region: '1-18', teacher: '信息学院', courseType: '1-18', remark: '信息学院',
    },
    {
      id: 1, expName: 'Mark', major: 'Otto', grade: '@mdo', class: 'Mark', courseCode: 'Otto', courseName: '@mdo', time: '64',
      beginToEnd: '1-18', college: '信息学院', region: '1-18', teacher: '信息学院', courseType: '1-18', remark: '信息学院',
    },
    {
      id: 2, expName: 'Mark', major: 'Otto', grade: '@mdo', class: 'Mark', courseCode: 'Otto', courseName: '@mdo', time: '64',
      beginToEnd: '1-18', college: '信息学院', region: '1-18', teacher: '信息学院', courseType: '1-18', remark: '信息学院',
    },
    {
      id: 3, expName: 'Mark', major: 'Otto', grade: '@mdo', class: 'Mark', courseCode: 'Otto', courseName: '@mdo', time: '64',
      beginToEnd: '1-18', college: '信息学院', region: '1-18', teacher: '信息学院', courseType: '1-18', remark: '信息学院',
    },
  ];
  constructor() { }

  ngOnInit() {
  }

}