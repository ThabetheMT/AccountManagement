package org.unclecodes.int_tutorial1.accountcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.unclecodes.int_tutorial1.account.Account;
import org.unclecodes.int_tutorial1.account.AccountService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public void createAccount(@RequestBody Account account){
        accountService.createAccount(account);
    }

    @GetMapping("/search/{accountNumber}")
    public Account searchAccount(@PathVariable String accountNumber) {
        return accountService.searchAccount(accountNumber);
    }

    @GetMapping("/all")
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @PutMapping("/edit/{accountNumber}")
    public void editAccountDetails(@PathVariable String accountNumber, @RequestBody Account account){
        accountService.editAccountDetails(accountNumber,account);
    }

    @DeleteMapping("/delete/{accountNumber}")
    public void removeAccount(@PathVariable String accountNumber){
        accountService.removeAccount(accountNumber);
    }

    @GetMapping("/count")
    public Long numberOfAccountsStored(){
        return accountService.numberOfAccountsStored();
    }

    @GetMapping("/getbybalance/{balance}")
    public List<Account> getAccountsByBalance(@PathVariable double balance){
        return accountService.getAccountsByBalance(balance);
    }

    @GetMapping("/getbyholder/{id}")
    public Account getAccountByHolderId(@PathVariable String id){
        return accountService.getAccountByHolderId(id);
    }
}
