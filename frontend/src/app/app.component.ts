import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title : string = 'frontend';
  public nome : string;
  public isDesabilitado : boolean = false;

  public somar() : number{
    return 1+1;
  }

  public onMeuBotaoClick(){
    alert("Mensagem de alerta para teste " + this.title);
  }

  public capturarDados(valor){
    console.log(valor);
    this.nome = valor;
    // alert("Tecla pressionada");
  }

  public receiveEmitirEvento(e){
    console.log(e);
  }
}
