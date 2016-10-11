namespace java.swift org.exampledriven
namespace java org.exampledriven

enum BookType {
    BOOK = 0;
    NEWS_PAPER = 1;
    COMIC_BOOK = 2;
}

struct Book {
    1: string isbn,
    2: string title,
    3: string author,
    4: i32 page,
    5: list<string> keyword,
    6: BookType bookType
}

service BookService {
    list<Book> createBooks(1: list<Book> books)
}