package toy.notice.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import toy.notice.domain.member.Member;
import toy.notice.domain.post.Post;
import toy.notice.domain.post.PostWriteForm;

import java.time.LocalDate;
import java.util.*;

@Repository
@Slf4j
public class PostRepositoryImpl implements PostRepository {
    private final Map<Long, Post> repository = new HashMap<>();
    private Long sequence = 0L;
    @Override
    public Post write(PostWriteForm form) {
        Post post = new Post(form.getTitle(), form.getContent(), "userA", null, LocalDate.now());
        post.setId(++sequence);
        repository.put(sequence, post);
        return post;
    }

    @Override
    public List<Post> allList() {
        return new ArrayList<>(repository.values());
    }

    @Override
    public Post findById(Long id) {
        return repository.get(id);
    }
}
