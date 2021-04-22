import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {


//  @Input()
//  public tituloFilho : any;
 // Variável que vai pegar o valor da variável filho do pai.
 // do pai pro filho, usamos o input

 

 @Output()
 public emitirEvento : EventEmitter<string> = new EventEmitter<string>();
 // variável do tipo EventEmitter que será usada pelo pai como evento.
 // do filho pro pai, usamos o output

  constructor(){}

  ngOnInit(): void {
    // console.log(this.tituloFilho);
  }

  // funcao que vai exibir brq para o botao no html deste componente. home.component.html
  // onEmitirEventoClick(){
  //   this.emitirEvento.emit("BRQ");
  // }
 

}
