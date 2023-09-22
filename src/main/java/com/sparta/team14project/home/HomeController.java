package com.sparta.team14project.home;

import com.sparta.team14project.user.entity.UserRoleEnum;
import com.sparta.team14project.user.login.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/user/login-page")
    public String loginPage() {
        return "login"; // 로그인 페이지의 뷰 이름 (templates 디렉토리 아래의 HTML 파일 이름)
    }

    @GetMapping("/user/signup")
    public String signupPage() {
        return "signup"; // 로그인 페이지의 뷰 이름 (templates 디렉토리 아래의 HTML 파일 이름)
    }

    @GetMapping("/user/store/cud") // 상점 수정 및 삭제
    public String CUDStore() {
        return "store/storeCUD";
    }

    @GetMapping("/user/store") // 상점 수정 및 삭제
    public String getStore() {
        return "store/allStoreInfo";
    }

    @GetMapping("/user/menu/cud") // 상점 수정 및 삭제
    public String CUDMenu() {
        return "menu/menuCUD";
    }

    @GetMapping("/store/menu") // 메뉴 상세 정보 조회
    public String showMenuDetail() {
        return "menu/menuDetail";
    }

    @GetMapping("/user-info")
    @ResponseBody
    public UserInfoDto getUserInfo(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        String username = userDetails.getUser().getUsername();
        UserRoleEnum role = userDetails.getUser().getUserRole();
        boolean isOwner = (role == UserRoleEnum.OWNER);

        return new UserInfoDto(username, isOwner);
    }


}