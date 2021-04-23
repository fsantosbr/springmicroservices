import { Component, OnInit } from '@angular/core';
import { MateriaService } from '../materia.service';

@Component({
  selector: 'app-materia-list',
  templateUrl: './materia-list.component.html',
  styleUrls: ['./materia-list.component.scss']
})
export class MateriaListComponent implements OnInit {

  materias : any = [];

  detalheMateriaPai : any;

  constructor(private materiaService : MateriaService) {
    this.getAll();
   }

  ngOnInit(): void {
  }

  getAll(){
    this.materiaService.getAll()
      .subscribe(
        (storedMaterias) => {
          // this console is only for debbuging
          console.log(storedMaterias);
          this.materias = storedMaterias;
        }
      );
  }

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
          
          this.getAll();
        }
      );
  }

}
