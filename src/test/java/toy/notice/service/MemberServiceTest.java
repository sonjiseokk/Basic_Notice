package toy.notice.service;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import toy.notice.domain.member.Member;
import toy.notice.domain.member.MemberDto;
import toy.notice.domain.service.MemberService;
import toy.notice.web.repository.MemberRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
@Slf4j
class MemberServiceTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    void save(){
        Member member = new Member("abc@gmail.com", "aa", "123");
        Member savedMember = memberService.save(member);

        assertThat(member.getEmail()).isEqualTo(savedMember.getEmail());
        assertThat(member.getUsername()).isEqualTo(savedMember.getUsername());
        assertThat(member.getPassword()).isEqualTo(savedMember.getPassword());
    }
    @Test
    void findById(){
        Member member = new Member("abc@gmail.com", "aa", "123");
        Member savedMember = memberService.save(member);
        log.info("저장된 멤버의 아이디={}",savedMember.getId());
        Member findMember = memberService.findById(savedMember.getId());

        assertThat(savedMember.getEmail()).isEqualTo(findMember.getEmail());
        assertThat(savedMember.getUsername()).isEqualTo(findMember.getUsername());
        assertThat(savedMember.getPassword()).isEqualTo(findMember.getPassword());
    }

    @Test
    void findAll(){
        Member member1 = new Member("abc@gmail.com", "aa", "123");
        Member member2 = new Member("abc1@gmail.com", "aa1", "1231");
        memberService.save(member1);
        memberService.save(member2);

        List<Member> res = memberService.findAll();
        assertThat(res.size()).isEqualTo(2);
    }

    @Test
    void login() {
        Member member = new Member("abc@gmail.com", "aa", "123");
        memberService.save(member);
        // 유저가 로그인을 시도했다고 가정
        Member canLogin = new Member("abc@gmail.com", "123");
        Member cantLogin = new Member("abc@gmail.com", "1234");

        assertThat(memberService.login(canLogin)).isNotNull();
        assertThat(memberService.login(cantLogin)).isNull();
    }

    @Test
    void update() {
        Member member = new Member("abc@gmail.com", "aa", "123");
        Member savedMember = memberService.save(member);

        MemberDto userInputFormData = new MemberDto( "aa","abc@gmail.com", "1234");

        Member modifyMember = new Member(userInputFormData.getEmail(), userInputFormData.getUsername(), userInputFormData.getPassword());
        memberService.update(savedMember.getId(), modifyMember);

        Member updatedMember = memberService.findById(savedMember.getId());
        assertThat(updatedMember.getPassword()).isEqualTo(userInputFormData.getPassword());

    }
}