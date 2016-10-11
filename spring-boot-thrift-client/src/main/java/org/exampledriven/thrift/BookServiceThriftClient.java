package org.exampledriven.thrift;

import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransportException;
import org.exampledriven.BookService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BookServiceThriftClient extends BookService.Client {

    public BookServiceThriftClient(TProtocolFactory tProtocolFactory,
       @Value("${book.server.host}")
       String host,
       @Value("${book.server.port}")
       int port) throws TTransportException
    {
        super(tProtocolFactory.getProtocol(new THttpClient("http://" + host + ":" + port + "/book")));
    }

}
