package toy.notice.web.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import toy.notice.domain.post.Post;
import toy.notice.domain.post.PostWriteForm;
import toy.notice.web.mybatis.PostMapper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@Repository
@Slf4j
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {
    @Value("${file.dir}")
    private String fileDir;
    private PostMapper mapper;
    @Override
    public Post write(PostWriteForm form) throws IOException {
        Post post = new Post(form.getTitle(), form.getContent(), "userA", form.getImage().getOriginalFilename(), LocalDate.now());
        if (form.getImage() != null) {
            imagePath(form, post);
        }
        log.info("post={}",post);
        mapper.save(post);
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
        return mapper.findAll();
    }

    @Override
    public Post findById(Long id) {
        return mapper.findById(id);
    }
}
