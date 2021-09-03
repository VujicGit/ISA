import { AfterViewInit, Component, OnInit } from '@angular/core';
import { Loader } from '@googlemaps/js-api-loader';
import { AddressInfo } from 'src/app/model/maps/maps-data';
import { MapService } from 'src/app/services/map-service/map.service';



@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {

  latitude: number;
  longitude: number;
  constructor(private mapService: MapService) { }



  map: google.maps.Map;
  marker: google.maps.Marker;
  ngOnInit(): void {
    this.latitude = 35.2271
    this.longitude =  -80.8431;

    const mapProperties = {
      center: new google.maps.LatLng(this.latitude, this.longitude),
      zoom: 15,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };

  
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



  onChoseLocation() {

    let addressData = new AddressInfo();
    
    this.mapService.getResults(this.latitude.toString(), this.longitude.toString()).subscribe(
      data => {
      
       let array = data['results'][0]['address_components'];
       array.forEach(element1 => {
         let types = element1['types'];
         types.forEach(element => {
           if(element === 'country') {
             addressData.country = element1['long_name'];
             addressData.coutry_code = element1['short_name'];
           }
           if(element === 'street_number') {
            addressData.street_number = element1['long_name'];
          }
          if(element === 'route') {
            addressData.route = element1['long_name'];
          }
          if(element === 'postal_code') {
            addressData.route = element1['long_name'];
          }
         });
       });

       console.log(addressData);
      }

      
    )
  }

}
