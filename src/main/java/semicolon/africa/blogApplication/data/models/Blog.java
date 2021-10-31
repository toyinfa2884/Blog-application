package semicolon.africa.blogApplication.data.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Blog {
    private final String blogId;
    private String name;
    private List<Account> accounts = new ArrayList<>();
}
