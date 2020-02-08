import {Component, OnInit} from '@angular/core';
import {ModalComponent} from 'src/app/modal/modal.component';
import {MDBModalRef, MDBModalService} from 'angular-bootstrap-md';
import {ProjectService} from 'src/app/service/project.service';
import {Exp, ProjectItem} from './enity';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})
export class CardComponent implements OnInit {
  modalRef: MDBModalRef;
  exps: Exp[];
  projectItems: ProjectItem[];

  elements: any = [
    {id: 1, first: 'Mark', last: 'Otto', handle: '@mdo'},
    {id: 2, first: 'Jacob', last: 'Thornton', handle: '@fat'},
    {id: 3, first: 'Larry', last: 'the Bird', handle: '@twitter'},
  ];
  headElements = ['ID', 'First', 'Last', 'Handle'];
  editField: string;
  personList: Array<any> = [
    {id: 1, name: 'Aurelia Vega', age: 30, companyName: 'Deepends', country: 'Spain', city: 'Madrid'},
    {id: 2, name: 'Guerra Cortez', age: 45, companyName: 'Insectus', country: 'USA', city: 'San Francisco'},
    {id: 3, name: 'Guadalupe House', age: 26, companyName: 'Isotronic', country: 'Germany', city: 'Frankfurt am Main'},
    {id: 4, name: 'Aurelia Vega', age: 30, companyName: 'Deepends', country: 'Spain', city: 'Madrid'},
    {id: 5, name: 'Elisa Gallagher', age: 31, companyName: 'Portica', country: 'United Kingdom', city: 'London'},
  ];

  awaitingPersonList: Array<any> = [
    {id: 6, name: 'George Vega', age: 28, companyName: 'Classical', country: 'Russia', city: 'Moscow'},
    {id: 7, name: 'Mike Low', age: 22, companyName: 'Lou', country: 'USA', city: 'Los Angeles'},
    {id: 8, name: 'John Derp', age: 36, companyName: 'Derping', country: 'USA', city: 'Chicago'},
    {id: 9, name: 'Anastasia John', age: 21, companyName: 'Ajo', country: 'Brazil', city: 'Rio'},
    {id: 10, name: 'John Maklowicz', age: 36, companyName: 'Mako', country: 'Poland', city: 'Bialystok'},
  ];

  updateList(id: number, property: string, event: any) {
    const editField = event.target.textContent;
    this.personList[id][property] = editField;

  }

  loadProjectItems(proId: number) {
    this.projectService.getProjectItems(proId)
      .subscribe(datas => {
        this.projectItems = datas;
        console.log('projectItems : ' + datas.length);
      });
  }

  remove(id: any) {
    // frame.show();
    this.awaitingPersonList.push(this.personList[id]);
    this.personList.splice(id, 1);
  }

  removeItem() {
    this.projectItems.pop();
  }

  add() {
    if (this.awaitingPersonList.length > 0) {
      const person = this.awaitingPersonList[0];
      this.personList.push(person);
      this.awaitingPersonList.splice(0, 1);
    }
  }

  changeValue(id: number, property: string, event: any) {
    this.editField = event.target.textContent;
  }

  constructor(private modalService: MDBModalService,
              private projectService: ProjectService,) {
  }

  ngOnInit() {
    this.projectService.getProjects()
      .subscribe(exps => {
        this.exps = exps;
        console.log('exps : ' + exps.length);
      });
    this.projectService.getProjectItems(1)
      .subscribe(datas => {
        this.projectItems = datas;
        console.log('projectItems : ' + datas.length);
      });
  }

  onsubmit() {
    this.modalRef = this.modalService.show(ModalComponent, {
      backdrop: false, // 背景蒙版
      focus: true,
      ignoreBackdropClick: false,
      class: 'modal-top-right',
      containerClass: 'right',
      animated: true,
      data: {
        heading: '提交成功！！',
        content: {heading: '', description: ''},
        displaybody: false,
        secondarybtn: false,
      }
    });
    // 这里是操作
  }
}
