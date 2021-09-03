export class Offer {
    supplier: String;
    price: number;
    date: Date;
    dueDate: Date;
    orderId: number;
    id: number;

    constructor(supplier: String, price: number, date: Date, dueDate: Date, orderId: number, id: number) {
        this.supplier = supplier;
        this.price = price;
        this.date = date;
        this.dueDate = dueDate;
        this.orderId = orderId;
        this.id = id;
    }
}