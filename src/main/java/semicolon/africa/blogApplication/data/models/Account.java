package semicolon.africa.blogApplication.data.models;

import lombok.Data;

@Data
public class Account {
    private AccountType type;
    private String userId;

}
