package guru.springframework.jdbc.repositories;

import guru.springframework.jdbc.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findBookByIsbn(String isbn);
    Optional<Book> findBookByTitle(String title);
}
