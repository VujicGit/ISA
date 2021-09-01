import { Allergy } from "./allergy";
import { Ingredient } from "./ingredient";

export class Drug {
    name: String;
    code: String;
    manufacturer: String;
    note: String;
    contraindications: String;
    dailyDose: String;
    ingredients: Ingredient[];
    quantity: number;
    drugId: number;

    constructor(
        name: String, 
        code: String, 
        manufacturer: String, 
        note: String, 
        contraindications: String,
        dailyDose: String,
        ingredients: Ingredient[],
        quantity: number,
        drugId: number
        ) {
            this.name = name;
            this.code = code;
            this.manufacturer = manufacturer;
            this.note = note;
            this.dailyDose = dailyDose;
            this.ingredients = ingredients;
            this.quantity = quantity;
            this.contraindications = contraindications;
            this.drugId = drugId;
        }

}
