package mr.send.money.sendmoney.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AppRole implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private RoleName roleName;

	public AppRole() {
	}

	public AppRole(RoleName roleName) {
		this.roleName = roleName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RoleName getRoleName() {
		return roleName;
	}

	public void setRoleName(RoleName roleName) {
		this.roleName = roleName;
	}
}
