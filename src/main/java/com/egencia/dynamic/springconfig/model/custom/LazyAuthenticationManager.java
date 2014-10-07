package com.egencia.dynamic.springconfig.model.custom;

import com.egencia.dynamic.springconfig.model.DefaultAuthenticationManager;
import com.google.common.base.Preconditions;

import javax.annotation.PostConstruct;

public class LazyAuthenticationManager extends DefaultAuthenticationManager {

    @Override
    @PostConstruct
    public void afterPropertiesSet() {
    }
}
