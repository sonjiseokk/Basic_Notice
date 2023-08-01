package toy.notice.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import toy.notice.domain.member.Member;
import toy.notice.domain.member.MemberDto;
import toy.notice.domain.service.MemberService;

import javax.validation.Valid;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("memberDto", new MemberDto());
        return "login";
    }
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute MemberDto dto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            log.info("로그인 과정중 bindingresult에 에러 발생");
            log.info("bindingResult.getAllErrors() = {}",bindingResult.getAllErrors());
            return "login";
        }
        Member loginMember = memberService.login(dto);
        if (loginMember == null) {
            log.info("해당 유저가 없음");
            redirectAttributes.addFlashAttribute("globalError", "해당되는 유저의 정보가 없습니다.");
            return "redirect:login";
        }
        log.info("로그인 성공!");
        redirectAttributes.addFlashAttribute("loginStatus", true);
        return "redirect:index";
    }

    @GetMapping("/register")
    public String registerPage(Model model){
        model.addAttribute("member", new Member());
        return "register";
    }

    // 에러 넣어야함
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute Member member, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        memberService.save(member);
        redirectAttributes.addFlashAttribute("registerStatus", true);
        return "redirect:index";
    }


}
