import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { AlunoService } from './aluno/aluno.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title : string = 'frontend';
  public nomeTeste : string;
  public isDesabilitado : boolean = false;

  public meuForm : FormGroup;

  // public nomeTS : string;  
  // public turmaTS : string; 

  constructor(private alunoService : AlunoService, private formBuilder : FormBuilder){
    this.meuForm = this.formBuilder.group(
      {
        nome : [null, [ Validators.required, Validators.maxLength(10) ]],
        turma : [null, [Validators.required ]]
      }
    );
  }

  public somar() : number{
    return 1+1;
  }

  public onMeuBotaoClick(){
    alert("Mensagem de alerta para teste " + this.title);
  }

  public capturarDados(valor){
    console.log(valor);
    this.nomeTeste = valor;
    // alert("Tecla pressionada");
  }

  public receiveEmitirEvento(e){
    console.log(e);
  }

  public onEnviarFormClick(){   
    let newAluno = {
    nome: this.meuForm.value.nome,
    turma: this.meuForm.value.turma
    };

     this.alunoService.save(newAluno)
      .subscribe(
      (data) => {
        console.log(data);
      }
     )
  }

  public isValid(fieldName) : boolean{
    return (!this.meuForm.get(fieldName).valid && this.meuForm.get(fieldName).touched);
  }
}
