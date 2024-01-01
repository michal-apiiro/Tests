import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PostFilter;

import java.util.List;

public interface IBookService {

    @PreAuthorize("hasRole('ROLE_READ')")
    @PostFilter("filterObject.owner == principal.username")
    List<Book> getBooks();

    @PreAuthorize("hasRole('ROLE_WRITE')")
    @PreFilter("filterObject.owner == principal.username")
    void addBook(List<Book> books);

}
