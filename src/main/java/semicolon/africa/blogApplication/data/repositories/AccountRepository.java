package semicolon.africa.blogApplication.data.repositories;

import semicolon.africa.blogApplication.data.models.Account;

import java.util.List;

public interface AccountRepository {
    Account save(Account account);
    Account findAccount(String userId);
    void deleteAccount(Account account);
    void deleteAccount(String userId);
    List<Account> findAllAccount();

}
