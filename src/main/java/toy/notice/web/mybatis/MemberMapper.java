package toy.notice.web.mybatis;

import org.apache.ibatis.annotations.Mapper;
import toy.notice.domain.member.Member;
import toy.notice.domain.member.MemberDto;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {
    void save(Member member);
    Member findById(Long id);
    List<Member> findAll();
    void update(Long id, MemberDto memberDto);

}
