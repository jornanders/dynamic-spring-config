package com.egencia.dynamic.springconfig.model;

import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

public class ComponentThree {

    private final static Logger logger = LoggerFactory.getLogger(ComponentOne.class);

    private ComponentOne componentOne;

    public ComponentOne getComponentOne() {
        return componentOne;
    }

    public void setComponentOne(ComponentOne componentOne) {
        this.componentOne = componentOne;
    }

    @Override
    public String toString() {
        return "ComponentThree{" +
                "componentOne=" + componentOne +
                '}';
    }

    @PostConstruct
    public void afterPropertiesSet() {
        Preconditions.checkNotNull(componentOne, "ComponentOne can not be null");
        logger.debug(this.toString());
    }
}
