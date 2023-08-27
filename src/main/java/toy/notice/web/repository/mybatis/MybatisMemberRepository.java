package toy.notice.web.repository.mybatis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import toy.notice.domain.member.Member;
import toy.notice.domain.member.MemberDto;
import toy.notice.web.mybatis.MemberMapper;
import toy.notice.web.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
@RequiredArgsConstructor
public class MybatisMemberRepository implements MemberRepository {
    private final MemberMapper memberMapper;

    @Override
    public Member save(Member member) {
        memberMapper.saveMember(member);
        return findById(member.getId());
    }

    @Override
    public Member findById(Long id) {
        return memberMapper.findByIdMember(id);
    }

    @Override
    public List<Member> findAll() {
        return memberMapper.findAllMember();
    }

    @Override
    public void update(Long id, Member member) {
        memberMapper.updateMember(id, member);
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        return findAll().stream()
                .filter(m -> m.getEmail().equals(email))
                .findFirst();
    }
}
