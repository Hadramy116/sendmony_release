package mr.send.money.sendmoney.service.util;

import mr.send.money.sendmoney.entites.Account;
import mr.send.money.sendmoney.entites.Transaction;
import mr.send.money.sendmoney.service.util.UserDto.CreditOrDebitForm;
import mr.send.money.sendmoney.service.util.UserDto.SendingForm;

public interface OperationService {

    Transaction creditAccount(CreditOrDebitForm creditOrDebitForm);

    Transaction debitAccount(CreditOrDebitForm creditOrDebitForm);

    Transaction sendMoney(SendingForm sendingForm);

}