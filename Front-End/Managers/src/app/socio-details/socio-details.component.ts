import { SocioService } from './../socio.service';
import { Socio } from './../socio';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-socio-details',
  templateUrl: './socio-details.component.html',
  styleUrls: ['./socio-details.component.css']
})
export class SocioDetailsComponent implements OnInit {
  id! : number
  socio! : Socio
  constructor(private route : ActivatedRoute, private socioService:SocioService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.socioService.getSocioById(this.id).subscribe(data => {
      this.socio = data;
    })
  }

}
