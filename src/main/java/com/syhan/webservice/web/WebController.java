package com.syhan.webservice.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {
    /*
    생성한 메인 페이지(main.hbs)를 URL 요청으로 호출 시, 필요한 controller
    */
    /*
    @GetMapping("/")은 이전의 @RequestMeapping(value="/", method = RequestMethod.GET) 과 동일함
    */
    @GetMapping("/")
    public String main(){
        return "main";
        /*
        본 controller에서 문자열을 반환할 때, handlebars-spring-boot-starter 덕분에,
        앞의 path("/")와 뒤의 파일 확장자(.hbs)는 자동으로 지정됨.
        (prefix: src/main/resources/templates, suffix: .hbs)
        즉 여기서는 "main"이라는 문자열을 반환하니, src/main/resources/templates.main.hbs로 전환함.
        이를 View Resolver가 처리함.
        View Resolver는 URL 요청의 결과를 전달할 타입과 값을 지정하는 관리자 역할을 함.
        */

    }
}
