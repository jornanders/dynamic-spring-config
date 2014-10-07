package com.egencia.dynamic.springconfig.model;

import org.springframework.stereotype.Component;

@Component
public class ProducerTemplate {
    private final String name = "ProducerTemplate";

    @Override
    public String toString() {
        return "ProducerTemplate{" +
                "name='" + name + '\'' +
                '}';
    }
}
