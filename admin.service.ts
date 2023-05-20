import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Admin } from './admin';
@Injectable({
  providedIn: 'root'
})
export class AdminService {
  private baseURl = "http://localhost:8089/api/admins/";

  constructor(private httpClient: HttpClient) { }
  getAdminsList(): Observable<Admin[]>{
    return this.httpClient.get<Admin[]>(`${this.baseURl}`);
  }
}
