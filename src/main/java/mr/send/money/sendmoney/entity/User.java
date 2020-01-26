package mr.send.money.sendmoney.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class User implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String userName;
	private String password;
	private Role type;
	@OneToMany( mappedBy ="user", cascade= CascadeType.ALL)
    private Collection<Account> Accounts;
    

}
