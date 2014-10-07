package com.egencia.dynamic.springconfig;

import com.egencia.dynamic.springconfig.model.AmadeusAuthConfigItem;
import com.egencia.dynamic.springconfig.model.DefaultAuthenticationManager;
import com.egencia.dynamic.springconfig.model.KeyedSessionHandler;
import com.egencia.dynamic.springconfig.model.SessionManager;
import com.google.common.collect.ImmutableList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class SessionManagementConfiguration {

    private List<AmadeusAuthConfigItem> amadeusAuthConfigItems = ImmutableList.of(
            new AmadeusAuthConfigItem("officeId#1", "orgId#1", "originator#1", "pwd1", 4),
            new AmadeusAuthConfigItem("officeId#2", "orgId#2", "originator#2", "pwd1", 4),
            new AmadeusAuthConfigItem("officeId#3", "orgId#3", "originator#3", "pwd1", 4)
    );

    @Bean
    public KeyedSessionHandler keyedSessionHandler() {
        final KeyedSessionHandler handler = new KeyedSessionHandler();
        final Map<String, SessionManager> sessionManagers = new HashMap<>();

        for (AmadeusAuthConfigItem configItem : amadeusAuthConfigItems) {
            sessionManagers.put(configItem.getSourceOfficeID(), getSessionManager(configItem));
        }
        handler.setSessionManagers(sessionManagers);
        return handler;
    }

    public SessionManager getSessionManager(AmadeusAuthConfigItem configItem) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.setDefaultAuthenticationManager(getAuthenticationManager(configItem));
        return sessionManager;
    }

    private DefaultAuthenticationManager getAuthenticationManager(AmadeusAuthConfigItem configItem) {
        DefaultAuthenticationManager authenticationManager = new DefaultAuthenticationManager();
        authenticationManager.setAuthenticationDataProvider(configItem.getSourceOfficeID());
        return authenticationManager;
    }
}
