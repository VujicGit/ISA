export class Price {
    drugName: String;
    drugCode: String;
    drugId: number;
    price: number;
    startPeriod: Date;
    endPeriod: Date;

    constructor(drugName: String, drugCode: String, drugId: number, price: number, startPeriod: Date, endPeriod: Date) {
        this.drugName = drugName;
        this.drugCode = drugCode;
        this.drugId = drugId;
        this.price = price;
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
    }

}