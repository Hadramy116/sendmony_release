package mr.send.money.sendmoney.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class AppUser implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String userName;

	private String password;

	@ManyToMany(fetch=FetchType.EAGER)
	private Collection<AppRole> appRoles = new ArrayList<>();

	@OneToMany(mappedBy ="appUser", cascade= CascadeType.ALL)
    private Collection<Account> accounts;

	public AppUser() {
	}

	public AppUser(String userName, String password, Collection<AppRole> appRoles, Collection<Account> accounts) {
		this.userName = userName;
		this.password = password;
		this.appRoles = appRoles;
		this.accounts = accounts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<AppRole> getAppRoles() {
		return appRoles;
	}

	public void setAppRoles(Collection<AppRole> appRoles) {
		this.appRoles = appRoles;
	}

	public Collection<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Collection<Account> accounts) {
		this.accounts = accounts;
	}
}
