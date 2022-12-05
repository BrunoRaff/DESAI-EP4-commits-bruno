package pe.isil.moduloseguridad.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.isil.moduloseguridad.user.UserDto;

@Controller
@RequestMapping("/")
public class UserSecurityController {
  @Autowired
  private UserSecurityService userSecurityService;

  @GetMapping({"/", "/login"})
  public String index() {
    return "login";
  }

  @GetMapping("/recover")
  public String recover() {
    return "forgot";
  }

  @GetMapping("/adduserauth")
  public String register() {
    return "register";
  }

  @PostMapping("/adduserauth")
  public String addUser(@ModelAttribute(name="authuser") UserSecurity userSecurity, Model model) {
    UserDto userDto = userSecurityService.addUserSecurity(userSecurity);
    if (userDto.getCode().equals("200")) {
      model.addAttribute("response", "Welcome ".concat(userSecurity.getName()));
      return "redirect:/login";
    }
    model.addAttribute("response", userDto.getMessage());
    return "ValidationResponseAuth";
  }

  @PostMapping("/login")
  public String login(@ModelAttribute(name="authuser") UserSecurity userSecurity, Model model, RedirectAttributes redirectAttributes) {
    UserSecurity user = userSecurityService.findUserSecurity(userSecurity.getEmail(), userSecurity.getPassword());

    if (user == null) {
      model.addAttribute("response", "Invalid Credentials");
      return "ValidationResponseAuth";
    } else {
      return "redirect:/modseg/menu";
    }
  }

  @PostMapping("/recover")
  public String recover(@ModelAttribute(name = "authuser") UserSecurity userSecurity, Model model) {
    UserSecurity user = userSecurityService.findUserByEmail(userSecurity.getEmail());

    if (user == null) {
      model.addAttribute("response", "Invalid Credentials");
      return "ValidationResponseAuth";
    } else {
      UserSecurity savedUser = userSecurityService.changePassword(user, userSecurity.getPassword());
      //model.addAttribute("response", "Password changed for ".concat(savedUser.getName()));
      return "redirect:/login";
    }
  }

}
