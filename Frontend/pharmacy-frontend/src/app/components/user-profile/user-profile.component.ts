import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  userForm: FormGroup;

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
    this.fb.group({
      name:'',
      surname:'',
      email:'',
      address:'',
      city:'',
      country:'',
      phoneNumber:'',
      password:'',
      confirmPassword:''
    })
  }

  onSubmit() {
    
  }

}
