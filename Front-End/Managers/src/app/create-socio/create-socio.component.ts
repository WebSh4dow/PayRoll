import { SocioService } from './../socio.service';
import { Component, OnInit } from '@angular/core';
import { Socio } from '../socio';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-socio',
  templateUrl: './create-socio.component.html',
  styleUrls: ['./create-socio.component.css']
})
export class CreateSocioComponent implements OnInit {

  socio: Socio = new Socio() ;

  constructor(private socioService: SocioService, private router:Router) { }

  ngOnInit(): void {
  }

  socioSave(){
    this.socioService.createSocio(this.socio).subscribe(data => {
      console.log(data)
      this.goToSocioList();
    },
    error => console.log(error));
  }

  goToSocioList(){
    this.router.navigate(['/socios']);
  }

  onSubmit(){
    console.log(this.socio);
    this.socioSave();
  }

}
