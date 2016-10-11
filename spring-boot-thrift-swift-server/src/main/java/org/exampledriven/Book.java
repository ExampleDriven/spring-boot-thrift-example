package org.exampledriven;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.codec.ThriftField.Recursiveness;
import java.util.*;

import static com.google.common.base.MoreObjects.toStringHelper;

@ThriftStruct("Book")
public final class Book
{
    @ThriftConstructor
    public Book(
        @ThriftField(value=1, name="isbn", requiredness=Requiredness.NONE) final String isbn,
        @ThriftField(value=2, name="title", requiredness=Requiredness.NONE) final String title,
        @ThriftField(value=3, name="author", requiredness=Requiredness.NONE) final String author,
        @ThriftField(value=4, name="page", requiredness=Requiredness.NONE) final int page,
        @ThriftField(value=5, name="keyword", requiredness=Requiredness.NONE) final List<String> keyword,
        @ThriftField(value=6, name="bookType", requiredness=Requiredness.NONE) final BookType bookType
    ) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.page = page;
        this.keyword = keyword;
        this.bookType = bookType;
    }

    public static class Builder {
        private String isbn;

        public Builder setIsbn(String isbn) {
            this.isbn = isbn;
            return this;
        }
        private String title;

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }
        private String author;

        public Builder setAuthor(String author) {
            this.author = author;
            return this;
        }
        private int page;

        public Builder setPage(int page) {
            this.page = page;
            return this;
        }
        private List<String> keyword;

        public Builder setKeyword(List<String> keyword) {
            this.keyword = keyword;
            return this;
        }
        private BookType bookType;

        public Builder setBookType(BookType bookType) {
            this.bookType = bookType;
            return this;
        }

        public Builder() { }
        public Builder(Book other) {
            this.isbn = other.isbn;
            this.title = other.title;
            this.author = other.author;
            this.page = other.page;
            this.keyword = other.keyword;
            this.bookType = other.bookType;
        }

        public Book build() {
            return new Book (
                this.isbn,
                this.title,
                this.author,
                this.page,
                this.keyword,
                this.bookType
            );
        }
    }

    private final String isbn;

    @ThriftField(value=1, name="isbn", requiredness=Requiredness.NONE)
    public String getIsbn() { return isbn; }

    private final String title;

    @ThriftField(value=2, name="title", requiredness=Requiredness.NONE)
    public String getTitle() { return title; }

    private final String author;

    @ThriftField(value=3, name="author", requiredness=Requiredness.NONE)
    public String getAuthor() { return author; }

    private final int page;

    @ThriftField(value=4, name="page", requiredness=Requiredness.NONE)
    public int getPage() { return page; }

    private final List<String> keyword;

    @ThriftField(value=5, name="keyword", requiredness=Requiredness.NONE)
    public List<String> getKeyword() { return keyword; }

    private final BookType bookType;

    @ThriftField(value=6, name="bookType", requiredness=Requiredness.NONE)
    public BookType getBookType() { return bookType; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("isbn", isbn)
            .add("title", title)
            .add("author", author)
            .add("page", page)
            .add("keyword", keyword)
            .add("bookType", bookType)
            .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Book other = (Book)o;

        return
            Objects.equals(isbn, other.isbn) &&
            Objects.equals(title, other.title) &&
            Objects.equals(author, other.author) &&
            Objects.equals(page, other.page) &&
            Objects.equals(keyword, other.keyword) &&
            Objects.equals(bookType, other.bookType);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(new Object[] {
            isbn,
            title,
            author,
            page,
            keyword,
            bookType
        });
    }
}
