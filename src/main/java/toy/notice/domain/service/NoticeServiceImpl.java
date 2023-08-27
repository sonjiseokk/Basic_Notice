package toy.notice.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import toy.notice.domain.member.Member;
import toy.notice.domain.post.Post;
import toy.notice.domain.post.PostWriteForm;
import toy.notice.web.repository.PostRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {
    private final PostRepository postRepository;
    @Override
    public Post write(PostWriteForm form, Member member) throws IOException {
        Post write = postRepository.write(form,member);
        return write;
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
