export class SearchDermatologist {
    name: String;
    surname: String;
    pharmacies: String[];
    grade: number;

    constructor(name: String, surname: String, pharmacies: String[], grade: number) {
        this.name = name;
        this.surname = surname;
        this.pharmacies = pharmacies;
        this.grade = grade;
    }
}
