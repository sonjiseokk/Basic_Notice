package toy.notice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import toy.notice.domain.post.Post;
import toy.notice.domain.post.PostWriteForm;
import toy.notice.repository.PostRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {
    private final PostRepository postRepository;
    @Override
    public Post write(PostWriteForm form) {
        return postRepository.write(form);
    }

    @Override
    public List<Post> allList() {
        return postRepository.allList();
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id);
    }
}
