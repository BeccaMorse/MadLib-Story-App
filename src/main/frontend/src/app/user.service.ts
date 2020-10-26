import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  user = null;

  constructor(private http:HttpClient) { }

  registerUser(user: any) {
    console.log(user)
    return this.http.post("api/register", user)
  }
  loginUser(user: any) {
    return this.http.post("api/login",user)
  }
}