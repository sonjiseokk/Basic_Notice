package toy.notice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import toy.notice.domain.member.Member;
import toy.notice.domain.member.MemberDto;
import toy.notice.service.MemberService;

import javax.validation.Valid;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute MemberDto dto, Model model){
        boolean loginCheck = memberService.login(dto);
        if (loginCheck) {
            log.info("로그인 성공!");
            model.addAttribute("loginStatus", true);
        }
        else {
            log.info("로그인 실패!");
            // 로그인 체크
        }
        return "index";
    }

    @GetMapping("/register")
    public String registerPage(){
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute Member member, Model model) {
        memberService.save(member);
        log.info("member={}",member);
        model.addAttribute("registerStatus", true);
        model.addAttribute("member", member);
        return "index";
    }


}
