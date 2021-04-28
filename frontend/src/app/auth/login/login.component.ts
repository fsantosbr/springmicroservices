import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Usuario } from 'src/app/shared/models/usuario';
import { StorageService } from 'src/app/shared/services/storage.service';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  public meuForm : FormGroup;

  constructor(private fb: FormBuilder,
    private authService : AuthService,
    private storage : StorageService,
    private router : Router) { }

  ngOnInit(): void {
    this.createForm();
  }

  private createForm(){
    this.meuForm = this.fb.group(
      {
       email : [ null,[ Validators.required] ],
       senha : [ null,[ Validators.required] ]
      },
    );
  }

  public isValid(fieldName) {
    return (this.meuForm.get( fieldName ).valid == false && this.meuForm.get( fieldName ).touched == true);
  }

  public onSubmit(){
    this.authService.login( this.meuForm.value )
      .subscribe(
        (success) => {
          console.log (success);

          const helper = new JwtHelperService();
          const decodedToken = helper.decodeToken(success.token);

          let localUser : Usuario = {
            token : success.token,
            nome: decodedToken.nome,
            email : decodedToken.sub,
            id : decodedToken.id,
            scopes : decodedToken.scopes
          };

          this.storage.setLocalUser(localUser);
          this.authService.sendMessage(true);

          this.router.navigate(['/materias']);
        },
        (error) => {this.authService.sendMessage(false);}

      );
  }

}
