import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { AlunoService } from '../aluno.service';

@Component({
  selector: 'app-aluno-form',
  templateUrl: './aluno-form.component.html',
  styleUrls: ['./aluno-form.component.scss']
})
export class AlunoFormComponent implements OnInit {

  public meuForm : FormGroup;

  public isEdicao = false;

  public idAluno = 0;

  constructor(private alunoService : AlunoService,
    private formBuilder : FormBuilder,
    private activatedRoute : ActivatedRoute,
    private router : Router
    ) {
      this.meuForm = this.formBuilder.group(
        {
          nome : [null, [ Validators.required, Validators.maxLength(10), Validators.minLength(3) ]],
          turma : [null, [Validators.required, Validators.maxLength(6), Validators.minLength(2) ]]
        }
      );
      console.log(this.meuForm);
      console.log(this.activatedRoute);

      // the next code will identify the route used and checked if the route has a value with 'id' that we used in the routes
      // if so, it means that there's an id/matricula on the url (alunos\id) and it is an update
      // if not, it means that there's no an id on the url and it's to load the empty form to save a new entity
      this.activatedRoute.params
        .subscribe(
          (data) => {
            console.log(data);
            if (data.id){
              this.isEdicao = true;
              this.idAluno = data.id;

              this.alunoService.getByMatricula(data.id)
                .subscribe(
                  (alunoLoaded) => {
                    this.meuForm.patchValue(alunoLoaded);
                    // patch will combine de fields with the field form
                  }
                );
            }
          }
        );
   }


   public onEnviarFormClick(){
    if (this.isEdicao){      
      //edicao
      this.alunoService.update(this.idAluno, this.meuForm.value)
        .subscribe(
          (updatedAluno) => {
            console.log(updatedAluno);
            this.router.navigate(['/alunos']);
            // after saving the changes, we'll redirect to another page
          }
        );
    }
    else {
      //criacao
      this.alunoService.save(this.meuForm.value)
        .subscribe(
          (data) => {
            console.log(data);
            this.router.navigate(['/alunos']);
            // after creating the object, we'll redirect to another page
          }
        );
    }   
  }

  public isValid(fieldName) : boolean{    
    return (!this.meuForm.get(fieldName).valid && this.meuForm.get(fieldName).touched);    
  }


  ngOnInit(): void {
  }

}
