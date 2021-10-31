package semicolon.africa.blogApplication.services;

import semicolon.africa.blogApplication.data.models.Account;
import semicolon.africa.blogApplication.data.models.AccountType;
import semicolon.africa.blogApplication.data.models.Blog;
import semicolon.africa.blogApplication.data.models.User;
import semicolon.africa.blogApplication.data.repositories.BlogRepository;
import semicolon.africa.blogApplication.data.repositories.BlogRepositoryImpl;
import semicolon.africa.blogApplication.dtos.request.AccountRequest;

import java.util.List;

public class BlogServiceImpl implements BlogService{
    private final BlogRepository blogRepository = new BlogRepositoryImpl();
    private final UserService userService = new UserServiceImpl();
    private int lastIdCreated = 0;
    @Override
    public String createBlog(String blogName) {
        String blogId = generateBlogId();
        Blog blog = new Blog(blogId);
        blog.setName(blogName);
        Blog savedBlog = blogRepository.save(blog);
        return savedBlog.getBlogId();
    }

    private String generateBlogId() {
        int lastIdCreated = findAllBlogs().size();
        return String.format("%02d", ++lastIdCreated);
    }

    @Override
    public String createAccount(AccountRequest accountRequest) {
        String blogId = accountRequest.getBlogId();
        User user = new User();

        Account account = new Account();
        account.setType(accountRequest.getAccountType());

        user.setFirstName(accountRequest.getFirstName());
        user.setLastName(accountRequest.getLastName());
        user.getAccounts().add(account);
        Blog blog = blogRepository.findBlogById(blogId);
        blog.getAccounts().add(account);
        blogRepository.save(blog);
        return account.getUserId();
    }

    @Override
    public List<Blog> findAllBlogs() {

        return blogRepository.findAll();
    }
}
