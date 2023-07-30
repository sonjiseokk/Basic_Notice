package toy.notice.domain.member;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Member {
    @NotNull
    private Long id;
    @NotBlank
    private String email;
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    public Member() {
    }

    public Member(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
