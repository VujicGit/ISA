import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-pharmacy-profile',
  templateUrl: './pharmacy-profile.component.html',
  styleUrls: ['./pharmacy-profile.component.css']
})
export class PharmacyProfileComponent implements OnInit {

  profileInfoForm: FormGroup;
  constructor(private fb: FormBuilder) {
    
   }


  ngOnInit(): void {
    this.profileInfoForm = this.fb.group({
      name: '',
      address: '',
      description: '',

    })
    this.profileInfoForm.valueChanges.subscribe(console.log);
  }



}
