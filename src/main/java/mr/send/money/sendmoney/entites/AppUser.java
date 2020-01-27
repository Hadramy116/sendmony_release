package mr.send.money.sendmoney.entites;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class AppUser implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String userName;

	private String password;

	private AppRole role;

	@OneToMany(mappedBy ="appUser", cascade= CascadeType.ALL)
    private Collection<Account> accounts;

	public AppUser() {
	}

	public AppUser(String userName, String password, AppRole role, Collection<Account> accounts) {
		this.userName = userName;
		this.password = password;
		this.role = role;
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

	public AppRole getRole() {
		return role;
	}

	public void setRole(AppRole role) {
		this.role = role;
	}

	public Collection<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Collection<Account> accounts) {
		this.accounts = accounts;
	}
}
