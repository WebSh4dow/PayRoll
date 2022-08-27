import { SocioService } from './../socio.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Socio } from '../socio'

@Component({
  selector: 'app-update-socio',
  templateUrl: './update-socio.component.html',
  styleUrls: ['./update-socio.component.css']
})
export class UpdateSocioComponent implements OnInit {

  id : number;
  socio : Socio = new Socio();
  
  constructor(private socioService:SocioService, private router: Router, private route: ActivatedRoute ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.socioService.getSocioById(this.id).subscribe(data => {
    this.socio =  data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.socioService.updateSocioByid(this.id,this.socio).subscribe(data => {
      this.goToSocioList();
    }, error => console.log(error))
  }

  goToSocioList(){
    this.router.navigate(['/socios'])
  }

}
