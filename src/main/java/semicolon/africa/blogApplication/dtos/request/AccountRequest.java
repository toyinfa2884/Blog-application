package semicolon.africa.blogApplication.dtos.request;

import lombok.Data;
import semicolon.africa.blogApplication.data.models.AccountType;
@Data
public class AccountRequest {
    private String blogId;
    private String firstName;
    private String lastName;
    private AccountType accountType;
}
