package pe.isil.moduloseguridad.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("")
  public String index(Model model) {
    model.addAttribute("listUsers", userService.findAll());
    return "user/index";
  }

  @GetMapping("/register")
  public String register() {
    return "user/register";
  }

  @GetMapping("/update")
  public String update(@RequestParam("id") Long id, Model model) {
    model.addAttribute("userToUpdate", userService.findUserById(id));
    return "user/update";
  }

  @GetMapping("/create")
  public String create() {
    return "user/register";
  }

  @PostMapping("/register")
  public String registerUser(User user, Model model) {

    UserDto userDto = userService.addUser(user);

    if (userDto.getCode().equals("200")) {
      return "redirect:/user";
    }
    model.addAttribute("response", userDto.getMessage());
    return "ValidationResponse";
  }

  @PostMapping("/update")
  public String updateUser(User user, Model model) {
    UserDto userDto = userService.updateUser(user, user.getId());

    if (userDto.getCode().equals("200")) {
      return "redirect:/user";
    } else {
      model.addAttribute("response", userDto.getMessage());
      return "ValidationResponse";
    }
  }

  @DeleteMapping("/delete")
  public String deleteUser(@RequestParam("id") Long id) {
    userService.deleteUser(id);
    return "redirect:/user";
  }

}
