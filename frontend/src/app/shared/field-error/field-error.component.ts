import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-field-error',
  templateUrl: './field-error.component.html',
  styleUrls: ['./field-error.component.scss']
})
export class FieldErrorComponent implements OnInit {

  @Input()
  public isShow : boolean = false;
  // Estamos pegando dados do pai e passando pro filho. Esse módulo é o filho, então essas variáveis vão receber o valor.

  @Input()
  public messageError : string;

  constructor() { }

  ngOnInit(): void {
  }

}
