import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-field-debug',
  templateUrl: './field-debug.component.html',
  styleUrls: ['./field-debug.component.scss']
})
export class FieldDebugComponent implements OnInit {

  @Input()
  valueFieldDebug : any;

  constructor() { }

  ngOnInit(): void {
  }

}
