export class SearchDermatologist {
    name: String;
    surname: String;
    pharmacies: String[];
    grade: number;
    id: number;

    constructor(name: String, surname: String, pharmacies: String[], grade: number, id: number) {
        this.name = name;
        this.surname = surname;
        this.pharmacies = pharmacies;
        this.grade = grade;
        this.id = id;
    }
}
