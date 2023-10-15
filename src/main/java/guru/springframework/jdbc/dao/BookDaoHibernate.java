package guru.springframework.jdbc.dao;

import guru.springframework.jdbc.domain.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import org.springframework.data.domain.Pageable;


import java.util.List;

public class BookDaoHibernate implements BookDao {

    private final EntityManagerFactory emf;

    public BookDaoHibernate(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Book findByIsbn(String isbn) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.isbn = :isbn", Book.class);
            query.setParameter("isbn", isbn);

            Book book = query.getSingleResult();
            return book;
        } finally {
            em.close();
        }
    }

    @Override
    public Book getById(Long id) {
        EntityManager em = getEntityManager();
        try {
            Book book =   em.find(Book.class, id);
            return book;
        } finally {
            em.close();
        }
    }

    @Override
    public Book findBookByTitle(String title) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createNativeQuery("SELECT * FROM book WHERE title = :title", Book.class);
            query.setParameter("title", title);
            return (Book) query.getSingleResult();
        } finally {
            em.close();
        }
    }

    @Override
    public Book saveNewBook(Book book) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(book);
            em.flush(); // forces Hibernate to write to the database
            em.getTransaction().commit();
            return book;
        } finally {
            em.close();
        }
    }

    @Override
    public Book updateBook(Book book) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(book);
            em.flush();
            em.clear();
            Book updatedBook = em.find(Book.class, book.getId());
            em.getTransaction().commit();
            return updatedBook;
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteBookById(Long id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Book book = em.find(Book.class, id);
        em.remove(book);
        em.flush();
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Book> findAllBooks() {
        return null;
    }

    @Override
    public List<Book> findAllBooks(int pageSize, int offset) {
        return null;
    }

    @Override
    public List<Book> findAllBooks(Pageable pageable) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Book> query = em.createQuery("SELECT b from Book b", Book.class);
            query.setFirstResult(Math.toIntExact(pageable.getOffset()));
            query.setMaxResults(pageable.getPageSize());
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Book> findAllBooksSortByTitle(Pageable pageable) {
        return null;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

}
