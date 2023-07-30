package toy.notice.domain;

import lombok.Data;

@Data
public class Member {
    private Long id;
    private String email;
    private String username;
    private String password;

    public Member() {
    }

    public Member(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
