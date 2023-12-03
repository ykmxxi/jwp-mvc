package org.example.mvc;

import java.util.HashMap;
import java.util.Map;

import org.example.mvc.controller.Controller;
import org.example.mvc.controller.ForwardController;
import org.example.mvc.controller.RequestMethod;
import org.example.mvc.controller.UserCreateController;
import org.example.mvc.controller.UserListController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestMappingHandlerMapping implements HandlerMapping {

    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    private Map<HandlerKey, Controller> mappings = new HashMap<>();

    void init() {
//        mappings.put(new HandlerKey("/", RequestMethod.GET), new HomeController());
        mappings.put(new HandlerKey("/user/form", RequestMethod.GET), new ForwardController("/user/form"));
        mappings.put(new HandlerKey("/users", RequestMethod.GET), new UserListController());
        mappings.put(new HandlerKey("/users", RequestMethod.POST), new UserCreateController());

        mappings.keySet().forEach(path ->
                logger.info("url path: [{}], controller: [{}]", path, mappings.get(path).getClass()));
    }

    @Override
    public Controller findHandler(HandlerKey handlerKey) {
        return mappings.get(handlerKey);
    }

}
