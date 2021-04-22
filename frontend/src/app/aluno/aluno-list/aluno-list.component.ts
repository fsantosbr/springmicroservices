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
      this.alunoService.getAll()
      .subscribe(
        (data) => {
          console.log(data);
          this.alunos = data;
        }
      );
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

  onAlunoDelete(matricula : number){
    this.alunoService.delete(matricula)
      .subscribe(
        (data) => {
          console.log(data);

          //atualizando a lista
          this.alunoService.getAll()
          .subscribe(
            (alunosAtualizados) => {
              console.log(alunosAtualizados);
              this.alunos = alunosAtualizados;
            }
          );


        }
      )    
  }

  ngOnInit(): void {
  }

}
