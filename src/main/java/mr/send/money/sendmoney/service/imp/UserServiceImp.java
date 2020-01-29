package mr.send.money.sendmoney.service.imp;

import mr.send.money.sendmoney.entites.AppRole;
import mr.send.money.sendmoney.entites.AppUser;
import mr.send.money.sendmoney.entites.RoleName;
import mr.send.money.sendmoney.repository.RoleRepository;
import mr.send.money.sendmoney.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImp {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserServiceImp(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<AppUser> findAll() {
        return userRepository.findAll();
    }

    public AppUser save(AppUser appUser) {
        return userRepository.save(appUser);
    }

    public void addRoleToUser(String username, RoleName roleName) {
        AppUser user=userRepository.findByUserName(username);
        AppRole role=roleRepository.findAppRoleByRoleName(roleName);
        user.getAppRoles().add(role);
        userRepository.save(user);
    }

    public Boolean existByUsername(String userName) {
        return userRepository.existsByUserName(userName);
    }

    public AppUser findUserByUsername(String userName) {
        return userRepository.findByUserName(userName);
    }

}
