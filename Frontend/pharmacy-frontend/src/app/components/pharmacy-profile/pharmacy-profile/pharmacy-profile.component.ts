import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';
import { AddressInfo } from 'src/app/model/maps/maps-data';
import { Pharmacy } from 'src/app/model/pharmacy/pharmacy';
import { State } from 'src/app/model/state/state';
import { MapService } from 'src/app/services/map-service/map.service';
import { PharmacyServiceService } from 'src/app/services/pharmacy-service/pharmacy-service.service';
import { StateServiceService } from 'src/app/services/state-service/state-service.service';

@Component({
  selector: 'app-pharmacy-profile',
  templateUrl: './pharmacy-profile.component.html',
  styleUrls: ['./pharmacy-profile.component.css']
})
export class PharmacyProfileComponent implements OnInit {

  latitude: number;
  longitude: number;
  pharmacyName: String;
  city: String;
  address: String;
  description: String;
  name: string;

  addressInfo: AddressInfo;

  stateCtrl = new FormControl();
  filteredStates: Observable<State[]>;
  state : String;
  states: State[];

  

  pharmacy: Pharmacy;

  map: google.maps.Map;
  marker: google.maps.Marker;

  profileInfoForm: FormGroup;
  constructor(private fb: FormBuilder, private mapService: MapService, private pharmacyService: PharmacyServiceService, private stateService: StateServiceService) {
    
    this.stateService.getStates().subscribe(
      success => {
        this.states = success;
        this.filteredStates = this.stateCtrl.valueChanges
      .pipe(
        startWith(''),
        map(state => state ? this._filterStates(state) : this.states.slice())
      );
      }
    )
   }

 
   private _filterStates(value: string): State[] {
    const filterValue = value.toLowerCase();
    this.state = filterValue;
    return this.states.filter(state => state.name.toLowerCase().includes(filterValue));
  }

  public getState() {
    if (this.state === undefined) {
      return
    } else {
      console.log(this.state)
    }
    
  }

  public getStateData(state : State) {
    this.state = state.name;
  }
  


  ngOnInit(): void {

    
    this.addressInfo = new AddressInfo();

    this.profileInfoForm = this.fb.group({
      name: '',
      description: '',
      city: '',
      address: '',

    })
    this.profileInfoForm.valueChanges.subscribe(data => {
      this.name = data.name;
      this.city = data.city;
      this.description = data.description;
      this.address = data.address;
      
    });

    

    this.getPharmacy(1);

    
  }

  getPharmacy(id: number) {
    this.pharmacyService.findById(id).subscribe(
      data => {
        this.pharmacy = data;
        this.profileInfoForm.get('description').setValue(this.pharmacy.description);
        this.profileInfoForm.get('city').setValue(this.pharmacy.city);
        this.profileInfoForm.get('address').setValue(this.pharmacy.address);
        this.state = this.pharmacy.country;
        this.latitude = this.pharmacy.latitude;
        this.longitude = this.pharmacy.longitude;
        
        this.setMap();
      
      }
    )
  }


  update() {
    let id = localStorage.getItem('pharmacyId');

    let pharmacy = new Pharmacy(this.description, Number(id), this.name, this.latitude, this.longitude, this.city, this.state, this.address);
    this.pharmacyService.update(pharmacy).subscribe(
      success => {
        console.log(success);
      },
      error => {
        console.log(error);
      }
    )
  }


  onChoseLocation() {

    
    
    this.mapService.getResults(this.latitude.toString(), this.longitude.toString()).subscribe(
      data => {
        console.log(data);
       let array = data['results'][0]['address_components'];
       array.forEach(element1 => {
         let types = element1['types'];
         types.forEach(element => {
           if(element === 'country') {
             this.addressInfo.country = element1['long_name'];
             this.addressInfo.coutry_code = element1['short_name'];
            
           }
           if(element === 'street_number') {
            this.addressInfo.street_number = element1['long_name'];
          }
          if(element === 'route') {
            this.addressInfo.route = element1['long_name'];
            this.address = this.addressInfo.route;
            this.profileInfoForm.get('address').setValue(this.address);
            
          }
          if(element === 'postal_code') {
            this.addressInfo.postal_code = element1['long_name'];
          
          }
         });
       });

       console.log(this.addressInfo);
      }

      
      

      
    )
  }

  setMap() {
    const mapProperties = {
      center: new google.maps.LatLng(this.latitude, this.longitude),
      zoom: 15,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };

    console.log("LAt: " + this.latitude, " LONG: " + this.longitude);
  
    this.map = new google.maps.Map(document.getElementById('map'), mapProperties);
    this.marker = new google.maps.Marker({
      position: {lat:this.latitude, lng: this.longitude},
      map: this.map,
     

      
    });
    this.map.addListener("click", (mapsMouseEvent) => {
      this.latitude = mapsMouseEvent.latLng.lat();
      this.longitude = mapsMouseEvent.latLng.lng();
      this.marker.setMap(null);
      this.marker = new google.maps.Marker({
        position: { lat: this.latitude, lng: this.longitude },
        map: this.map,

      });
     
    });


    this.map.addListener("click", () => this.onChoseLocation())
  }

}
