package org.bitbucket.almirjr.categoriesservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "categories", url = "http://www.mocky.io/v2/5b0961d53500008100126297")
public interface CategoryClient {

    @GetMapping
    Category findCategoryById(int id);

}
