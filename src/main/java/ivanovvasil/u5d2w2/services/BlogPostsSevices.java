package ivanovvasil.u5d2w2.services;

import ivanovvasil.u5d2w2.entities.BlogPost;
import ivanovvasil.u5d2w2.exceptions.NotFoundException;
import ivanovvasil.u5d2w2.repositories.BlogPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostsSevices {
  @Autowired
  private BlogPostsRepository blogPostsRepository;

  public BlogPost save(BlogPost body) {
    return blogPostsRepository.save(body);
  }

  public List<BlogPost> findAll() {
    return blogPostsRepository.findAll();
  }

  public BlogPost findById(int id) {
    return blogPostsRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
  }

  public void findByIdAndDelete(int id) {
    blogPostsRepository.delete(this.findById(id));
  }

  public BlogPost findByIdAndUpdate(int id, BlogPost body) {
    BlogPost found = this.findById(id);
    found.setCategoria(body.getCategoria());
    found.setTitolo(body.getTitolo());
    return blogPostsRepository.save(found);
  }
}
