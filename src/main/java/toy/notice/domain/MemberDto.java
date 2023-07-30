package toy.notice.domain;

import lombok.Data;

@Data
public class MemberDto {
    private String username;
    private String email;

    public MemberDto() {
    }

    public MemberDto(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
