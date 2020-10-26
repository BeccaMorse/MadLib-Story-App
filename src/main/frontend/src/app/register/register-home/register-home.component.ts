import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../../user.service'

@Component({
  selector: 'app-register-home',
  templateUrl: './register-home.component.html',
  styleUrls: ['./register-home.component.css']
})
export class RegisterHomeComponent implements OnInit {

  constructor(private router: Router, private userService: UserService) { }

  username: string = "";
  password: string = "";
  confirmPassword: string = "";

  setUsername(event: any) {
    this.username = event.target.value;
 }

  setPassword(event: any) {
    this.password = event.target.value;
    console.log(this.password);
  }

  setConfirmPassword(event: any) {
    this.confirmPassword = event.target.value;
    console.log(this.password);
  }

  handleRegistration(event: any) {
    event.preventDefault();
    const data = {
      username: this.username,
      password: this.password,
      confirmPassword: this.confirmPassword
    };

    if(this.password != this.confirmPassword) {
      return console.log("password and confirm password must match");
    }

    try {
      this.userService.registerUser(data).subscribe((response: any) => {
        this.userService.user = response.username;
        this.router.navigateByUrl('');
      })
    } catch(error: any) {
      console.log(error);
    }
  }

  ngOnInit(): void {
  }

}
