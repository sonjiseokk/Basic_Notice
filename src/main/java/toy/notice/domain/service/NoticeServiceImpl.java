package toy.notice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import toy.notice.domain.post.Post;
import toy.notice.domain.post.PostWriteForm;
import toy.notice.repository.PostRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {
    @Value("${file.dir}")
    private String fileDir;
    private final PostRepository postRepository;
    @Override
    public Post write(PostWriteForm form) throws IOException {
        Post post = postRepository.write(form);
        imagePath(form, post);
        log.info("post={}",post);
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
        return postRepository.allList();
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id);
    }


}
