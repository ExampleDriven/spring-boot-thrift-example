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
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootThriftExampleApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class BookApplicationTest {
    
    @Autowired
    protected TProtocolFactory protocolFactory;

    @Value("${local.server.port}")
    protected int port;
    
    protected BookService.Iface client;

    @Before
    public void setUp() throws Exception {
        TTransport transport = new THttpClient("http://localhost:" + port + "/book");
        
        TProtocol protocol = protocolFactory.getProtocol(transport);
        
        client = new BookService.Client(protocol);
    }

    @Test
    public void testAdd() throws Exception {
        Book book = new Book();

        List<Book> request = Arrays.asList(book, book);

        client.createBooks(request);
    }

}