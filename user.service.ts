import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './user';
@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseURL = "http://localhost:8089/api/users/";

  constructor(private httpClient: HttpClient) { }
  getUsersList(): Observable<User[]>
  {
    return this.httpClient.get<User[]>(`${this.baseURL}`);
  }
  createUser(user:User): Observable<Object> {
    return this.httpClient.post(`${this.baseURL}`,user);

  }
  getUserById(uid:number):Observable<User> {
    return this.httpClient.get<User>(`${this.baseURL}${uid}`);
  }
  updateUserById(uid:number,user:User):Observable<Object> {
    return this.httpClient.put(`${this.baseURL}${uid}`,user);
  }
  deleteUser(uid:number):Observable<Object> {
    return this.httpClient.delete(`${this.baseURL}${uid}`);
  }
}
