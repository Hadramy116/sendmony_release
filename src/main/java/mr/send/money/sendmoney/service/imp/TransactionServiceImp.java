package mr.send.money.sendmoney.service.imp;

import mr.send.money.sendmoney.entites.Account;
import mr.send.money.sendmoney.entites.Transaction;
import mr.send.money.sendmoney.repository.TransactionRepository;
import mr.send.money.sendmoney.service.util.TransactionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TransactionServiceImp implements TransactionService {

    private TransactionRepository transactionRepository;

    public TransactionServiceImp(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction save(Transaction tx) {
        return this.transactionRepository.save(tx);
    }

    @Override
    public Transaction findOne(Integer id) {
        return this.transactionRepository.getOne(id);
    }

    @Override
    public Page<Transaction> findAll(Pageable pageable) {
        return transactionRepository.findAll(pageable);
    }

    @Override
    public List<Transaction> findSendingTransactions(Account account) {
        return transactionRepository.findAllBySender(account);
    }

    @Override
    public List<Transaction> findReceiveTransactions(Account account) {
        return transactionRepository.findAllByReceiver(account);
    }

    @Override
    public Page<Transaction> findMyAllTransactions(Account account, Pageable pageable) {
        return transactionRepository.findAllByReceiverOrSender(account, account, pageable);
    }

    @Override
    public void delete(Integer id) {
        transactionRepository.deleteById(id);
    }
}
