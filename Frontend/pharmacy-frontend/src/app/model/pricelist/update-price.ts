export class UpdatePrice{
    drugId: number;
    price: number;
    startPeriod: Date;
    endPeriod: Date;

    constructor(drugId: number, price: number, startPeriod: Date, endPeriod: Date) {
        this.drugId = drugId;
        this.price = price;
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
    }
}