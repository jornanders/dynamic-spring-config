package com.egencia.dynamic.springconfig;

import com.egencia.dynamic.springconfig.model.ComponentOne;
import com.egencia.dynamic.springconfig.model.ComponentThree;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfig {
    @Bean
    public ComponentThree componentThree() {
        ComponentThree componentThree = new ComponentThree();
        componentThree.setComponentOne(new ComponentOne());
        return componentThree;
    }
}
