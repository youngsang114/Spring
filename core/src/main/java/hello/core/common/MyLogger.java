package hello.core.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }
    public void log(String message){
        System.out.println("["+uuid+"]"+ "["+requestURL+"] " + message);
    }
    @PostConstruct
    public void init(){
        uuid = UUID.randomUUID().toString(); //uuid가 이미 선언된 변수인 것으로 가정 String uuid가 아님
        System.out.println("["+uuid+"] request scope been create: " + this);
    }
    @PreDestroy
    public void close(){
        System.out.println("["+uuid+"] request scope been close: " + this);
    }

}
