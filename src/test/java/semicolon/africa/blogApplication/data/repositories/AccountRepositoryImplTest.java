package semicolon.africa.blogApplication.data.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import semicolon.africa.blogApplication.data.models.Account;
import semicolon.africa.blogApplication.data.models.AccountType;

import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryImplTest {
    private AccountRepository accountRepository;

    @BeforeEach
    void setUp() {
        accountRepository = new AccountRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        Account account = new Account();
        account.setUserId("01");
        account.setType(AccountType.USER);
        Account saveAccount = accountRepository.save(account);
        assertEquals(account, saveAccount);
    }

    @Test
    void findAccount() {
        Account account =new Account();
        account.setUserId("02");
        account.setType(AccountType.ADMIN);
        accountRepository.save(account);
        //when
        Account foundAccount = accountRepository.findAccount("02");
        assertEquals(account, foundAccount);
    }

    @Test
    void deleteAccount() {
        Account account = new Account();
        account.setUserId("03");
        account.setType(AccountType.USER);

        accountRepository.save(account);
        assertNotNull(accountRepository.findAccount("03"));
        //when
        accountRepository.deleteAccount(account);
        assertNull(accountRepository.findAccount("03"));

    }

    @Test
    void testDeleteAccountByUserId() {
        Account account = new Account();
        account.setUserId("03");
        account.setType(AccountType.ADMIN);
        accountRepository.save(account);
        assertNotNull(accountRepository.findAccount("03"));
        //when
        accountRepository.deleteAccount("03");
        assertNull(accountRepository.findAccount("03"));

    }

    @Test
    void findAllAccount() {
        Account account = new Account();
        account.setUserId("03");
        account.setType(AccountType.USER);

        accountRepository.save(account);
        accountRepository.save(account);
        accountRepository.save(account);
        assertEquals(3, accountRepository.findAllAccount().size());
    }
}