package org.example.loginapp.user;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;
    private final HttpSession session; // IOC 등록되어 있음 (스프링 실행 되면)

    // http://localhos:8080/oauth/callback?code=3faw1
    @GetMapping("/oauth/callback")
    public String oauthCallback(String code) {
        System.out.println("code: " + code);
        User sessionUser = userService.카카오로그인(code);
        session.setAttribute("sessionUser", sessionUser);
        return "redirect:/shop";
    }

    @GetMapping("/join-form")
    public String joinForm() {
        return "join-form";
    }

    @GetMapping("/login-form")
    public String loginForm() {
        return "login-form";
    }

    @PostMapping("join")
    public String join(String username, String password, String email) {
        userService.회원가입(username, password, email);
        return "redirect:/login-form";
    }

    @PostMapping("login")
    public String login(String username, String password) {
        User sessionUser = userService.로그인(username, password);
        session.setAttribute("sessionUser", sessionUser); // 로그인 되면 세션에 저장
        return "redirect:/shop";
    }
}
