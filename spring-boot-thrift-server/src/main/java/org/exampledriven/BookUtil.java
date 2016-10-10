package org.exampledriven;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;


public class BookUtil {

    public static String generateISBN() {
        return UUID.randomUUID().toString().replaceAll("/", "").substring(0,12);
    }
}
