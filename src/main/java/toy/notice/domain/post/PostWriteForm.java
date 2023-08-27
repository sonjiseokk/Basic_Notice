package toy.notice.domain.post;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class PostWriteForm {
    @NotBlank
    private String title;
    @NotBlank
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
