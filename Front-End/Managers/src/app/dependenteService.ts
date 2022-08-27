import { ReactiveFormsModule } from '@angular/forms';
import { Injectable} from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Dependente} from './dependente';

@Injectable({
    providedIn:'root'
})

export class DependenteService{
    private baseURL = "http://localhost:8090/dependentes"

    constructor(private httpCli:HttpClient){

    }
    getDependenteList():Observable <Dependente[]>{
      return this.httpCli.get<Dependente[]>(`${this.baseURL}`);
    }
    createDependente(dependete:Dependente):Observable<Object>{
       return this.httpCli.post(`${this.baseURL}`,dependete) ;
    }
    getDependenteByid(id:number):Observable<Dependente>{
       return this.httpCli.get<Dependente>(`${this.baseURL}/${id}`);
    }
    updateDependenteByid(id:number,dependente:Dependente):Observable<Object>{
        return this.httpCli.put(`${this.baseURL}/${id}`,dependente);
    }
    deleteDependenteByid(id:number):Observable<Object>{
        return this.httpCli.delete(`${this.baseURL}/${id}`)
    }
  
}



