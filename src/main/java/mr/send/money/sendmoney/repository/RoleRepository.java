package mr.send.money.sendmoney.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mr.send.money.sendmoney.entites.AppRole;

public interface RoleRepository extends JpaRepository<AppRole, Integer>{
	

}
