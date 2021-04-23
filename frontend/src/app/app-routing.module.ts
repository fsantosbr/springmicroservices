import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PrimeiroComponent } from './primeiro/primeiro.component';

const routes: Routes = [
  { path: 'primeiro-component', component: PrimeiroComponent},
  { path: 'alunos', loadChildren: () => import('./aluno/aluno.module').then(m => m.AlunoModule) },
  { path: 'materias', loadChildren: () => import('./materia/materia.module').then(m => m.MateriaModule) }
  
];

// camainho e depois nome da classe

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
