package net.mhm;

import net.mhm.model.AccountStatus;
import net.mhm.model.AccountType;
import net.mhm.model.BankAccount;
import net.mhm.model.BankDirector;
import net.mhm.repository.AccountRepository;
import net.mhm.repository.AccountRepositoryImpl;
import net.mhm.util.JsonSerializer;

import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        JsonSerializer<BankAccount> bankAccountJsonSerializer=new JsonSerializer<>();
        AccountRepositoryImpl accountRepository= AccountRepositoryImpl.getInstance();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                accountRepository.populateData();
            }).start();
            
        }
        System.out.print("Tape a character:");
        System.in.read();

        List<BankAccount> bankAccounts = accountRepository.searchAccounts(bankAccount -> bankAccount.getStatus().equals(AccountStatus.ACTIVATED));
        bankAccounts.stream()
                .map(bankAccountJsonSerializer::toJson)
                .forEach(System.out::println);
        /*
        System.out.println("==============================");
       BankAccount account  = accountRepository.findById(1L).orElse(null);
       if (account!=null){
           System.out.println(bankAccountJsonSerializer.toJson(account));
       }
       */



    }
}