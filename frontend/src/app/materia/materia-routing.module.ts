import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MateriaFormComponent } from './materia-form/materia-form.component';
import { MateriaListComponent } from './materia-list/materia-list.component';

const routes: Routes = [
  { path: '', component : MateriaListComponent },
  { path: 'materias-form', component : MateriaFormComponent },
  { path: 'materias-form/:materiaId', component : MateriaFormComponent }
];

// checar nome do id depois

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MateriaRoutingModule { }
