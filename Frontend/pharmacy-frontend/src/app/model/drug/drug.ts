import { Allergy } from "./allergy";
import { Ingredient } from "./ingredient";

export class Drug {
    id: Number;
    name: String;
    code: String;
    manufacturer: String;
    note: String;
    form: Number;
    type: Number;
    dailyDose: String;
    ingredients: Ingredient[];
    allergies: Allergy[];

    constructor(
        id: number,
        name: String, 
        code: String, 
        manufacturer: String, 
        note: String, 
        form: Number, 
        type: Number, 
        dailyDose: String,
        ingredients: Ingredient[],
        allergies: Allergy[]
        ) {
            this.id = id;
            this.name = name;
            this.code = code;
            this.manufacturer = manufacturer;
            this.note = note;
            this.form = form;
            this.type = type;
            this.dailyDose = dailyDose;
            this.ingredients = ingredients;
            this.allergies = allergies;
        }

}
