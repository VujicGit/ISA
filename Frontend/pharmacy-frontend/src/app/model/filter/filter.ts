export class Filter {
    name: String;
    surname: String;
    minGrade: number;
    maxGrade: number;
    pharmacyId: number;

    constructor(name: String, surname: String, minGrade: number, maxGrade: number, pharmacyId: number) {
        this.name = name;
        this.surname = surname;
        this.minGrade = minGrade;
        this.maxGrade = maxGrade;
        this.pharmacyId = pharmacyId;
    }
}