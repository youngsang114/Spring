package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void beforEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }
    @Test
    void createOrder(){
        //given
        Long memberId =1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);
        //when
        Order item = orderService.createOrder(memberId, "itemA", 10000);
        //then
        assertThat(item.getDiscountPrice()).isEqualTo(1000);

    }
}
