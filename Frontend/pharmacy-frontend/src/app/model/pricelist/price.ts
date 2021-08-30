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

    equal(price: Price) : boolean {
        let startDate = this.getWithoutTime(this.startPeriod);
        let endDate = this.getWithoutTime(this.endPeriod);
        console.log(startDate === this.getWithoutTime(price.startPeriod));
        return this.drugName === price.drugName 
            && this.drugCode === price.drugCode
            && this.drugId === price.drugId
            && this.price === price.price
            && startDate === this.getWithoutTime(price.startPeriod)
            && endDate === this.getWithoutTime(price.endPeriod);
    }

    private getWithoutTime(date: Date) {
        let d = new Date(date.getTime());
        d.setHours(0, 0, 0, 0);
        return d;
    }
}