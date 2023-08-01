package toy.notice.domain.post;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Date;

@Data
public class Post {
    private Long id;
    private String title;
    private String content;
    private String username;
    private String image;
    private LocalDate postdate;

    public Post() {
    }

    public Post(String title, String content, String username, String image, LocalDate postdate) {
        this.title = title;
        this.content = content;
        this.username = username;
        this.image = image;
        this.postdate = postdate;
    }
}
