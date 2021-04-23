import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MateriaRoutingModule } from './materia-routing.module';
import { SharedModule } from '../shared/shared.module';
import { MateriaFormComponent } from './materia-form/materia-form.component';
import { MateriaListComponent } from './materia-list/materia-list.component';
import { MateriaDetalheComponent } from './materia-detalhe/materia-detalhe.component';
import { NgxPaginationModule } from 'ngx-pagination';


@NgModule({
  declarations: [
    MateriaFormComponent,
    MateriaListComponent,
    MateriaDetalheComponent
  ],
  imports: [
    CommonModule,
    MateriaRoutingModule,
    

    SharedModule,
    NgxPaginationModule
    
  ]
})
export class MateriaModule { }
