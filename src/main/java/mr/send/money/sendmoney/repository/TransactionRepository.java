package mr.send.money.sendmoney.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mr.send.money.sendmoney.entites.Account;
import mr.send.money.sendmoney.entites.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction , Integer>{
     
	public Transaction findBySender(Account sender);
	public Transaction findByReceiver(Account receiver);
	
}
