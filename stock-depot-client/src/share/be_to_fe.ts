/* tslint:disable */
/* eslint-disable */
// Generated using typescript-generator version 2.24.612 on 2022-05-28 13:39:09.

export class DepotView {
    depotName?: string;
    brokerName?: string;
    depotId?: number | null;
    depotOwnerId?: number;
}

export class DepotOwnerView {
    firstName?: string;
    lastName?: string;
    id?: string | null;
}

export class DividendView {
    dividend?: number;
    dividendDate?: Date;
    wkn?: string;
    currency?: string;
    depotId?: number;
}

export class StockView {
    name?: string;
    depotId?: number;
    wkn?: string;
    isin?: string;
    stockExchangeBuy?: string;
    sockExchangeSell?: string | null;
    buyDate?: Date;
    buyPrice?: number;
    sellDate?: Date | null;
    sellPrice?: number | null;
    quantity?: number;
    currency?: string;
    dividends?: Dividend[] | null;
}

export class Dividend {
    dividend?: number;
    dividendDate?: Date;
    wkn?: string;
    currency?: string;
    depotId?: number;
}
