import { DependenteService } from './../dependenteService';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Dependente } from '../dependente';

@Component({
    selector: 'app-list-dependente',
    templateUrl: './dependente-list.component.html',
    styleUrls: ['./dependente-list.component.css']
})

export class DependenteListComponent implements OnInit{

    dependente:Dependente[];

    constructor(private dependenteService:DependenteService, private router:Router){
    }
    getDepedentes(){
        this.dependenteService.getDependenteList().subscribe(data => {
          this.dependente = data;
        })
    }
    dependeteDetails(id:number){
        this.router.navigate(['dependentes-details',id])
    }
    dependeteUpdate(id:number){
        this.router.navigate(['update-dependetes',id])
    }
    dependeteDelete(id:number){
        this.dependente.splice(this.dependente.findIndex(fix_index => fix_index.id === id),1);
        this.dependenteService.deleteDependenteByid(id).subscribe();
    }
    ngOnInit(): void {
        this.getDepedentes();
    }
}

