package me.whiteship.demobootweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    // Spring MVC 일때
    /*@Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new PersonFomatter());
    }*/

}
