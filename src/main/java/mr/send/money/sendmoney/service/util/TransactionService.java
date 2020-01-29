package mr.send.money.sendmoney.service.util;

import mr.send.money.sendmoney.entites.Account;
import mr.send.money.sendmoney.entites.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TransactionService {

    Transaction save(Transaction tx);

    Transaction findOne(Integer id);

    Page<Transaction> findAll(Pageable pageable);

    List<Transaction> findSendingTransactions(Account account);

    List<Transaction> findReceiveTransactions(Account account);

    Page<Transaction> findMyAllTransactions(Account account, Pageable pageable);

    void delete(Integer id);
}
