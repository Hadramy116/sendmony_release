package mr.send.money.sendmoney.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int transactionNumber;
	private String desc;
	private String Amount;
	private Date date;
	private Account sender;
	private Account Reseiver;
	private enum type{
		Recharge,
		Retrait,
		transfert;
		
	}

}
