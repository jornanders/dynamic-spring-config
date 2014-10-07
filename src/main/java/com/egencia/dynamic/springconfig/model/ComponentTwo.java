package com.egencia.dynamic.springconfig.model;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwo {
    private final String name = "Comp2";

    @Override
    public String toString() {
        return "ComponentTwo{" +
                "name='" + name + '\'' +
                '}';
    }
}
