import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PrimeiroComponent } from './primeiro/primeiro.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SharedModule } from './shared/shared.module';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthInterceptorService } from './shared/interceptos/auth-interceptor.service';
import { HttpConfigInterceptorService } from './shared/interceptos/http-config-interceptor.service';

@NgModule({
  declarations: [
    AppComponent,
    PrimeiroComponent   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,    
    // AlunoModule,
    // MateriaModule,
    NgbModule,  
    SharedModule
  ],
  exports:[],
  providers: [
    {
      provide : HTTP_INTERCEPTORS,
      useClass : AuthInterceptorService,
      multi : true
    },
    {
      provide : HTTP_INTERCEPTORS,
      useClass : HttpConfigInterceptorService,
      multi : true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
