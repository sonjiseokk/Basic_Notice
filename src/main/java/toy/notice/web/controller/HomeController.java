package toy.notice.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import toy.notice.domain.member.Member;
import toy.notice.domain.post.Post;
import toy.notice.domain.service.MemberService;
import toy.notice.domain.service.NoticeService;
import toy.notice.web.repository.MemberRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {
    private final NoticeService noticeService;
    private final MemberService memberService;

    @GetMapping("/")
    public String index(Model model, HttpServletRequest request) {
        List<Post> posts = noticeService.allList();
        model.addAttribute("posts", posts);

        HttpSession session = request.getSession(false);
        if (session == null) {
            return "index";
        }

        Member loginMember = (Member)session.getAttribute("loginMember");
        // 쿠키가 오래된걸수도있음
        if (loginMember == null) {
            return "index";
        }

        model.addAttribute("member", loginMember);
        return "loginHome";
    }

}
