package org.example.mvc.controller;

import java.util.HashMap;
import java.util.Map;

public class RequestMappingHandlerMapping {

    private Map<String, Controller> mappings = new HashMap<>();

    public void init() {
        mappings.put("/", new HomeController());
    }

    public Controller findHandler(final String urlPath) {
        return mappings.get(urlPath);
    }

}
