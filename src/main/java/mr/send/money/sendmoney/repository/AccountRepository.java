package mr.send.money.sendmoney.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mr.send.money.sendmoney.entites.Account;
import mr.send.money.sendmoney.entites.AppUser;

public interface AccountRepository extends JpaRepository<Account, Integer>{
	
	public Account findByNumAccount(int numAccount);

}
