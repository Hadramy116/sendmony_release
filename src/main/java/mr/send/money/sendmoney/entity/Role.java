package mr.send.money.sendmoney.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Role implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private enum name{
		Admin,
		simpleUser;
	}

}
