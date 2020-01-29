package mr.send.money.sendmoney.security.service;

import mr.send.money.sendmoney.entites.AppUser;
import mr.send.money.sendmoney.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class SpringUserDetailsService implements UserDetailsService {

    private final UserServiceImp userServiceImp;

    public SpringUserDetailsService(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUser appUser = userServiceImp.findUserByUsername(userName);
        if (appUser == null) throw new UsernameNotFoundException(userName);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        appUser.getAppRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName().toString()));
        });
        return new User(appUser.getUserName(), appUser.getPassword(), authorities);
    }
}
