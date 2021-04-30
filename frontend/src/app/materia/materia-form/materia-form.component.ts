import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { MateriaService } from '../materia.service';

@Component({
  selector: 'app-materia-form',
  templateUrl: './materia-form.component.html',
  styleUrls: ['./materia-form.component.scss']
})
export class MateriaFormComponent implements OnInit {

  meuFormMateria : FormGroup;

  // variables to manage the edding or creating of a entity (materia)
  public isEdicao = false;
  public materiaId = 0;

  constructor(
    private materiaService : MateriaService,
    private formBuilder : FormBuilder,
    private activatedRoute : ActivatedRoute,
    private router : Router
  ) { 
    // this.meuFormMateria = this.formBuilder.group(
    //   { 
    //     nome : [ null, [ Validators.required, Validators.maxLength(15), Validators.minLength(3) ]],
    //     professor : [ null, [Validators.required, Validators.maxLength(25), Validators.minLength(3) ]]
    //   }
    // );

    // // only for test
    // console.log(this.meuFormMateria);
    // console.log(this.activatedRoute);

    // // identifying the router ('/materias' or '/materias/id'). To create or Edit the entity
    // this.activatedRoute.params
    //   .subscribe(
    //     (dataRoute) => {
    //       //only to see the route in the console
    //       console.log(dataRoute);

    //       if (dataRoute.materiaId){
    //         this.isEdicao = true;
    //         this.materiaId = dataRoute.materiaId;

    //         // loading the entity and passing it to the form (macthing)
    //         this.materiaService.getById(dataRoute.materiaId)
    //           .subscribe(
    //             (materiaLoaded) => {
    //               this.meuFormMateria.patchValue(materiaLoaded);
    //             }
    //           );
    //       }
    //     }
    //   );
  }


  onClickEnviarFormMateria(){
    // if true, it'll edit the entity
    if (this.isEdicao){
      this.materiaService.update(this.materiaId, this.meuFormMateria.value)
        .subscribe(
          (updatedMateria) => {
            // only for debbuging
            console.log(updatedMateria);

            this.router.navigate(['/materias']);
          }
        );
    }
    else {
      // it'll create the entity
      this.materiaService.save(this.meuFormMateria.value)
        .subscribe(
          (savedMateria) => {
            // only for debbuging
            console.log(savedMateria);

            this.router.navigate(['/materias']);
          }
        );
    }
  }

  public isValid(fieldName) : boolean{
    return (!this.meuFormMateria.get(fieldName).valid && this.meuFormMateria.get(fieldName).touched);
  }

  ngOnInit(
    // private materiaService : MateriaService,
    // private formBuilder : FormBuilder,
    // private activatedRoute : ActivatedRoute,
    // private router : Router

  ): void {
    this.meuFormMateria = this.formBuilder.group(
      { 
        nome : [ null, [ Validators.required, Validators.maxLength(15), Validators.minLength(3) ]],
        professor : [ null, [Validators.required, Validators.maxLength(25), Validators.minLength(3) ]]
      }
    );

    // only for test
    console.log(this.meuFormMateria);
    console.log(this.activatedRoute);

    // identifying the router ('/materias' or '/materias/id'). To create or Edit the entity
    this.activatedRoute.params
      .subscribe(
        (dataRoute) => {
          //only to see the route in the console
          console.log(dataRoute);

          if (dataRoute.materiaId){
            this.isEdicao = true;
            this.materiaId = dataRoute.materiaId;

            // loading the entity and passing it to the form (macthing)
            this.materiaService.getById(dataRoute.materiaId)
              .subscribe(
                (materiaLoaded) => {
                  this.meuFormMateria.patchValue(materiaLoaded);
                }
              );
          }
        }
      );
  }

}
