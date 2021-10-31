package semicolon.africa.blogApplication.data.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class User {
    private String userId;
    private List<Account> accounts = new ArrayList<>();
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
