package com.egencia.dynamic.springconfig.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

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

    @Override
    public String toString() {
        return "\nKeyedSessionHandler{" +
                "\nsessionManagers=\n" + StringUtils.collectionToDelimitedString(sessionManagers.entrySet(),
                "\n")  +
                '}';
    }

    @PostConstruct
    public void afterPropertiesSet() {
        Assert.notEmpty(sessionManagers, "Map of SessionManager(s) must not be null or empty.");
        logger.debug(this.toString());
    }
}
