package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@MainDiscountPolicy //커스텀 애노테이션
@Primary  //fix 와 Rate 둘다 컴포넌트 앤테이션을 설정해 놓으면, 프라이머리가 있는 객체가 우선적으로 의존관계 주입됨.
public class RateDiscountPolicy implements  DiscountPolicy {
    private int discountPercent = 10; //10% 할인
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent /  100;
        } else {
            return 0;
        }
    }
}
