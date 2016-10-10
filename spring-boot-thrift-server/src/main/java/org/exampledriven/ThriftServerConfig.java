package org.exampledriven;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;

@Configuration
public class ThriftServerConfig {

    @Bean
    public TProtocolFactory tProtocolFactory() {
        return new TBinaryProtocol.Factory();
    }

    @Bean
    public ServletRegistrationBean thriftBookServlet(TProtocolFactory protocolFactory, BookServiceHandler handler) {
        TServlet tServlet = new TServlet(new BookService.Processor<>(handler), protocolFactory);

        return new ServletRegistrationBean(tServlet, "/book");
    }
}
