package com.example.demo.Configuration;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


 /* Created by saniya on 28/5/17.
 */
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/inventory").setViewName("inventory");
        registry.addViewController("/purchase").setViewName("purchase");
        registry.addViewController("/production").setViewName("production");
        registry.addViewController("/login1").setViewName("login1");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}
