package toy.notice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import toy.notice.domain.post.Post;
import toy.notice.service.NoticeService;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {
    private final NoticeService noticeService;
    @GetMapping("/")
    public String home(Model model){
        List<Post> posts = noticeService.allList();
        model.addAttribute("posts", posts);
        return "index";
    }
    @GetMapping("/index")
    public String index(Model model){
        List<Post> posts = noticeService.allList();
        model.addAttribute("posts", posts);
        return "index";
    }

}
