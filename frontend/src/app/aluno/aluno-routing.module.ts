import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlunoFormComponent } from './aluno-form/aluno-form.component';
import { AlunoListComponent } from './aluno-list/aluno-list.component';

const routes: Routes = [
 { path: '', component : AlunoListComponent },
 { path: 'aluno-form', component : AlunoFormComponent},
 { path: 'aluno-form/:id', component : AlunoFormComponent}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
// Precisamos alterar a linha de imports para forChild quando não é o root principal
export class AlunoRoutingModule { }
