package mr.send.money.sendmoney.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Account implements Serializable{
	  @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      private int id;
      private int numAccount;
      private int balance;
      private User user;
}
