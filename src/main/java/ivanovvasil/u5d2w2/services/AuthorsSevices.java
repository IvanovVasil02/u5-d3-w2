package ivanovvasil.u5d2w2.services;

import ivanovvasil.u5d2w2.entities.Author;
import ivanovvasil.u5d2w2.exceptions.NotFoundException;
import ivanovvasil.u5d2w2.repositories.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorsSevices {
  @Autowired
  private AuthorsRepository authorsRepository;

  public Author save(Author body) {
    body.setAvatar("http://ui-avatars.com/api/?name=" + body.getName() + "+" + body.getSurname());
    return authorsRepository.save(body);
  }

  public List<Author> findAll() {
    return authorsRepository.findAll();
  }

  public Author findById(int id) {
    return authorsRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
  }

  public void findByIdAndDelete(int id) {
    authorsRepository.delete(this.findById(id));
  }

  public Author findByIdAndUpdate(int id, Author body) {
    Author found = this.findById(id);
    found.setName(body.getName());
    found.setSurname(body.getSurname());
    found.setEmail(body.getEmail());
    found.setBirthDate(body.getBirthDate());
    return this.save(found);
  }
}
