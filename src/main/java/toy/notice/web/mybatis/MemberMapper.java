package toy.notice.web.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import toy.notice.domain.member.Member;
import toy.notice.domain.member.MemberDto;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {
    void saveMember(Member member);
    Member findByIdMember(Long id);
    List<Member> findAllMember();
    void updateMember(@Param("id") Long id, @Param("updateParam") Member updateParam);


}
