package toy.notice.service;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.transaction.annotation.Transactional;
import toy.notice.domain.post.Post;
import toy.notice.domain.post.PostWriteForm;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@Transactional
class NoticeServiceTest {
    @Autowired
    NoticeService noticeService;

    @Test
    void writeAndSave() throws IOException {
        PostWriteForm userInput = new PostWriteForm("안녕하세요", "안녕하세요!!컨텐츠입니다", null);
        Post post = noticeService.write(userInput);

        assertThat(post.getContent()).isEqualTo(userInput.getContent());
    }

    @Test
    void allSavedPosts() throws IOException {
        PostWriteForm userInput1 = new PostWriteForm("안녕하세요1", "안녕하세요!!컨텐츠입니다1", null);
        PostWriteForm userInput2 = new PostWriteForm("안녕하세요2", "안녕하세요!!컨텐츠입니다2", null);
        PostWriteForm userInput3 = new PostWriteForm("안녕하세요3", "안녕하세요!!컨텐츠입니다3", null);
        noticeService.write(userInput1);
        noticeService.write(userInput2);
        noticeService.write(userInput3);

        List<Post> posts = noticeService.allList();
        assertThat(posts.size()).isEqualTo(3);
    }

    @Test
    void saveImage() throws IOException {
        MockMultipartFile multipartFile = new MockMultipartFile(
                "image", // form data name
                "test.jpg", // filename
                "image/jpeg", // content type
                "Image Content".getBytes() // file content
        );

        PostWriteForm userInput = new PostWriteForm("안녕하세요1", "안녕하세요!!컨텐츠입니다1", multipartFile);
        String realImageSrc = "/images/test.jpg";

        Post post = noticeService.write(userInput);
        String src = "/images/" + post.getImage();
        assertThat(src).isEqualTo(realImageSrc);
    }

}