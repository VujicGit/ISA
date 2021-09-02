export class PredefinedExamination {
    dermatologistId: number;
    price: number;
    start: Date;
    end: Date;

    constructor(dermatologistId: number, price: number, startDate: Date, endDate: Date) {
        this.dermatologistId = dermatologistId;
        this.price = price;
        this.start = startDate;
        this.end = endDate;
    }
}