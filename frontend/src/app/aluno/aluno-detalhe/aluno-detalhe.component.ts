import { Component, Input, OnInit } from '@angular/core';
import { AlunoService } from '../aluno.service';

@Component({
  selector: 'app-aluno-detalhe',
  templateUrl: './aluno-detalhe.component.html',
  styleUrls: ['./aluno-detalhe.component.scss']
})
export class AlunoDetalheComponent implements OnInit {

  @Input()
  public alunoFilho : any;
  // variável que será usada para passar dados do pai para o filho. Pai: home.component.ts
  // Uma variável no Pai passará o valor para esta.
  
 
  constructor() {
  
   }

  ngOnInit(): void {
  }

}
