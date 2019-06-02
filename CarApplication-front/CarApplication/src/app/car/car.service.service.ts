import { Injectable } from '@angular/core';
import { HttpClient } from 'npm/CarApplication-front/CarApplication/node_modules/@angular/common/http';
import { Observable } from 'npm/CarApplication-front/CarApplication/node_modules/rxjs';
import { map, retry, flatMap, mergeMap } from 'rxjs/operators';
import { Car } from 'npm/CarApplication-front/CarApplication/src/app/car/car';
import { isNgTemplate } from 'npm/CarApplication-front/CarApplication/node_modules/@angular/compiler';




@Injectable({
  providedIn: 'root'
})
export class CarService {

  applicationEndpoint: string;
  cars: Array<Car> =[];
  carArray1: Array<Car> =[];
  map : Map<string, Array<Car>>;

  constructor(private http: HttpClient) { 

    this.applicationEndpoint = 'http://localhost:8080/api/v1/cars';
  }

  getCarShow(): Observable< Array<Car>> {   

    const endpoint = `${this.applicationEndpoint}`; 
   return this.http.get(endpoint )
      .pipe(
        flatMap((response) => Object.values(response)),
          map(this.transformResults.bind(Object.values(this))
          
          ));   
  }

  transformResults(cars): Array<Car>{
     return  cars.map( car =>  {      
      car.make = car.name;
      car.model = car.model;
      car.show = car.show;        
      return car;
    });   
    
  }
  findDuplicateResults(cars): Map<string, Array<Car>>{
    
    
     this.map = new Map();    
     this.cars.sort((a,b) => a.make.localeCompare(b.make));       
     
    for(var i=0; i<cars.length; i++){
      for(var j=i+1; j<cars.length; j++){
        if(cars[i].make == cars[j].make){
          this.carArray1.push(cars[i]);
          this.carArray1.push(cars[j]);
          this.map.set(cars[i].make, this.carArray1 );
        }
    }
    
  }
  return this.map;
  }

  
}