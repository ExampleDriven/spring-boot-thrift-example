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
       @Value("${thrift.server.host:localhost}")
       String host,
       @Value("${thrift.server.port:8084}")
       int port) throws TTransportException
    {
        super(tProtocolFactory.getProtocol(new THttpClient("http://" + host + ":" + port + "/book")));
    }

}
