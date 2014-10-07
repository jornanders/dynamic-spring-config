package com.egencia.dynamic.springconfig.model;

import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

public class SessionManager {

    private final static Logger logger = LoggerFactory.getLogger(SessionManager.class);

    private DefaultAuthenticationManager defaultAuthenticationManager;

    public DefaultAuthenticationManager getDefaultAuthenticationManager() {
        return defaultAuthenticationManager;
    }

    public void setDefaultAuthenticationManager(DefaultAuthenticationManager defaultAuthenticationManager) {
        this.defaultAuthenticationManager = defaultAuthenticationManager;
    }

    @Override
    public String toString() {
        return "SessionManager{" +
                "defaultAuthenticationManager=" + defaultAuthenticationManager +
                '}';
    }

    @PostConstruct
    public void afterPropertiesSet() {
        Preconditions.checkNotNull(defaultAuthenticationManager, "defaultAuthenticationManager can not be null");
        logger.debug(this.toString());
    }
}
