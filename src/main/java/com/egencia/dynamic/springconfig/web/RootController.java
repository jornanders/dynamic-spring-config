package com.egencia.dynamic.springconfig.web;

import com.egencia.dynamic.springconfig.model.GQSConfig;
import com.egencia.dynamic.springconfig.model.custom.RefreshableKeyedSessionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @Autowired
    private RefreshableKeyedSessionHandler keyedSessionHandler;

    @Autowired
    private GQSConfig gqsConfig;

    @RequestMapping("/status")
    public String getKeyedSessionHandler() {
        return keyedSessionHandler.toString();
    }

    @RequestMapping("/reload")
    public String reloadAmadeusConfig() {
        gqsConfig.reloadAmadeusAuthConfigItems();
        keyedSessionHandler.rebuildSessionManagers();
        return "RELOADED";
    }
}
