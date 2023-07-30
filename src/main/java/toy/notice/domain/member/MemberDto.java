package toy.notice.domain.member;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class MemberDto {
    @NotNull
    private String username;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;

    public MemberDto() {
    }

    public MemberDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
