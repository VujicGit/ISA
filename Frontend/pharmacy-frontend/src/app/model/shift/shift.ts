export class Shift {
    start: Date;
    end: Date;
    pharmacyId: number;
    employeeId: number;

    constructor(start: Date, end: Date, pharmacyId: number, employeeId: number) {
        this.start = start;
        this.end = end;
        this.pharmacyId = pharmacyId;
        this.employeeId = employeeId;
    }
}