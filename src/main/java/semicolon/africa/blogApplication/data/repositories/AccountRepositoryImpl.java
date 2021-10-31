package semicolon.africa.blogApplication.data.repositories;

import semicolon.africa.blogApplication.data.models.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryImpl implements AccountRepository{
    List<Account> accounts = new ArrayList<>();

    @Override
    public Account save(Account account) {
        accounts.add(account);
        return account;
    }

    @Override
    public Account findAccount(String userId) {
        for(Account account : accounts){
            if(account.getUserId().equalsIgnoreCase(userId));
            return account;
        }
        return null;
    }

    @Override
    public void deleteAccount(Account account) {
        accounts.remove(account);

    }

    @Override
    public void deleteAccount(String userId) {
        Account account = findAccount(userId);
        deleteAccount(account);

    }

    @Override
    public List<Account> findAllAccount() {
        return accounts;
    }
}
