package mr.send.money.sendmoney.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account implements Serializable{

	  @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      private int id;
      private int numAccount;
      private int balance;
      private AppUser appUser;

      public Account() {
      }

      public Account(int numAccount, int balance, AppUser appUser) {
            this.numAccount = numAccount;
            this.balance = balance;
            this.appUser = appUser;
      }

      public int getId() {
            return id;
      }

      public void setId(int id) {
            this.id = id;
      }

      public int getNumAccount() {
            return numAccount;
      }

      public void setNumAccount(int numAccount) {
            this.numAccount = numAccount;
      }

      public int getBalance() {
            return balance;
      }

      public void setBalance(int balance) {
            this.balance = balance;
      }

      public AppUser getAppUser() {
            return appUser;
      }

      public void setAppUser(AppUser appUser) {
            this.appUser = appUser;
      }
}
