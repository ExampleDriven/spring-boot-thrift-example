package org.exampledriven;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceHandler implements BookService {

    @Override
    public List<Book> createBooks(List<Book> books) {

        List<Book> result = new ArrayList<>(books.size());

        books.forEach(book -> {
                Book bookWithISBN = new Book.Builder(book)
                    .setIsbn(BookUtil.generateISBN())
                    .build();
                result.add(bookWithISBN);
            }

        );

        return result;
    }

}
