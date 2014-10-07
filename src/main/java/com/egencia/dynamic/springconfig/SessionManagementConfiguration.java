package com.egencia.dynamic.springconfig;

import com.egencia.dynamic.springconfig.model.DefaultAuthenticationManager;
import com.egencia.dynamic.springconfig.model.custom.LazyAuthenticationManager;
import com.egencia.dynamic.springconfig.model.custom.RefreshableKeyedSessionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SessionManagementConfiguration {

    private final static Logger logger = LoggerFactory.getLogger(SessionManagementConfiguration.class);

    @Bean
    public RefreshableKeyedSessionHandler keyedSessionHandler() {
        final RefreshableKeyedSessionHandler handler = new RefreshableKeyedSessionHandler();

        return handler;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public DefaultAuthenticationManager getAuthenticationManagerPrototype() {
        DefaultAuthenticationManager authenticationManager = new LazyAuthenticationManager();
        return authenticationManager;
    }
}
