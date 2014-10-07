package com.egencia.dynamic.springconfig.model;

import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ComponentOne {

    private final static Logger logger = LoggerFactory.getLogger(ComponentOne.class);

    private final String name = "Comp1";

    @Autowired
    private ComponentTwo componentTwo;

    @Override
    public String toString() {
        return "ComponentOne{" +
                "name='" + name + '\'' +
                ", componentTwo=" + componentTwo +
                '}';
    }

    @PostConstruct
    public void afterPropertiesSet() {
        Preconditions.checkNotNull(componentTwo, "ComponentTwo can not be null");
        logger.debug(this.toString());
    }
}
