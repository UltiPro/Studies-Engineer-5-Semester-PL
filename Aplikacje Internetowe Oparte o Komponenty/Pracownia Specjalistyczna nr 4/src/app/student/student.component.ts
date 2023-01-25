import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Student, StudentClass } from '../../app/types/student';

export type WhichType = {
  student: StudentClass;
  which: number;
};

@Component({
  selector: 'print-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css'],
})

export class StudentComponent implements OnInit {
  @Input() studentForPrint!: StudentClass;
  @Input() isOdd!: boolean;
  @Input() title!: string;
  @Input() which!: number;
  @Input() allStudentsAvg!: number;  // +
  clicked: number = -1;
  studentForEdit: StudentClass = new StudentClass('', '', 0, [], 0);
  studentToDelete: number = -1; // +
  show: number = -1;            // +
  sholarship: number = -1;      // +

  @Output() doEditInParent: EventEmitter<WhichType> = new EventEmitter();
  @Output() doDeleteInParent = new EventEmitter<void>();

  constructor() { }

  ngOnInit() { }

  clickOnStudent(which: number): void {
    this.studentForEdit.Name = this.studentForPrint.Name;
    this.studentForEdit.Surname = this.studentForPrint.Surname;
    this.studentForEdit.Index_nr = this.studentForPrint.Index_nr;
    this.clicked = which;
  }

  remove(student: StudentClass): void {
    if (this.studentForEdit.Name.length > 0) {
      let tempStudent: WhichType = { student, which: this.which };
      this.doEditInParent.emit(tempStudent);
      this.clicked = -1;
    }
  }

  cancelEditing() {
    this.clicked = -1;
  }

  deleteWhichStudent() {
    this.studentToDelete = this.which;
  }

  isDelete(e: boolean) {
    if (!e) this.studentToDelete = -1; 
    else this.doDeleteInParent.emit();
  }

  showSubjects() {
    this.show = this.which;
  }

  calcSholarship() {
    if (this.studentForPrint.AvgGrade > this.allStudentsAvg) this.sholarship = this.studentForPrint.AvgGrade * 200;
    else this.sholarship = 0;
  }
}
