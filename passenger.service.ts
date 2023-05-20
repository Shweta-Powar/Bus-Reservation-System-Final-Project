import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Passenger } from './passenger';
@Injectable({
  providedIn: 'root'
})
export class PassengerService {
  private baseURl = "http://localhost:8089/api/passengers/";

  constructor(private httpClient: HttpClient) { }
  getPassengersList(): Observable<Passenger[]>{
    return this.httpClient.get<Passenger[]>(`${this.baseURl}`);
  }
}
