package com.egencia.dynamic.springconfig.model;

import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 *
 */
public class KeyedSessionHandler {
    private final static Logger logger = LoggerFactory.getLogger(KeyedSessionHandler.class);
    private Map<String, SessionManager> sessionManagers;

    public void setSessionManagers(Map<String, SessionManager> sessionManagers) {
        this.sessionManagers = sessionManagers;
    }

    public Map<String, SessionManager> getSessionManagers() {
        return sessionManagers;
    }

    @Override
    public String toString() {
        return "KeyedSessionHandler{" +
                "sessionManagers=" + sessionManagers +
                '}';
    }

    @PostConstruct
    public void afterPropertiesSet() {
        logger.debug(this.toString());
    }

}
