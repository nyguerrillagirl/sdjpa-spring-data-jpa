package guru.springframework.jdbc.dao;

import guru.springframework.jdbc.domain.Author;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("local")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan(basePackages = {"guru.springframework.jdbc.dao"})
public class AuthorDaoJDBCTemplateTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    AuthorDao authorDao;

    @BeforeEach
    void setUp() {
        authorDao = new AuthorDaoJDBCTemplate(jdbcTemplate);
    }

    @Test
    void findAllAuthorsByLastName_sortByFirstName() {
        String lastName = "Smith";
        List<Author> authors = authorDao
                .findAllAuthorsByLastName(PageRequest.of(0,10, Sort.by(Sort.Order.asc("first_name"))), lastName);

        assertThat(authors).isNotNull();
        assertThat(authors.size()).isEqualTo(10);
        for (Author anAuthor: authors) {
            System.out.println(anAuthor.toString());
        }
    }

}
