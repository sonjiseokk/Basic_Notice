package toy.notice.domain.service;

import toy.notice.domain.member.Member;
import toy.notice.domain.post.Post;
import toy.notice.domain.post.PostWriteForm;

import java.io.IOException;
import java.util.List;

public interface NoticeService {
    Post write(PostWriteForm form, Member member) throws IOException;
    List<Post> allList();
    Post findById(Long id);

}
