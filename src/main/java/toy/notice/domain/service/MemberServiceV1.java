package toy.notice.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import toy.notice.domain.member.Member;
import toy.notice.domain.member.MemberDto;
import toy.notice.web.repository.MemberRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberServiceV1 implements MemberService{
    private final MemberRepository memberRepository;
    @Override
    public Member save(Member member) {
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
    public Member update(Long id, Member member) {
        memberRepository.update(id, member);
        return memberRepository.findById(id);
    }

    @Override
    public Member login(Member member) {
        return memberRepository.findByEmail(member.getEmail())
                .filter(m -> m.getPassword().equals(member.getPassword()))
                .orElse(null);
    }
}
