import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { AlunoService } from '../aluno.service';

@Component({
  selector: 'app-aluno-form',
  templateUrl: './aluno-form.component.html',
  styleUrls: ['./aluno-form.component.scss']
})
export class AlunoFormComponent implements OnInit {

  public meuForm : FormGroup;

  constructor(private alunoService : AlunoService, private formBuilder : FormBuilder) {
    this.meuForm = this.formBuilder.group(
      {
        nome : [null, [ Validators.required, Validators.maxLength(10), Validators.minLength(3) ]],
        turma : [null, [Validators.required, Validators.maxLength(6), Validators.minLength(2) ]]
      }
    );
    console.log(this.meuForm);
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
        
        // new block of code - reload the students
       

      }
     )    
  }

  public isValid(fieldName) : boolean{    
    return (!this.meuForm.get(fieldName).valid && this.meuForm.get(fieldName).touched);    
  }


  ngOnInit(): void {
  }

}
