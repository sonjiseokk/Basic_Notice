package toy.notice.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import toy.notice.domain.member.Member;
import toy.notice.domain.member.MemberDto;
import toy.notice.domain.post.Post;
import toy.notice.domain.post.PostWriteForm;
import toy.notice.domain.service.NoticeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;

@Controller
@Slf4j
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

    @GetMapping("/write")
    public String writePage(Model model,HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "redirect:/login";
        }
        Member loginMember = (Member)session.getAttribute("loginMember");
        // 쿠키가 오래된걸수도있음
        if (loginMember == null) {
            return "redirect:/login";
        }
        model.addAttribute("postWriteForm", new PostWriteForm());
        return "write";
    }

    @PostMapping("/write")
    public String write(
            @Valid @ModelAttribute PostWriteForm form, BindingResult bindingResult,
            Model model, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        Member loginMember = (Member)session.getAttribute("loginMember");
        if (bindingResult.hasErrors()) {
            log.info("postform error = {}",bindingResult);
            model.addAttribute("postWriteForm", form);
            return "write";
        }
        noticeService.write(form,loginMember);
        return "redirect:/";
    }

    @GetMapping("/detail/{postId}")
    public String detailPage(@PathVariable Long postId,Model model){
        Post post = noticeService.findById(postId);
        model.addAttribute("post", post);
        return "detail";
    }
}
