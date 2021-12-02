import {ACCOUNT_FILTERS} from "./account.filters";
import {Account} from "./account.model";

const url="http://localhost:8080/users/1/accounts"

class AccountService{
    accounts: Array<Account> = []
    
    

    saveAccount(account:string){
        return fetch(url,{
            method: 'GET',
            body: JSON.stringify({account}),
            headers: {
                'Content-Type':'application/json'
            }
        })
    }
    getAccount(id: string) {
        return fetch(`${url}/${id}`, { method: 'GET' })
            .then(response => response.json());

    }

}

export{AccountService}


