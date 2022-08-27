import { SocioDetailsComponent } from './../socio-details/socio-details.component';
import { UpdateSocioComponent } from './../update-socio/update-socio.component';
import { HttpClient } from '@angular/common/http';
import { SocioService } from './../socio.service';
import { Socio } from './../socio';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-socio-list',
  templateUrl: './socio-list.component.html',
  styleUrls: ['./socio-list.component.css']
})

export class SocioListComponent implements OnInit {
  socios!: Socio[];
  constructor(private socioService:SocioService, private router:Router ) { 
    
  }
  private getSocios(){
    this.socioService.getSocioList().subscribe(data => {
      this.socios = data;
    })
  }
  socioDetails(id:number){
    this.router.navigate(['socios-details',id])
  }
  socioUpdate(id:number){
    this.router.navigate(['update-socios',id])
  }
  socioDelete(id:number){
    this.socios.splice(this.socios.findIndex(cache_map => cache_map.id === id),1);
    this.socioService.deleteSocioByid(id).subscribe();
      
    }
    ngOnInit(): void {
    this.getSocios();
    }
  }

