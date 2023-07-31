package toy.notice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import toy.notice.domain.post.Post;
import toy.notice.domain.post.PostWriteForm;
import toy.notice.service.MemberService;
import toy.notice.service.NoticeService;

import java.io.File;
import java.io.IOException;

@Controller
@Slf4j
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

    @GetMapping("/write")
    public String writePage(){
        return "write";
    }

    @PostMapping("/write")
    public String write(@ModelAttribute PostWriteForm form,Model model) throws IOException {
        noticeService.write(form);
        return "redirect:/index";
    }

    @GetMapping("/detail/{postId}")
    public String detailPage(@PathVariable Long postId,Model model){
        Post post = noticeService.findById(postId);
        model.addAttribute("post", post);
        return "detail";
    }
}
