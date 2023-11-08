package ivanovvasil.u5d2w2.controllers;

import ivanovvasil.u5d2w2.entities.Author;
import ivanovvasil.u5d2w2.services.AuthorsSevices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {
  @Autowired
  private AuthorsSevices authorSevice;

  @GetMapping("")
  public List<Author> getAll() {
    return authorSevice.findAll();
  }

  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  public Author saveAuthor(@RequestBody Author body) {
    body.setAvatar("https://ui-avatars.com/api/?name=" + body.getName() + "+" + body.getSurname());
    return authorSevice.save(body);
  }

  @GetMapping("/{id}")
  public Author findById(@PathVariable int id) {
    return authorSevice.findById(id);
  }

  @PutMapping("/{id}")
  public Author findByIdAndUpdate(@PathVariable int id, @RequestBody Author body) {
    return authorSevice.findByIdAndUpdate(id, body);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void findByIdAndDelete(@PathVariable int id) {
    authorSevice.findByIdAndDelete(id);
  }
}
