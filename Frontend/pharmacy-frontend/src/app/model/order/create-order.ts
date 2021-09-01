import { DrugList } from "../drug/drug-list";
import { OrderedDrug } from "./ordered-drug";

export class CreateOrder {
    orderedDrugs: OrderedDrug[]
    dueDate: Date;

    constructor(orderedDrugs: OrderedDrug[], dueDate: Date) {
        this.orderedDrugs = orderedDrugs;
        this.dueDate = dueDate;
    }
}