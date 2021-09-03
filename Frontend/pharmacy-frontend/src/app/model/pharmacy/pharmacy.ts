
export class Pharmacy {
    description: String;
    id: number;
    name: String;
    latitude: number;
    longitude: number;
    city: String;
    country: String;
    address: String;

    constructor(description: String, id: number, name: String, latitude: number, longitude: number, city: String, country: String, address: String) {
        this.description = description;
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.country = country;
        this.address = address;
    }
}