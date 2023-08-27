package toy.notice.web.repository.memory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import toy.notice.domain.member.Member;
import toy.notice.domain.member.MemberDto;
import toy.notice.web.repository.MemberRepository;

import java.util.*;

//@Repository
@Slf4j
public class MemoryMemberRepository implements MemberRepository {
    private final Map<Long, Member> repository = new HashMap<>();
    private Long sequence = 0L;
    @Override
    public Member save(Member member) {
        Long memberId = ++sequence;
        member.setId(memberId);
        log.info("MemberRepository 저장 시작");
        repository.put(memberId, member);
        log.info("MemberRepository 저장 성공");
        log.info("저장된 member 정보");
        log.info("member.getId()={}", member.getId());
        log.info("member.getUsername()={}", member.getUsername());
        log.info("member.getPassword()={}", member.getPassword());
        return repository.get(memberId);
    }

    @Override
    public Member findById(Long id) {
        return repository.get(id);
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(repository.values());
    }

    @Override
    public void update(Long id,Member member) {
        Member findMember = findById(id);
        findMember.setEmail(member.getEmail());
        findMember.setUsername(member.getUsername());
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        return findAll().stream()
                .filter(m -> m.getEmail().equals(email))
                .findFirst();
    }


}
