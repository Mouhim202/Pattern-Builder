package net.mhm;

import net.mhm.model.AccountStatus;
import net.mhm.model.AccountType;
import net.mhm.model.BankAccount;
import net.mhm.model.Customer;

public class Test2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        BankAccount account1=new BankAccount();
        account1.setAccountId(1L);
        account1.setCurrency("MAD");
        account1.setBalance(1000);
        account1.setType(AccountType.CURRENT_ACCOUNT);
        account1.setStatus(AccountStatus.ACTIVATED);
        account1.setCustomer(new Customer(1L,"Meryem"));

//        BankAccount account2=new BankAccount();
//        account2.setAccountId(account1.getAccountId());
//        account2.setCurrency(account1.getCurrency());
//        account2.setBalance(account1.getBalance());
//        account2.setType(account1.getType());
//        account2.setStatus(account1.getStatus());

        BankAccount account3=account1.clone();
        System.out.println(account1);
        System.out.println(account3);
        System.out.println("================================");
        account1.getCustomer().setName("hassan");
        System.out.println(account1);
        System.out.println(account3);


    }

}
