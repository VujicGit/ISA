export class CreatePromotion {
    
    description: String;
    start: Date;
    end: Date;

    constructor(description: String, start: Date, end:Date) {
        this.description = description;
        this.start = start;
        this.end = end;
        
    }
}