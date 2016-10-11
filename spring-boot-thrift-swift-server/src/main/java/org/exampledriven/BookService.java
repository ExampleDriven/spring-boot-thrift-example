package org.exampledriven;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.service.*;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.*;
import java.util.*;

@ThriftService("BookService")
public interface BookService
{
    @ThriftService("BookService")
    public interface Async
    {
        @ThriftMethod(value = "createBooks")
        ListenableFuture<List<Book>> createBooks(
                @ThriftField(value = 1, name = "books", requiredness = Requiredness.NONE) final List<Book> books
        );
    }
    @ThriftMethod(value = "createBooks")
    List<Book> createBooks(
            @ThriftField(value = 1, name = "books", requiredness = Requiredness.NONE) final List<Book> books
    );

}