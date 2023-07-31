package toy.notice.web.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import toy.notice.domain.member.Member;
import toy.notice.domain.member.MemberDto;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class H2MemberRepository implements MemberRepository {
    private MemberMapper
    @Override
    public Member save(Member member) {
        return null;
    }

    @Override
    public Member findById(Long id) {
        return null;
    }

    @Override
    public List<Member> findAll() {
        return null;
    }

    @Override
    public void update(Long id, MemberDto memberDto) {

    }

    @Override
    public Optional<Member> findByEmail(String email) {
        return Optional.empty();
    }
}
