package semicolon.africa.blogApplication.data.repositories;

import semicolon.africa.blogApplication.data.models.Blog;

import java.util.ArrayList;
import java.util.List;

public class BlogRepositoryImpl implements BlogRepository{
    List<Blog> blogs = new ArrayList<>();
    @Override
    public Blog save(Blog blog) {
        blogs.add(blog);
        return blog;
    }

    @Override
    public Blog findBlogById(String blogId) {
        for(Blog blog : blogs){
            if(blog.getBlogId().equalsIgnoreCase(blogId));
            return blog;
        }
        return null;
    }

    @Override
    public void delete(Blog blog) {
        blogs.remove(blog);

    }

    @Override
    public void delete(String blogId) {
        Blog blog = findBlogById(blogId);
        delete(blog);

    }

    @Override
    public List<Blog> findAll() {
        return blogs;
    }
}
