package com.shf.spring.kube.producer.endpoint;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author songhaifeng
 */
@RequestMapping(value = "/call")
public interface HelloEndpoint {

    @GetMapping(value = "/{name}", produces = MediaType.TEXT_HTML_VALUE)
    String hello(@PathVariable String name);
}
