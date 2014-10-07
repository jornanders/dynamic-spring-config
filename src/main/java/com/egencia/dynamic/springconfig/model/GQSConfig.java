package com.egencia.dynamic.springconfig.model;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.json.UTF8StreamJsonParser;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.google.common.io.ByteStreams;
import com.google.common.io.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Component("gqsConfig")
public class GQSConfig {

    private final static Logger logger = LoggerFactory.getLogger(GQSConfig.class);

    private List<AmadeusAuthConfigItem> amadeusAuthConfigItems = ImmutableList.of();

    public List<AmadeusAuthConfigItem> getAmadeusAuthConfigItems() {
        return getAmadeusAuthConfigItems(false);
    }

    public List<AmadeusAuthConfigItem> reloadAmadeusAuthConfigItems() {
        return getAmadeusAuthConfigItems(true);
    }

    private List<AmadeusAuthConfigItem> getAmadeusAuthConfigItems(boolean reload) {
        if (reload) {
            logger.debug("reloading config items");
            amadeusAuthConfigItems = readAmadeusAuthConfig();
        }
        return amadeusAuthConfigItems;
    }

    private List<AmadeusAuthConfigItem> readAmadeusAuthConfig() {
        try {
            final ClassPathResource classPathResource = new ClassPathResource("AmadeusAuthConfig.json");
            byte[] jsonData = Resources.toByteArray(classPathResource.getURL());
            //byte[] jsonData = Files.readAllBytes( Paths.get("AmadeusAuthConfig.json"));
            ObjectMapper objectMapper = new ObjectMapper();
            final AmadeusAuthConfigItem[] configItems = objectMapper.readValue(new JsonFactory().createParser
                    (jsonData), AmadeusAuthConfigItem[].class);
            return Arrays.asList(configItems);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
