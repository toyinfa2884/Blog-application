package semicolon.africa.blogApplication.data.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import semicolon.africa.blogApplication.data.models.Blog;

import static org.junit.jupiter.api.Assertions.*;

class BlogRepositoryImplTest {
    private BlogRepository blogRepository;

    @BeforeEach
    void setUp() {
        blogRepository = new BlogRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        Blog blog = new Blog("01");
        blog.setName("Linda Ikeji Blog");
        Blog savedBlog = blogRepository.save(blog);
        assertEquals(blog, savedBlog);
    }

    @Test
    void findBlogById() {
        Blog blog = new Blog("01");
        blog.setName("Linda Ikeji Blog");
        blogRepository.save(blog);
        //when
        Blog foundBlogById = blogRepository.findBlogById("01");
        assertEquals(blog, foundBlogById);

    }

    @Test
    void delete() {
        Blog blog = new Blog("01");
        blog.setName("Linda Ikeji Blog");
        blogRepository.save(blog);
        assertNotNull(blogRepository.findBlogById("01"));
        //when
        blogRepository.delete(blog);
        assertNull(blogRepository.findBlogById("01"));
    }

    @Test
    void testDelete() {
        Blog blog = new Blog("01");
        blog.setName("Linda Ikeji Blog");
        blogRepository.save(blog);
        assertNotNull(blogRepository.findBlogById("01"));
        //when
        blogRepository.delete("01");
        assertNull(blogRepository.findBlogById("01"));
    }

    @Test
    void findAll() {
        Blog blog = new Blog("01");
        blog.setName("Linda Ikeji Blog");

        blogRepository.save(blog);
        blogRepository.save(blog);
        blogRepository.save(blog);
        blogRepository.save(blog);
        blogRepository.save(blog);
        assertEquals(5, blogRepository.findAll().size());
    }

}