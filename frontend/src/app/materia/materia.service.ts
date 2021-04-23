import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MateriaService {

  // um service por module


  constructor(private httpService : HttpClient) { }


  public getAll(){
    return this.httpService.get("http://localhost:8081/materias");
  }

  public getById(materiaId : number){
    return this.httpService.get("http://localhost:8081/materias/"+materiaId);
  }

  // see if any will bring some problem in the future
  public save(newMateria : any){
    return this.httpService.post("http://localhost:8081/materias", newMateria);
  }

  // see if any will bring some problem in the future
  public update(materiaId : number, updatedMateria : any){
    return this.httpService.patch("http://localhost:8081/materias/"+ materiaId, updatedMateria);
  }

  public delete(materiaId : number){
    return this.httpService.delete("http://localhost:8081/materias/"+ materiaId);
  }

}
