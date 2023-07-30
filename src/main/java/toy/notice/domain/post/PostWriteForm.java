package toy.notice.domain.post;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PostWriteForm {
    private String title;
    private String content;
    private MultipartFile image;

    public PostWriteForm() {
    }

    public PostWriteForm(String title, String content, MultipartFile image) {
        this.title = title;
        this.content = content;
        this.image = image;
    }
}
