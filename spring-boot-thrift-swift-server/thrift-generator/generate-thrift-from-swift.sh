#!/usr/bin/env bash
java -cp "swift2thrift-generator-cli-0.23.0-standalone.jar;../target/classes" com.facebook.swift.generator.swift2thrift.Main org.exampledriven.Book org.exampledriven.BookService org.exampledriven.BookType -namespace java org.exampledriven -out book-generated.thrift
