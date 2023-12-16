package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();
        // 자기 자신을 싱글톤형식이라고 선언을 한다
    public static SingletonService getInstance(){ // 조회하는 인스턴스(당연히 static이어야 한다)
        return instance;
    }
    private SingletonService(){} // 생성자를 private으로 만들어서 외부에서 객체 생성을 막는다.

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
