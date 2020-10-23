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

  usernameInput: string = "";
  passwordInput: string = "";

  onUsernameInput(event: any) {
    this.usernameInput = event.target.value;
    console.log(this.usernameInput);
  }

  onPasswordInput(event: any) {
    this.passwordInput = event.target.value;
    console.log(this.passwordInput);
  }
  
  handleLogin() {
    const data = {
      username: this.usernameInput,
      password: this.passwordInput
    };
    try {
      this.userService.loginUser(data).subscribe((response: any) => {
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
