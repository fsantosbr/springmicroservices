import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FieldErrorComponent } from './field-error/field-error.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NavbarComponent } from './navbar/navbar.component';
import { FieldDebugComponent } from './field-debug/field-debug.component';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [
    FieldErrorComponent,
    NavbarComponent,
    FieldDebugComponent
  ],

  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,

    RouterModule
  ],

  exports : [
    FieldErrorComponent,
    NavbarComponent,
    FieldDebugComponent,

    FormsModule,
    ReactiveFormsModule,
    HttpClientModule   

    
  ]
})
// declarations: All components that are part of this module
// imports: All components that will be used inside of this module (than, just need use the name of this module in the module that will use some of the components here)
// exports: We're saying to Angular that these components or modules will be used again for who has this module.

export class SharedModule { }
