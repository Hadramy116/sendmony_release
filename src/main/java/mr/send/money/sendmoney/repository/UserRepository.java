package mr.send.money.sendmoney.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mr.send.money.sendmoney.entites.AppUser;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long>{
	
	Optional<AppUser> findAppUserByUserName(String userName);

	Boolean existsByUserName(String userName);
}
