package org.bitbucket.almirjr.categoriesservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class CategoriesController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private CategoryClient categoryClient;

    @GetMapping("server-port")
    public String getServerPort() {
        return serverPort;
    }

    @GetMapping("category")
    public Category getCategory() {
        return categoryClient.findCategoryById(2);
    }

}
