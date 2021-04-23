import { Component, Input, OnInit } from '@angular/core';
import { AlunoService } from '../aluno.service';

@Component({
  selector: 'app-aluno-list',
  templateUrl: './aluno-list.component.html',
  styleUrls: ['./aluno-list.component.scss']
})
export class AlunoListComponent implements OnInit {
  
  public alunos : any = [];

  public alunoPai : any;

  // Injetamos um serviço de AlunoService que lá dentro usa o HttpService 
  constructor( private alunoService : AlunoService )    
  { 
      this.getAll();
      // só entra na function quando o status é da família 200.
      /*
    * arrow function ---- =>
      Nota: arrow function substitui o código abaixo de function por (data) =>
    * function (data){
          console.log(data);
          this.alunos = data;    
      }
    */
  }

  getAll(){
    this.alunoService.getAll()
      .subscribe(
        (data) => {
          console.log(data);
          this.alunos = data;
        }
      );
  }

  onAlunoClick(matricula : number){    
    this.alunoService.getByMatricula(matricula)
    .subscribe(
      (data1) => {
        console.log(data1);
        //totally unecessary
        this.alunoPai = data1;

      }
    )
  }

  onAlunoDelete(matricula : number){
    this.alunoService.delete(matricula)
      .subscribe(
        (data) => {
          console.log(data);

          //atualizando a lista
          this.getAll();

        }
      )    
  }

  ngOnInit(): void {
  }

}
