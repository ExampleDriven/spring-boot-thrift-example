package org.exampledriven;

import com.facebook.swift.service.ThriftMethod;
import com.facebook.swift.service.ThriftService;
import org.apache.thrift.TException;
import org.exampledriven.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ThriftService
public class BookServiceHandler {

    @ThriftMethod
    public List<Book> createBooks(List<Book> books) throws TException {
        books.forEach(book -> book.setISBN(BookUtil.generateISBN()));
        return books;
    }

}
