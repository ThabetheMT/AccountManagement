package org.unclecodes.int_tutorial1.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unclecodes.int_tutorial1.accountholder.AccountHolder;
import org.unclecodes.int_tutorial1.accountholder.AccountHolderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountHolderRepository accountHolderRepository;

    public void createAccount(Account account){
        String id = account.getAccountHolder().getId();
        Optional<AccountHolder> accountHolder = accountHolderRepository.findById(id);
        account.setAccountHolder(accountHolder.get());
        accountRepository.save(account);
    }

    public Account searchAccount(String accountNumber){
        return accountRepository.findById(accountNumber).get();
    }

    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public void editAccountDetails(String accountNumber ,Account account){
        Account account1 = accountRepository.findById(accountNumber).get();
        account1.setAccountType(account.getAccountType());
        account1.setBalance(account.getBalance());
        accountRepository.save(account1);
    }

    public void removeAccount(String accountNumber){
        accountRepository.deleteById(accountNumber);
    }

    public Long numberOfAccountsStored(){
        return accountRepository.count();
    }

    public List<Account> getAccountsByBalance(double balance){
        return accountRepository.findByBalance(balance);
    }

    public Account getAccountByHolderId(String id){
        return accountRepository.findByAccountHolderId(id);
    }
}
