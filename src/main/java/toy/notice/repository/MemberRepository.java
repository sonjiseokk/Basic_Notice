package toy.notice.repository;

import toy.notice.domain.member.Member;
import toy.notice.domain.member.MemberDto;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Member findById(Long id);
    List<Member> findAll();
    void update(Long id, MemberDto memberDto);

    Optional<Member> login(MemberDto dto);
}
