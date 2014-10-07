package com.egencia.dynamic.springconfig.model.custom;

import com.egencia.dynamic.springconfig.model.AmadeusAuthConfigItem;
import com.egencia.dynamic.springconfig.model.DefaultAuthenticationManager;
import com.egencia.dynamic.springconfig.model.GQSConfig;
import com.egencia.dynamic.springconfig.model.KeyedSessionHandler;
import com.egencia.dynamic.springconfig.model.SessionManager;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RefreshableKeyedSessionHandler extends KeyedSessionHandler {

    @Autowired
    private GQSConfig gqsConfig;

    @Autowired
    private ApplicationContext applicationContext;

    private final static Logger logger = LoggerFactory.getLogger(KeyedSessionHandler.class);

    @Override
    @PostConstruct
    public void afterPropertiesSet() {
        rebuildSessionManagers();
    }

    public void rebuildSessionManagers() {
        rebuildAndSetSessionManagers(gqsConfig.getAmadeusAuthConfigItems());
    }

    private void rebuildAndSetSessionManagers(List<AmadeusAuthConfigItem> configItems) {
        setSessionManagers(loadSessionManagers(configItems));
    }

    private Map<String, SessionManager> loadSessionManagers(List<AmadeusAuthConfigItem> configItems) {
        final Map<String, SessionManager> sessionManagers = new HashMap<>();

        for (AmadeusAuthConfigItem configItem : configItems) {
            sessionManagers.put(configItem.getSourceOfficeID(), getSessionManager(configItem));
        }
        return sessionManagers;
    }

    public SessionManager getSessionManager(AmadeusAuthConfigItem configItem) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.setDefaultAuthenticationManager(getAuthenticationManager(configItem));
        return sessionManager;
    }

    public DefaultAuthenticationManager getAuthenticationManager(AmadeusAuthConfigItem configItem) {
        DefaultAuthenticationManager authenticationManager = getLazyAuthenticationManager();
        authenticationManager.setAuthenticationDataProvider(configItem.getSourceOfficeID());
        return authenticationManager;
    }

    private DefaultAuthenticationManager getLazyAuthenticationManager() {
        Map<String, DefaultAuthenticationManager> beansOfType = applicationContext.getBeansOfType(DefaultAuthenticationManager.class);
        Preconditions.checkNotNull(beansOfType);
        Preconditions.checkState(beansOfType.size() == 1);
        return beansOfType.values().iterator().next();
    }
}
