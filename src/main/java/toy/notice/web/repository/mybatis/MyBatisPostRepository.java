package toy.notice.web.repository.mybatis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import toy.notice.domain.member.Member;
import toy.notice.domain.post.Post;
import toy.notice.domain.post.PostWriteForm;
import toy.notice.web.mybatis.PostMapper;
import toy.notice.web.repository.PostRepository;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class MyBatisPostRepository implements PostRepository {
    @Value("${file.dir}")
    private String fileDir;
    private final PostMapper mapper;
    @Override
    public Post write(PostWriteForm form, Member member) throws IOException {
        Post post = new Post(form.getTitle(), form.getContent(), member.getUsername(), null, LocalDate.now());
        if (form.getImage().isEmpty()) {
            post.setImage("img.jpg");
        }
        else {
            imagePath(form, post);
        }
        log.info("post={}",post);
        mapper.savePost(post);
        return post;
    }
    private void imagePath(PostWriteForm form, Post post) throws IOException {
        if (!form.getImage().isEmpty()) {
            String fileName = form.getImage().getOriginalFilename();
            String fullPath = fileDir + fileName;
            form.getImage().transferTo(new File(fullPath));

            post.setImage(fileName); // save only the file name, not the full path
        }
    }

    @Override
    public List<Post> allList() {
        List<Post> allPost = mapper.findAllPost();
        return allPost;
    }

    @Override
    public Post findById(Long id) {
        return mapper.findByIdPost(id);
    }
}
