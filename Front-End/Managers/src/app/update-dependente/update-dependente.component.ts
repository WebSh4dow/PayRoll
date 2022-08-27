import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { DependenteService } from '../dependenteService';
import { Dependente } from '../dependente';

@Component({
  selector: 'app-update-dependente',
  templateUrl: './update-dependente.component.html',
  styleUrls: ['./update-dependente.component.css']
})

export class UpdateDepedenteComponent implements OnInit{
  id:number;
  dependente : Dependente = new Dependente();

    constructor(private dependenteService:DependenteService, private router:Router, private route:ActivatedRoute){}
    
    ngOnInit(): void {
     this.id = this.route.snapshot.params['id'];
     this.dependenteService.getDependenteByid(this.id).subscribe(data =>{
     this.dependente = data
     }, error => console.log(error))   
    }

    onSubmit(){
      this.dependenteService.updateDependenteByid(this.id,this.dependente).subscribe(data => {
        this.goToSocioList();
      }, error => console.log(error))
    }
    goToSocioList(){
      this.router.navigate(['/dependentes'])  
    }
}