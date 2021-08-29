export class Login {
    email: String;
    password: String;
    pharmacyId: number;

    constructor(email: String, password: String, pharmacyId: number) {
        this.email = email;
        this.password = password;
        this.pharmacyId = pharmacyId;
    }
}