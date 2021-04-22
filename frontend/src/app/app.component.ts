import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { AlunoService } from './aluno/aluno.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
 

  // title : string = 'frontend';
  // public nomeTeste : string;
  // public isDesabilitado : boolean = true;

  // public nomeTS : string;  
  // public turmaTS : string; 



  // public somar() : number{
  //   return 1+1;
  // }

  // public onMeuBotaoClick(){
  //   alert("Mensagem de alerta para teste " + this.title);
  // }

  // public capturarDados(valor){
  //   console.log(valor);
  //   this.nomeTeste = valor;
  //   // alert("Tecla pressionada");
  // }

  // public receiveEmitirEvento(e){
  //   console.log(e);
  // }

  constructor(){}

}
