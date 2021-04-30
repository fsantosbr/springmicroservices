import { BrowserModule } from '@angular/platform-browser';
import { LOCALE_ID, NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PrimeiroComponent } from './primeiro/primeiro.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SharedModule } from './shared/shared.module';

import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthInterceptorService } from './shared/interceptos/auth-interceptor.service';
import { HttpConfigInterceptorService } from './shared/interceptos/http-config-interceptor.service';
// import { AuthInterceptorService } from './shared/interceptors/auth-interceptor.service';
// import { HttpConfigInterceptorService } from './shared/interceptors/http-config-interceptor.service';

import localePt from '@angular/common/locales/pt';
import { registerLocaleData } from '@angular/common';
import { CicloComponent } from './ciclo/ciclo.component';

registerLocaleData(localePt, 'pt-BR');

@NgModule({
  declarations: [
    AppComponent,
    PrimeiroComponent,
    CicloComponent   
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
    },
    { provide: LOCALE_ID, useValue: 'pt-BR' }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
