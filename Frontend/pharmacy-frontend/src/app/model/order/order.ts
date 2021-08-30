import { OrderedDrug } from "./ordered-drug";
import { OrderStatus } from "./status";

export class Order {
    orderedDrugs: OrderedDrug[];
    createdBy: String;
    createdAt: Date;
    dueDate: Date;
    status: OrderStatus;
    id: number;

    constructor(orderedDrugs: OrderedDrug[], createdBy: String, createdAt: Date, dueDate: Date, status: OrderStatus, id: number) {
        this.orderedDrugs = orderedDrugs;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.dueDate = dueDate;
        this.status = status;
        this.id = id;
    }

}