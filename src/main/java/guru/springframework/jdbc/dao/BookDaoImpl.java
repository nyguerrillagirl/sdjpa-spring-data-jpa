package guru.springframework.jdbc.dao;

import guru.springframework.jdbc.domain.Book;
import guru.springframework.jdbc.repositories.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component
public class BookDaoImpl implements BookDao {

    private final BookRepository bookRepository;

    public BookDaoImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book findByIsbn(String isbn) {
        return bookRepository.findBookByIsbn(isbn);
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.getReferenceById(id);
    }

    @Override
    public Book findBookByTitle(String title) {
        return bookRepository
                    .findBookByTitle(title)
                    .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Book saveNewBook(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    @Override
    public Book updateBook(Book book) {
        Book fetchedBook = bookRepository.getReferenceById(book.getId());
        // update
        fetchedBook.setIsbn(book.getIsbn());
        fetchedBook.setTitle(book.getTitle());
        fetchedBook.setPublisher(book.getPublisher());
        fetchedBook.setAuthorId(book.getAuthorId());

        return bookRepository.save(fetchedBook);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }


}
