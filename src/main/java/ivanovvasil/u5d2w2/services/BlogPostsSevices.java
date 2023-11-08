package ivanovvasil.u5d2w2.services;

import ivanovvasil.u5d2w2.entities.BlogPost;
import ivanovvasil.u5d2w2.exceptions.NotFoundException;
import ivanovvasil.u5d2w2.repositories.BlogPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

  public Page<BlogPost> findAll(int page, int size, String orderBy) {
    Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));

    return blogPostsRepository.findAll(pageable);
  }

  public BlogPost findById(int id) throws NotFoundException {
    return blogPostsRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
  }

  public void findByIdAndDelete(int id) throws NotFoundException {
    blogPostsRepository.delete(this.findById(id));
  }

  public BlogPost findByIdAndUpdate(int id, BlogPost body) throws NotFoundException {
    BlogPost found = this.findById(id);
    found.setCategoria(body.getCategoria());
    found.setTitolo(body.getTitolo());
    return blogPostsRepository.save(found);
  }
}
