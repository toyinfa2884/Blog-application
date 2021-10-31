package semicolon.africa.blogApplication.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import semicolon.africa.blogApplication.data.models.AccountType;
import semicolon.africa.blogApplication.data.repositories.UserRepositoryImpl;
import semicolon.africa.blogApplication.dtos.request.AccountRequest;

import static org.junit.jupiter.api.Assertions.*;

class BlogServiceImplTest {
    BlogService blogService;
    UserRepositoryImpl userRepository;

    @BeforeEach
    void setUp() {
        blogService = new BlogServiceImpl();
    }

    @AfterEach
    void tearDown() {
        blogService = null;
        userRepository = null;
    }

    @Test
    void createBlog() {
        String lindaIkejiBlog = blogService.createBlog("Linda Ikeji Blog");
        assertEquals("01", lindaIkejiBlog);
    }
    @Test
    void createTwoBlogs(){
        String lindaIkejiBlog = blogService.createBlog("Linda Ikeji Blog");
        String ogbondeBlog = blogService.createBlog("Ogbonge Blog");
        assertEquals("01", lindaIkejiBlog);
        assertEquals("02", ogbondeBlog);
    }
    @Test
    void createTwoBlogs_RepositoryShouldHaveTwoBlogs(){
        String lindaIkejiBlog = blogService.createBlog("Linda Ikeji Blog");
        String ogbondeBlog = blogService.createBlog("Ogbonge Blog");
        assertEquals("01", lindaIkejiBlog);
        assertEquals("02", ogbondeBlog);

        assertEquals(2, blogService.findAllBlogs().size());
        System.out.println(blogService.findAllBlogs());

    }

    @Test
    void createAccountForUserTest() {
        String ogbongeBlog = blogService.createAccount();
        //when
        AccountRequest johnForm = new AccountRequest();
        johnForm.setFirstName("John");
        johnForm.setLastName("Doe");
        johnForm.setBlogId("01");
        johnForm.setAccountType(AccountType.USER);
        String blogId = blogService.createAccount(johnForm);
        assertEquals("01", blogId);

    }

    @Test
    void findAllBlogs() {
    }
}