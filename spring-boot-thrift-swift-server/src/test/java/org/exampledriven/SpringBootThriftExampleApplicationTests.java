package org.exampledriven;

import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransport;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringBootThriftExampleApplication.class)
public class SpringBootThriftExampleApplicationTests {
/*
    @Autowired
    protected TProtocolFactory protocolFactory;

    @Value("${local.server.port}")
    protected int port;

    protected BookService.Client bookClient;

    @Before
    public void setUp() throws Exception {
        TTransport transport = new THttpClient("http://localhost:" + port + "/book");

        TProtocol protocol = protocolFactory.getProtocol(transport);

        bookClient = new BookService.Client(protocol);
    }

    @Test
    public void testAdd() throws Exception {
        Book book = new Book();

        List<Book> request = Arrays.asList(book, book);

        bookClient.createBooks(request);
    }
    */
}
