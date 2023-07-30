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
    private LocalDate currentTime;

    public Post() {
    }

    public Post(String title, String content, String username, String image, LocalDate currentTime) {
        this.title = title;
        this.content = content;
        this.username = username;
        this.image = image;
        this.currentTime = currentTime;
    }
}
