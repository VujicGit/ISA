export class User {
    name: string;
    surname: string;
    email: string;
    address: string;
    city: string;
    country: string;
    phoneNumber: string;
    password: string;
    confirmPassword: string;

    constructor(name: string, surname: string, email: string, address: string, city: string, country: string, phoneNumber: string,
         password: string, confirmPassword: string) {
            this.name = name;
            this.surname = name;
            this.email = email;
            this.address = address;
            this.city = city;
            this.country = country;
            this.phoneNumber = phoneNumber;
            this.password = password;
            this.confirmPassword = confirmPassword;
    }
}