import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../../user.service'

@Component({
  selector: 'app-login-home',
  templateUrl: './login-home.component.html',
  styleUrls: ['./login-home.component.css']
})
export class LoginHomeComponent implements OnInit {
  
  constructor(private router: Router, private userService: UserService) { }

  username: string = "";
  password: string = "";

  setUsername(event: any) {
    this.username = event.target.value;
    console.log(this.username);
  }

  setPassword(event: any) {
    this.password = event.target.value;
    console.log(this.password);
  }

  handleLogin(event: any) {
    event.preventDefault();
    const data = {
      username: this.username,
      password: this.password
    };
    try {
      this.userService.loginUser(data).subscribe((response: any) => {
        console.log(response + 'is logging in');
        this.userService.user = response.username;
        this.router.navigateByUrl('/home');
      })
    } catch(error: any) {
      console.log(error);
    }
  }

  ngOnInit(): void {
  }

}
