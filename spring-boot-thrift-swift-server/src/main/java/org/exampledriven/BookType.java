package org.exampledriven;

import com.facebook.swift.codec.*;

public enum BookType
{
    BOOK(0), NEWS_PAPER(1), COMIC_BOOK(2);

    private final int value;

    BookType(int value)
    {
        this.value = value;
    }

    @ThriftEnumValue
    public int getValue()
    {
        return value;
    }
}
