package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy sut = new RateDiscountPolicy();;

    @Test
    @DisplayName("10% 할인이 되어야 한다.")
    void vip_o() {
        // given
        Member member = new Member(1L, "chan", Grade.VIP);

        // when
        int actual = sut.discount(member, 10000);

        // then

        Assertions.assertThat(actual).isEqualTo(1000);
    }

    // 실패 테스트도 항상 작성해주어야 한다.

    @Test
    @DisplayName("10% 할인이 적용되지 않아야 한다.")
    void basic_o() {
        // given
        Member member = new Member(1L, "chan", Grade.BASIC);

        // when
        int actual = sut.discount(member, 10000);

        // then
        Assertions.assertThat(actual).isEqualTo(0);
    }

}