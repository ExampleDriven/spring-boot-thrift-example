package org.exampledriven.thrift;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.thrift.TException;
import org.exampledriven.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookThriftController {

    @Autowired
    BookServiceThriftClient bookServiceThriftClient;

    @Autowired
    ObjectMapper objectMapper;

    @RequestMapping(value = "/test_thrift", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> test(@RequestParam(value = "compact", required = false, defaultValue = "false") boolean compact) throws TException, JsonProcessingException {

        List<Book> books = bookServiceThriftClient.createBooks(TestDataUtil.getGrpcTestData());

        if (compact) {
            return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        } else {

            String jsonString = objectMapper.writeValueAsString(books);

            return new ResponseEntity<>(jsonString, HttpStatus.OK);
        }
    }
}
