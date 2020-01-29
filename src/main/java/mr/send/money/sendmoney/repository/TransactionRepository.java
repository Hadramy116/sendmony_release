package mr.send.money.sendmoney.repository;

import org.omg.CORBA.TRANSACTION_MODE;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import mr.send.money.sendmoney.entites.Account;
import mr.send.money.sendmoney.entites.Transaction;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction , Integer>{

	List<Transaction> findAllBySender(Account sender);
	List<Transaction> findAllByReceiver(Account receiver);
	Page<Transaction> findAllByReceiverOrSender(Account sender, Account receiver, Pageable pageable);
	
}
