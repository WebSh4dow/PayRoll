import { DependenteService } from './../dependenteService';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Dependente } from '../dependente';

@Component ({
    selector: 'app-dependente-details',
    templateUrl: './dependente-details.component.html',
    styleUrls: ['./depedente-details.component.css']
})

export class DepedenteDetailsComponent implements OnInit {
    id:number;
    dependente:Dependente

    constructor(private route:ActivatedRoute, private depedenteService:DependenteService){
    }

    ngOnInit():void{
        this.id = this.route.snapshot.params['id'];
        this.depedenteService.getDependenteByid(this.id).subscribe(data =>{
        this.dependente = data;
        })
    }



}