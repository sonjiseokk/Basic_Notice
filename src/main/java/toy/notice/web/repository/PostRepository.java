package toy.notice.web.repository;

import toy.notice.domain.post.Post;
import toy.notice.domain.post.PostWriteForm;

import java.util.List;

public interface PostRepository {
    Post write(PostWriteForm form);
    List<Post> allList();

    Post findById(Long id);
}
