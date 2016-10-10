package org.exampledriven.thrift;

import org.exampledriven.Book;
import org.exampledriven.BookType;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class TestDataUtil {

    private static List<Book> thriftBookList = new LinkedList<>();

    static {

        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setAuthor(randomString());
            book.setBookType(BookType.COMIC_BOOK);

            for (int j = 0; j < 3; j++) {
                book.addToKeyword(randomString());
            }

            book.setPage((int)(Math.random() * 100));
            book.setTitle(randomString());

            thriftBookList.add(book);

        }

    }

    private static String randomString() {
        return UUID.randomUUID().toString();
    }

    public static List<Book> getGrpcTestData() {
        return thriftBookList;
    }

}
