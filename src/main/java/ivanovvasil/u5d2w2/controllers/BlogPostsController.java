package ivanovvasil.u5d2w2.controllers;

import ivanovvasil.u5d2w2.entities.BlogPost;
import ivanovvasil.u5d2w2.services.BlogPostsSevices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostsController {
  @Autowired
  private BlogPostsSevices blogPostsSevices;

  @GetMapping("")
  public List<BlogPost> getAll() {
    return blogPostsSevices.findAll();
  }

  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED) // <-- 201
  public BlogPost saveBlogPost(@RequestBody BlogPost body) {
    body.setCover("https://picsum.photos/200/300");
    return blogPostsSevices.save(body);
  }

  @GetMapping("/{id}")
  public BlogPost findById(@PathVariable int id) {
    return blogPostsSevices.findById(id);
  }

  @PutMapping("/{id}")
  public BlogPost findByIdAndUpdate(@PathVariable int id, @RequestBody BlogPost body) {
    return blogPostsSevices.findByIdAndUpdate(id, body);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void findByIdAndDelete(@PathVariable int id) {
    blogPostsSevices.findByIdAndDelete(id);
  }
}
