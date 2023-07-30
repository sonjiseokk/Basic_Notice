package toy.notice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import toy.notice.domain.member.Member;
import toy.notice.domain.member.MemberDto;
import toy.notice.repository.MemberRepository;
import toy.notice.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberServiceV1 implements MemberService{
    private final MemberRepository memberRepository;
    @Override
    public Member save(Member member) {
        log.info("memberService 저장");
        return memberRepository.save(member);
    }

    @Override
    public Member findById(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public void update(Long id, MemberDto memberDto) {
        memberRepository.update(id, memberDto);
    }

    @Override
    public boolean login(MemberDto dto) {
        Optional<Member> loginMember = memberRepository.login(dto);
        return loginMember.isPresent();

    }
}
