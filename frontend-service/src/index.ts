import './index.scss'
import {Account} from './account.model'
import {Transfer} from './transfer.model'
import {AccountService}from './account.service'
import{TransferService} from './transfer.service'
import { filter } from 'rxjs-compat/operator/filter'
const accountService=new AccountService()
const transferService=new TransferService()



const transferServ=document.getElementById('transfer-service')
const transferList=document.getElementById('transfer-list')
const accountListEle=document.getElementById("account-list")
const transferDates=document.getElementById("transfer-dates")

transferServ.addEventListener('click', e=>{
    e.preventDefault();

    const dataset=(<HTMLButtonElement>e.target).dataset
    const action = dataset['action']

    if(action==='submit')
    { const id=dataset['id']
    const number="1";
    accountService.getAccount(number)
        .then(response=>{
            transferService.transferMoney(Number.parseInt(id))
            renderAccount()
        
        })

    }
})
    
transferDates.addEventListener('click',e=>{
    e.stopPropagation();

    const dataset = (<HTMLInputElement>e.target).dataset;
    const action = dataset['action']

    if(action==="1"){
        
    }
    if(action==="2"){}

})

async function renderAccount(){
    const number="1";

    const account=await accountService.getAccount(number)
    const transfer=await transferService.getTransactions(Transfer.nextId)

    const accountListElements=account.transactions.map((transaction: any)=>{
        return `
        <li class="list-group-item d-flex justify-content-between data-id=${account.number}"> 
         <span>${account.number}</span>
         <span>${account.balance}</span>
         <span>${transfer.amount}</span>
         <span>${transfer.date}</span>
        </li>
    `
    });
    accountListEle.innerHTML=accountListElements.join("")
}renderAccount();

//-------------------------------------------------------









    



