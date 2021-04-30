import { Component, OnInit, Output } from '@angular/core';
import { take } from 'rxjs/operators';
import { MateriaService } from '../materia.service';

@Component({
  selector: 'app-materia-list',
  templateUrl: './materia-list.component.html',
  styleUrls: ['./materia-list.component.scss']
})
export class MateriaListComponent implements OnInit {

  materias : any = [];

  detalheMateriaPai : any;

  nomeMateriaContains : string;
 
  // Beginning of the variables to manage pagination

  
  public pageSize : number = 3;

  public pageSizeUpdated : number = 3;

  public total : number = 0;

  // page variable used for NgxPagination
  public paginaNgx : number = 1 ;
  
  // page variable used for the backend application because pagination no Spring starts with '0'.
  public paginaRest : number = this.paginaNgx -1;

  // End of the variables to manage pagination


  constructor(private materiaService : MateriaService) { }

  ngOnInit(): void {
    this.getPagination();
  }

  public getPagination(){
    this.materiaService.getPagination(this.paginaRest, this.pageSize, this.nomeMateriaContains)
    .pipe( take(1) )
      .subscribe(
        (paginationData : any) => {
          // this console is only for debbuging
          console.log("Dados da paginação:");
          console.log(paginationData);
          console.log("valor pagesize no inicio: " + this.pageSize);

          // The data from pagination are inside of a content
          this.materias = paginationData.content;
          this.total = paginationData.totalElements;
          
        }
      );
  }

  public pageChanged(evento){   
    this.paginaNgx = evento;
    this.paginaRest = this.paginaNgx - 1;
    this.getPagination();
    console.log("pageSize: " + this.pageSize)
  }

  onClickApplyFilter(){
    this.pageSize = this.pageSizeUpdated;
    this.getPagination();
  }

  // onClickSearchByName(){
  //   this.materiaService.getPagination(this.paginaRest, this.pageSize, this.nomeMateriaContains)
  //     .subscribe(
  //       (paginationData : any) => {
  //         // this console is only for debbuging
  //         console.log("Dados da paginação:");
  //         console.log(paginationData);
  //         console.log("valor pagesize no inicio: " + this.pageSize);

  //         // The data from pagination are inside of a content
  //         this.materias = paginationData.content;
  //         this.total = paginationData.totalElements;
          
  //       }
  //     );
  // }

  onVerDetalheMateria(materiaId : number){
    this.materiaService.getById(materiaId)
      .subscribe(
        (materia) => {
          // just for debbuging
          console.log(materia);

          this.detalheMateriaPai = materia;
        }
      );
  }

  onDeletarMateria(materiaId : number){
    this.materiaService.delete(materiaId)
      .subscribe(
        (data) => {
          // curious to see what's inside of this variable 
          console.log(data);
          
          this.getPagination();
          // erro - ao deletar 
        }
      );
  }

}
