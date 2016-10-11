[![Build Status](https://travis-ci.org/ExampleDriven/spring-boot-thrift-example.svg?branch=master)](https://travis-ci.org/ExampleDriven/spring-boot-thrift-example)

#Spring boot thrift example

This example demonstrates the following

- Create a contract first thrift server from a thrift definition file
- Create a contract first thrift client from a thrift definition file
- Create a code firt thrift server using thrift swift annotations

# Important urls

- Client URL : http://localhost:8083/test_thrift 
- Client URL (for load testing) : http://localhost:8083/test_thrift?compact=true
- Thrift server endpoint : http://localhost:8082/book
- Thrift swift server endpoint : http://localhost:8084/book

# How to run the examples
1. Start up the desired backend implementation
1. Set the correct port in the client module's application.yml
1. Start up the client application and hit the URL specified above
