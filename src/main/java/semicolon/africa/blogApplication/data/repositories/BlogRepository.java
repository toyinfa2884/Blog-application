package semicolon.africa.blogApplication.data.repositories;

import semicolon.africa.blogApplication.data.models.Blog;

import java.util.List;

public interface BlogRepository {
    Blog save(Blog blog);
    Blog findBlogById(String blogId);
    void delete(Blog blog);
    void delete(String blogId);
    List<Blog> findAll();
}
