export class OrderedDrug {
    drugId: number;
    quantity: number;

    constructor(id: number, quantity: number) {
        this.drugId = id;
        this.quantity = quantity;
    }
}