import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { AlunoService } from '../aluno.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  /*
    * arrow function ---- =>
    * function (data){
          console.log(data);
          this.alunos = data;    
      }
    */

 public alunos : any = [];

 @Input()
 public tituloFilho : any;
 // Variável que vai pegar o valor da variável filho do pai.
 // do pai pro filho, usamos o input

 
  //exerc
 public alunoPai : any;
 // Variável que vai ser usada para passar seu valor para a variável filho em aluno.detalhe.component.ts



 @Output()
 public emitirEvento : EventEmitter<string> = new EventEmitter<string>();
 // variável do tipo EventEmitter que será usada pelo pai como evento.
 // do filho pro pai, usamos o output


  // Injetamos um serviço de AlunoService que lá dentro usa o HttpService 
  constructor( private alunoService : AlunoService )    
  { 
      this.alunoService.getAll()
      .subscribe(
        (data) => {
          console.log(data);
          this.alunos = data;
        }
      );
      // só entra na function quando o status é da família 200.
  }
      

  ngOnInit(): void {
    console.log(this.tituloFilho);
  }

  onEmitirEventoClick(){
    this.emitirEvento.emit("BRQ");
  }
  // funcao que vai exibir brq para o botao no html deste componente. home.component.html


  //exerc
  onAlunoClick(matricula : number){    
    this.alunoService.getByMatricula(matricula)
    .subscribe(
      (data) => {
        console.log(data);
        //totally unecessary
        this.alunoPai = data;

      }
    )
  }

}
