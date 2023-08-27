package toy.notice.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.transaction.annotation.Transactional;
import toy.notice.domain.member.Member;
import toy.notice.domain.post.Post;
import toy.notice.domain.post.PostWriteForm;
import toy.notice.domain.service.NoticeService;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Slf4j
@SpringBootTest
@Transactional
class NoticeServiceTest {
    @Autowired
    NoticeService noticeService;

    MockMultipartFile multipartFile = new MockMultipartFile(
            "image", // form data name
            "test.jpg", // filename
            "image/jpeg", // content type
            "Image Content".getBytes() // file content
    );

    @Test
    void writeAndSave() throws IOException {
        PostWriteForm userInput = new PostWriteForm("안녕하세요", "싱글 컨텐츠입니다", multipartFile);
        Member member = new Member("test@gmail.com", "나는테스트유저", "qqq");
        Post post = noticeService.write(userInput,member);

        assertThat(post.getContent()).isEqualTo(userInput.getContent());
        assertThat(post.getUsername()).isEqualTo(member.getUsername());
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
        Member member = new Member("test@gmail.com", "나는테스트유저", "qqq");

        Post post = noticeService.write(userInput,member);
        String src = "/images/" + post.getImage();
        assertThat(src).isEqualTo(realImageSrc);
    }

}