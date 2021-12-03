import {ACCOUNT_FILTERS} from "./account.filters";
import {Transfer} from './transfer.model';

const url="http://localhost:8080/users/1/accounts"


class TransferService {
transactions: Array<Transfer>=[]

transferMoney(number:number){
    return fetch(`${url}/${number}`,{
        method:'POST',
    }).then((response)=>response.json());
}
getTransactions(filter:any){

    return fetch(url, { method: 'GET' })
        .then(response => response.json());

}
}
export {TransferService}