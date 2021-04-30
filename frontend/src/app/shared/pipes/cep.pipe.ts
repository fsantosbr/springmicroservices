import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'cep'
})
export class CepPipe implements PipeTransform {
  
  // 03030433  -> 04022-222
  transform(value: string, ...args: string[]): string {
    
    //console.log(value.toString());

    let cepStr : string = value.toString();

    if (cepStr.length < 8){
      cepStr = cepStr.padStart(8, '0')
    }

    //console.log(cepStr);

    let cep = cepStr.substring(0, 5) + '-' + cepStr.substring(5, cepStr.length);

    return cep;
  }

}
