package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username={}, age={}", username, age);

        response.getWriter().write("ok");
    }

    @ResponseBody // ok이라는 반환값을 가지고 view를 찾는게 아니라 http응답 메시지 body에 넣어서 반환
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge) {
        log.info("username={}, age={}", memberName, memberAge);
        return "ok";
    }

    @ResponseBody // ok이라는 반환값을 가지고 view를 찾는게 아니라 http응답 메시지 body에 넣어서 반환
    @RequestMapping("/request-param-v3")
    // 스프링 부트 3.2부터 파라미터이 인식 이름 문제가 발생하고 java.lang.IllegalArgumentException: Name for argument of type [java.lang.String] not specified오류가 난다
    // 가장 권장하는 방법은 @RequestParam에서 파라미터명을 생략하지 않는 것이다
    // 이 오류는 주로 @RequestParam, @PathVariable에서 주로 발생한다고 한다
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }
    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age){
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(name = "username",required = true) String username,
            @RequestParam(name = "age",required = false) Integer age){

        // null, "" 는 다른거인거 인지하기!
        // 원시형 자료 age,float,byte등등에는 null들어가지 못함 ->Integer,이렇게 wrapper클래스로 바꿔줘야한다
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(name = "username",required = true, defaultValue = "guest") String username,
            @RequestParam(name = "age",required = false, defaultValue = "-1") int age){

        // null, "" 는 다른거인거 인지하기!
        // 원시형 자료 age,float,byte등등에는 null들어가지 못함 ->Integer,이렇게 wrapper클래스로 바꿔줘야한다
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap)
           {
        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData){
        log.info("username={}, age={}", helloData.getUsername(),helloData.getAge());
        log.info("hellomodel={}",helloData);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData){
        log.info("username={}, age={}", helloData.getUsername(),helloData.getAge());
        log.info("hellomodel={}",helloData);
        return "ok";
    }
}
