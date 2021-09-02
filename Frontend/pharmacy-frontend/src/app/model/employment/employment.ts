import { Shift } from "../shift/shift";

export class Employment {
    dermatologistId: number;
    shiftDtos: Shift[]

    constructor(dermatologistId: number, shiftDtos: Shift[]) {
        this.dermatologistId = dermatologistId;
        this.shiftDtos = shiftDtos;
    }
}