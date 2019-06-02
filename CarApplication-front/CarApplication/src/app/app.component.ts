import { Component } from '@angular/core';
import { Router } from 'npm/CarApplication-front/CarApplication/node_modules/@angular/router';
import { HttpClient, HttpHeaders } from 'npm/CarApplication-front/CarApplication/node_modules/@angular/common/http';
import { CarService } from 'npm/CarApplication-front/CarApplication/src/app/car/car.service.service';
import { Car } from 'npm/CarApplication-front/CarApplication/src/app/car/car';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Car Application';
  header = " Car Shows"
  applicationEndpoint: string;
  cars: Array<Car> =[];
  map: Map<string, Array<Car>>;
  constructor(private router: Router, private http: HttpClient, private carService:CarService) {
    this.applicationEndpoint = 'http://localhost:8080/api/v1/cars';
  }

  ngOnInit(){
    this.getCarShows();
  }

  getCarShows(){
    this.carService.getCarShow()
      .subscribe((cars) => {
        this.cars.push(...cars);
      }); 

      this.map =this.carService.findDuplicateResults(this.cars);
            console.log(this.map);
      
  }

  
}
