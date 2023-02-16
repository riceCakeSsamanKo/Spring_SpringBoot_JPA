package jpabook.jpashop.controller;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new")  //GetMapping: 화면 열기
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());  //컨트롤러에서 뷰로 넘어갈 때 MemberForm을 실어서 넘김
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")  //@PostMapping: PostMapping: 데이터 등록
    public String create(@Valid MemberForm form, BindingResult result) {  //@Valid: 다양한 어노테이션 사용하게함(?)

        if (result.hasErrors()) { //만일 에러가 존재하면
            return "members/createForm";  //해당 폼으로 다시 보내줌
        }
        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());

        Member member = new Member();
        member.setName(form.getName());
        member.setAddress(address);

        memberService.join(member);

        return "redirect:/";  //홈 화면
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members); //model에 members를 담아서 화면에 넘김
        return "members/memberList";
    }
}
