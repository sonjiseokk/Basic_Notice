package toy.notice.domain.member;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class MemberDto {
    private String username;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;

    public MemberDto() {
    }

    public MemberDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
