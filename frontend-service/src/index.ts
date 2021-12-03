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

transferServ.addEventListener('click', e=>{
    e.preventDefault();

    const dataset=(<HTMLButtonElement>e.target).dataset
    const action = dataset['action']

    if(action==='submit')
    { const id=dataset['id']
    transferService.transferMoney(Number.parseInt(id))
        .then(response=>{
            renderAccount()
        
        })

    }
})

async function renderAccount(){
    const number="1";

    const account=await accountService.getAccount(number)
    const transfer=await transferService.getTransactions(Transfer)

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
async function displayTransactionByDate(filter='TRANSACTION'){

    
transferList.addEventListener('options',e=>{
    e.stopImmediatePropagation

    

})
}