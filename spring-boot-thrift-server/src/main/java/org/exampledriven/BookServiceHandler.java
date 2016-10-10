package org.exampledriven;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceHandler implements BookService.Iface{

    @Override
    public List<Book> createBooks(List<Book> books) throws TException {
        books.forEach(book -> book.setIsbn(BookUtil.generateISBN()));
        return books;
    }

}
