package toy.notice.domain.service;

import toy.notice.domain.member.Member;
import toy.notice.domain.member.MemberDto;

import java.util.List;

public interface MemberService {
    Member save(Member member);
    Member findById(Long id);
    List<Member> findAll();
    Member update(Long id, Member member);
    Member login(Member dto);

}
