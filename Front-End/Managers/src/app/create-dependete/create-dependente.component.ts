import { DependenteService } from './../dependenteService';
import { Component, OnInit } from '@angular/core';
import { Dependente } from '../dependente';
import { Router } from '@angular/router';

@Component({
    selector:'app-create-dependente',
    templateUrl:'./create-dependente.component.html',
    styleUrls: ['./create-dependente.css']
})

export class CreateDependente implements OnInit{
    dependente:Dependente = new Dependente();

    constructor(private dependenteService:DependenteService, private router:Router){}
    
    ngOnInit(): void {}

    goTolistDependentes(){
        this.router.navigate(['/dependentes'])
    }

    dependenteSave(){
        this.dependenteService.createDependente(this.dependente).subscribe(data => {
        console.log(data)
        this.goTolistDependentes();
        }, error => console.log(error));
    }
    onSubmit(){
       console.log(this.dependente);
       this.dependenteSave(); 
    }
}