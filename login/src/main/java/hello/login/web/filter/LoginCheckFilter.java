package hello.login.web.filter;

import hello.login.web.SessionConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@Slf4j
public class LoginCheckFilter implements Filter {

    private final String[] whitelist ={"/", "/members/add", "/login","/logout","/css/*"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        HttpServletResponse httpResponse = (HttpServletResponse) response;

        try{
            log.info("인증 체크 필터 시작{}",requestURI);

            if (isLoginCheckPath(requestURI)){
                log.info("인증 체크 로직 실행{}", requestURI);
                HttpSession session = httpRequest.getSession(false);
                if (session==null || session.getAttribute(SessionConst.LOGIN_NUMBER)==null){
                    log.info("미인증 사용자 요청 {}", requestURI);
                    // 로그인으로 redirect
                    httpResponse.sendRedirect("/login?redirectURL="+requestURI);
                    // 현재 페이지의  URI를 포함해서, 로그인이성공하면 다시 이 페이지로 리다이렉트를 해준다
                    return;
                }
            }

            chain.doFilter(request,response);
        } catch (Exception e){
            throw e;
        } finally {
            log.info("인증 체크 필터 종료{}",requestURI);
        }
    }

    /**
     * 화이트 리스트의 경우 인증 체크 X
     */
    private boolean isLoginCheckPath(String requestURI){
        return !PatternMatchUtils.simpleMatch(whitelist, requestURI);
        // 하이트리스트에 안드는거 false
    }

}
