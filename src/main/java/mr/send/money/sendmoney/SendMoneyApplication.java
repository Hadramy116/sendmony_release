package mr.send.money.sendmoney;

import mr.send.money.sendmoney.entites.AppRole;
import mr.send.money.sendmoney.entites.AppUser;
import mr.send.money.sendmoney.entites.RoleName;
import mr.send.money.sendmoney.repository.RoleRepository;
import mr.send.money.sendmoney.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SendMoneyApplication implements CommandLineRunner {

	@Autowired
	private UserServiceImp userServiceImp;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	PasswordEncoder encoder;



	public static void main(String[] args) {
		SpringApplication.run(SendMoneyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		userServiceImp.save(new AppUser("27766003",
				encoder.encode("ymardah1"),null,null));


		roleRepository.save(new AppRole(
				RoleName.SIMPLE_USER
		));

		roleRepository.save(new AppRole(
				RoleName.ADMIN
		));
	}
}
