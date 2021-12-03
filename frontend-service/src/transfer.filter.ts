import {Transfer} from "./transfer.model"

const TRANSACTION_FILTERS: any= {
    ALL: () => Transfer.nextId++,
    BYDATE: () => Date.now
}
export {TRANSACTION_FILTERS}