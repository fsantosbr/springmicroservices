import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-materia-detalhe',
  templateUrl: './materia-detalhe.component.html',
  styleUrls: ['./materia-detalhe.component.scss']
})
export class MateriaDetalheComponent implements OnInit {

  @Input()
  detalheMateriaFilho : any;

  constructor() { }

  ngOnInit(): void {
  }

}
