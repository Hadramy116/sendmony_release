package mr.send.money.sendmoney.repository;

import jdk.nashorn.internal.runtime.options.Option;
import mr.send.money.sendmoney.entites.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import mr.send.money.sendmoney.entites.AppRole;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<AppRole, Integer>{

    Optional<AppRole> findAppRoleByRoleName(RoleName roleName);

}
