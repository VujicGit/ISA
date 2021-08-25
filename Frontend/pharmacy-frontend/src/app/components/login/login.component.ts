import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { Login } from 'src/app/model/login/login';
import { AuthService } from 'src/app/services/auth-service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;

  email: String;
  password: String;

  loginDto: Login;

  constructor(private fb: FormBuilder, private authService: AuthService, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: '',
      password: ''
    })

    localStorage.setItem("pharmacyId", "1");

    this.loginForm.valueChanges.subscribe(value => {
      this.email = value.email;
      this.password = value.password;
    })
  }

  login() {
    let pharmacyId = localStorage.getItem("pharmacyId")
    this.loginDto = new Login(this.email, this.password, Number.parseFloat(pharmacyId));
    this.authService.login(this.loginDto).subscribe();
  }

}
