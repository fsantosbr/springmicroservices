import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-primeiro',
  templateUrl: './primeiro.component.html',
  styleUrls: ['./primeiro.component.scss']
})
export class PrimeiroComponent implements OnInit {

  constructor() { }

  obj = {
    "id" : 1,
    "nome" : "fabrizio"
  }


  ngOnInit(): void {
  }

}
