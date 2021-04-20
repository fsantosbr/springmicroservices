import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AlunoService {

  // um service por module

  constructor(private httpService: HttpClient) { }

  public getAll(){
    return this.httpService.get("http://localhost:8081/alunos");
  }

  public getByMatricula(matricula : number){
    return this.httpService.get("http://localhost:8081/alunos/" + matricula);
  }


}
