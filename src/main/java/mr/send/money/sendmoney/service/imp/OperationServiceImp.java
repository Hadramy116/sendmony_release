package mr.send.money.sendmoney.service.imp;

import mr.send.money.sendmoney.entites.Account;
import mr.send.money.sendmoney.entites.Transaction;
import mr.send.money.sendmoney.entites.TxType;
import mr.send.money.sendmoney.repository.AccountRepository;
import mr.send.money.sendmoney.repository.TransactionRepository;
import mr.send.money.sendmoney.service.util.OperationService;
import mr.send.money.sendmoney.service.util.UserDto.CreditOrDebitForm;
import mr.send.money.sendmoney.service.util.UserDto.SendingForm;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class OperationServiceImp implements OperationService {

    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;

    public OperationServiceImp(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction creditAccount(CreditOrDebitForm creditOrDebitForm) {
        Account account = accountRepository.findByNumAccount(creditOrDebitForm.getNumAccount());
        if (account != null) {
            account.setBalance(account.getBalance() + creditOrDebitForm.getAmount());
            return  transactionRepository.save(new Transaction(UUID.randomUUID().toString(), "RECHARGE ", creditOrDebitForm.getAmount(), new Date(), account, null, TxType.RECHARGE));
        }
        return null;
    }

    @Override
    public Transaction debitAccount(CreditOrDebitForm creditOrDebitForm) {
        Account account = accountRepository.findByNumAccount(creditOrDebitForm.getNumAccount());
        if (account != null) {
            if (account.getBalance() >= creditOrDebitForm.getAmount()) {
                account.setBalance(account.getBalance() - creditOrDebitForm.getAmount());
                accountRepository.save(account);
               return transactionRepository.save(new Transaction(UUID.randomUUID().toString(), "RETRAIT", creditOrDebitForm.getAmount(), new Date(), account, null, TxType.RETRAIT));
            }
        }
        return null;
    }

    @Override
    public Transaction sendMoney(SendingForm sendingForm) {
        Account receiver = accountRepository.findByNumAccount(sendingForm.getNumAccountReceiver());
        Account sender = accountRepository.findByNumAccount(sendingForm.getNumAccountSender());
        if (receiver !=null && sender != null) {
            if (sender.getBalance() >= sendingForm.getAmount()) {
                sender.setBalance(sender.getBalance() - sendingForm.getAmount());
                receiver.setBalance(receiver.getBalance() + sendingForm.getAmount());
                accountRepository.save(sender);
                accountRepository.save(receiver);
               return transactionRepository.save(new Transaction(UUID.randomUUID().toString(), "Trasfert", sendingForm.getAmount(), new Date(), sender, receiver, TxType.TRANSFERT));
            }
        }
        return null;
    }
}
