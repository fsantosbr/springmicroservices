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

  public getPagination(pagina, registros = 2, nomeMateriaContains : string = "nenhumaMateriaSelecionada"){
    console.log("pag " + pagina + ". registros " + registros);
    return this.httpService.get("http://localhost:8081/materias/paginacao/?pagina=" 
      + pagina + "&registros=" 
      + registros + "&procurar="
      + nomeMateriaContains);
    //http://localhost:8081/materias/paginacao/?pagina=1&registros=2
    //http://localhost:8081/materias/paginacao/?pagina=1&registros=1
  }

  // public getaPagination(pagina, registrosPorPagina = 2){
  //   return this.httpService.get(`${this.uri}/paginacao?pagina=${pagina}&registros=${registrosPorPagina}`);
  // }

}
