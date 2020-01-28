package mr.send.money.sendmoney.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mr.send.money.sendmoney.entites.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Integer>{
	
	public AppUser findByUserName(String name);
	

}
