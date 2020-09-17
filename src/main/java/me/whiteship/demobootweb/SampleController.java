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

    // '/hello' 라는 요청 발생
    // preHandle -> 일반적인 서블릿 필터로 서블릿 요청이 처리되기 전에 뭔가를 하는 것과 비슷한데 조금 더 구체적으로 처리할 수 있음
    //              boolean preHandle(request, respoonse ,handler)
    //                      -> '핸들러'에 대한 정보도 제공이 되서, 서블릿 필터에 비해 보다 더 세밀한 로직을 구현 할 수 있음
    //                          리턴 타입이 boolean 이라서 다음 인터셉터 또는 핸들러로 요청, 응답을 전달할지(true) 끝낼지(false) 알린다.
    // 요청 처리
    // postHandle -> 뷰 랜더링하기 직전이라 modelAndView를 제공함, modelAndView 커스터마이징 가능
    //               void postHandle(request, response, modelAndView)
    //                      ->
    // 뷰 랜더링
    // afterCompletion -> 뷰 랜더링이 끝난 뒤에 호출
    //                    void afterCompletion(request, response, handler, ex)

    // vs 서블릿 필터
    //      -> 핸들러에 따라 특정 로직을 변경할 경우는 핸들러 인터셉터가 구현하는게 좋고
    //      -> 뭔가 전역적인, 스프링에 특화되어있는 정보와 관련이 없는 경우, 일반적인 경우로 기능을 구현하는 경우는 서블릿 필터가 올바르다

    /*
           postHandle과 afterCompletion은 역순으로 진행된다
           preHandle 1
           preHandle 2
           요청 처리
           postHandle 2
           postHandle 1
           뷰 랜더링
           afterCompletion 2
           afterCompletion 1
     */

    @GetMapping("/hello")
    public String hello(@RequestParam("id") Person person){
        return "hello "+ person.getName();
    }

}
