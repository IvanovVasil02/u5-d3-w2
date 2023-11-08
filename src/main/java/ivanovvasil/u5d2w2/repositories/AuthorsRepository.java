package ivanovvasil.u5d2w2.repositories;


import ivanovvasil.u5d2w2.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends JpaRepository<Author, Integer> {

}
