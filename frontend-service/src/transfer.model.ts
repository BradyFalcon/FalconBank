class Transfer {
    static nextId: number=0;
    public id: number;
    public amount: number;
    public date: Date;
    public type: boolean;
    public account_number:number;

    constructor(id: number, amount: number, date: Date, type:boolean){
        Transfer.nextId++;
        this.id=Transfer.nextId
        this.amount=amount
        this.date=date;
        this.type=false;
        
    }

}
export{Transfer}