package mr.send.money.sendmoney.service.imp;

import mr.send.money.sendmoney.entites.Account;
import mr.send.money.sendmoney.entites.Transaction;
import mr.send.money.sendmoney.entites.TxType;
import mr.send.money.sendmoney.repository.AccountRepository;
import mr.send.money.sendmoney.repository.TransactionRepository;
import mr.send.money.sendmoney.service.util.OperationService;
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
    public void creditAccount(Account account, Double amount) {
        if (accountRepository.existsById(account.getId())) {
            account.setBalance(account.getBalance() + amount);

            transactionRepository.save(new Transaction(UUID.randomUUID().toString(), "RECHARGE ", amount, new Date(), account, null, TxType.RECHARGE));
        }
    }

    @Override
    public void debitAccount(Account account, Double amount) {
        if (accountRepository.existsById(account.getId())) {
            if (account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
                accountRepository.save(account);

                transactionRepository.save(new Transaction(UUID.randomUUID().toString(), "RETRAIT", amount, new Date(), account, null, TxType.RETRAIT));

            }
        }
    }

    @Override
    public void sendMoney(Account sender, Account receiver, Double amount) {
        if (accountRepository.existsById(sender.getId()) && accountRepository.existsById(receiver.getId())) {
            if (sender.getBalance() >= amount) {
                sender.setBalance(sender.getBalance() - amount);
                receiver.setBalance(receiver.getBalance() + amount);

                accountRepository.save(sender);
                accountRepository.save(receiver);

                transactionRepository.save(new Transaction(UUID.randomUUID().toString(), "Trasfert", amount, new Date(), sender, receiver, TxType.TRANSFERT));
            }
        }
    }
}
