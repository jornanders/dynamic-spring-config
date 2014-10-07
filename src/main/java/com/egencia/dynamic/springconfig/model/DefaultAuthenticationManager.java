package com.egencia.dynamic.springconfig.model;

import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class DefaultAuthenticationManager {

    private final static Logger logger = LoggerFactory.getLogger(DefaultAuthenticationManager.class);

    @Autowired
    private ProducerTemplate producerTemplate;

    private String authenticationDataProvider;

    public String getAuthenticationDataProvider() {
        return authenticationDataProvider;
    }

    public void setAuthenticationDataProvider(String authenticationDataProvider) {
        this.authenticationDataProvider = authenticationDataProvider;
    }

    @Override
    public String toString() {
        return "\nDefaultAuthenticationManager{" +
                "\n\tauthenticationDataProvider='" + authenticationDataProvider + '\'' +
                "\n\tproducerTemplate=" + producerTemplate +
                "\n}";
    }

    @PostConstruct
    public void afterPropertiesSet() {
        Preconditions.checkNotNull(authenticationDataProvider, "authenticationDataProvider can not be null");
        logger.debug(this.toString());
    }
}
