import {ACCOUNT_FILTERS} from "./account.filters";
import {Transfer} from './transfer.model';

const url="http://localhost:8080/users/1/accounts"


class TransferService {
transactions: Array<Transfer>=[]

transferMoney(id:number){
    return fetch(`${url}/${id}`,{
        method:'POST',
    }).then((response)=>response.json());
}
getTransactions(){

    return fetch(`${url}`, { method: 'GET' })
        .then(response => response.json());

}
}
export {TransferService}