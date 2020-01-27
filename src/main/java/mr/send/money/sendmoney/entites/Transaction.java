package mr.send.money.sendmoney.entites;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class Transaction implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull
	private String transactionNumber;
	private String desc;
	@NotNull
	private String amount;
	private Date date;
	@NotNull
	private Account sender;
	@NotNull
	private Account receiver;
	@NotNull
	private TxType txType;

	public Transaction() {
	}

	public Transaction(String transactionNumber, String desc, String amount, Date date, Account sender, Account receiver,  TxType txType) {
		this.transactionNumber = transactionNumber;
		this.desc = desc;
		this.amount = amount;
		this.date = date;
		this.sender = sender;
		this.receiver = receiver;
		this.txType = txType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Account getSender() {
		return sender;
	}

	public void setSender(Account sender) {
		this.sender = sender;
	}

	public Account getReceiver() {
		return receiver;
	}

	public void setReceiver(Account receiver) {
		this.receiver = receiver;
	}

	public TxType getTxType() {
		return txType;
	}

	public void setTxType(TxType txType) {
		this.txType = txType;
	}
}
