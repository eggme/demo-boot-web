package me.whiteship.demobootweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    // ex)  localhost:8080/hello/seungjun
        /*
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") Person person){
        return "hello "+ person;
    }
         */
    // result -> hello Person{name='seungjun'}

    // ex) localhost:8080/hello?name=seungjun

    @GetMapping("/hello")
    public String hello(@RequestParam("name") Person person){
        return "hello "+ person;
    }

}
