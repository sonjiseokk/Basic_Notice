package toy.notice.web.mybatis;

import org.apache.ibatis.annotations.Mapper;
import toy.notice.domain.post.Post;

import java.util.List;

@Mapper
public interface PostMapper {
    void savePost(Post post);
    List<Post> findAllPost();
    Post findByIdPost(Long id);
}
