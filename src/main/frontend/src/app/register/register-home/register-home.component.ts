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

  usernameInput: string = "";
  passwordInput: string = "";
  confirmPasswordInput: string = "";

  onUsernameInput(event: any) {
    this.usernameInput = event.target.value;
    console.log(this.usernameInput);
  }

  onPasswordInput(event: any) {
    this.passwordInput = event.target.value;
    console.log(this.passwordInput);
  }

  onConfirmPasswordInput(event: any) {
    this.confirmPasswordInput = event.target.value;
    console.log(this.passwordInput);
  }

  handleRegistration() {
    const data = {
      usernameInput: this.usernameInput,
      passwordInput: this.passwordInput,
      confirmPasswordInput: this.confirmPasswordInput
    };
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
