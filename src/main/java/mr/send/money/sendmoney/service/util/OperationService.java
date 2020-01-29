package mr.send.money.sendmoney.service.util;

import mr.send.money.sendmoney.entites.Account;

public interface OperationService {

    void creditAccount(Account account, Double amount);

    void debitAccount(Account account, Double amount);

    void sendMoney(Account sender, Account receiver, Double amount);

}