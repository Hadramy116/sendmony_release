package mr.send.money.sendmoney.service.imp;

import mr.send.money.sendmoney.entites.AppUser;
import mr.send.money.sendmoney.repository.RoleRepository;
import mr.send.money.sendmoney.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    public Boolean existByUsername(String userName) {
        return userRepository.existsByUserName(userName);
    }

    public Optional<AppUser> findUserByUsername(String userName) {
        return userRepository.findAppUserByUserName(userName);

    }

}
