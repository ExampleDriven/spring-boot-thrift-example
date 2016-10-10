package org.exampledriven;

import com.facebook.nifty.processor.NiftyProcessorAdapters;
import com.facebook.swift.codec.ThriftCodecManager;
import com.facebook.swift.service.ThriftEventHandler;
import com.facebook.swift.service.ThriftServiceProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;
import java.util.Arrays;

@Configuration
public class ThriftServerConfig {

    @Bean
    public TProtocolFactory tProtocolFactory() {
        return new TBinaryProtocol.Factory();
    }

    @Bean
    ThriftCodecManager thriftCodecManager() {
        return new ThriftCodecManager();
    }

    @Bean
    public ServletRegistrationBean thriftBookServlet(ThriftCodecManager thriftCodecManager, TProtocolFactory protocolFactory, BookServiceHandler bookServiceHandler) {
        ThriftServiceProcessor processor = new ThriftServiceProcessor(thriftCodecManager, Arrays.asList(), bookServiceHandler);

        TServlet tServlet = new TServlet(
                NiftyProcessorAdapters.processorToTProcessor(processor),
                protocolFactory,
                protocolFactory
        );

        return new ServletRegistrationBean(tServlet, "/book");
    }
}
