export class PredefinedExamination {
    dermatologistId: String;
    price: number;
    startDate: Date;
    endDate: Date;

    constructor(dermatologistId: String, price: number, startDate: Date, endDate: Date) {
        this.dermatologistId = dermatologistId;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}