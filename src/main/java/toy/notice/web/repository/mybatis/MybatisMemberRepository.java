package toy.notice.web.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import toy.notice.domain.member.Member;
import toy.notice.domain.member.MemberDto;
import toy.notice.web.mybatis.MemberMapper;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MybatisMemberRepository implements MemberRepository {
    private final MemberMapper memberMapper;

    @Override
    public Member save(Member member) {
        memberMapper.save(member);
        return findById(member.getId());
    }

    @Override
    public Member findById(Long id) {
        return memberMapper.findById(id);
    }

    @Override
    public List<Member> findAll() {
        return memberMapper.findAll();
    }

    @Override
    public void update(Long id, MemberDto memberDto) {
        memberMapper.update(id, memberDto);
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        return findAll().stream()
                .filter(m -> m.getEmail().equals(email))
                .findFirst();
    }
}
