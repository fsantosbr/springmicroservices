import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MateriaService {

  // um service por module

  uri : string = `${environment.API_URI}/materias`;
   //uri : string = {environment.API_URI + '/materias';


  constructor(private httpService : HttpClient) { }


  public getAll(){
    return this.httpService.get(this.uri);
  }

  public getById(materiaId : number){
    return this.httpService.get(`${this.uri}/${materiaId}`);
  }

  // see if any will bring some problem in the future
  public save(newMateria : any){
    return this.httpService.post(this.uri, newMateria);
  }

  // see if any will bring some problem in the future
  public update(materiaId : number, updatedMateria : any){
    return this.httpService.patch(`${this.uri}/${materiaId}`, updatedMateria);
  }

  public delete(materiaId : number){
    return this.httpService.delete(`${this.uri}/${materiaId}`);
  }

  public getPagination(pagina, registros = 2, nomeMateriaContains : string = "nenhumaMateriaSelecionada"){
    console.log("pag " + pagina + ". registros " + registros);
    return this.httpService.get("http://localhost:8081/materias/paginacao/?pagina=" 
      + pagina + "&registros=" 
      + registros + "&procurar="
      + nomeMateriaContains);
    //http://localhost:8081/materias/paginacao/?pagina=1&registros=2
    //http://localhost:8081/materias/paginacao/?pagina=1&registros=1
  }


}
