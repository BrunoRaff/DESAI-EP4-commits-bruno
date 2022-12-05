package pe.isil.moduloseguridad.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.isil.moduloseguridad.applications.dto.ApplicationDto;
import pe.isil.moduloseguridad.auth.UserSecurity;
import pe.isil.moduloseguridad.auth.UserSecurityService;
import pe.isil.moduloseguridad.user.User;
import pe.isil.moduloseguridad.user.UserService;

@Controller
@RequestMapping("/application")
public class ApplicationController {

  @Autowired
  ApplicationService applicationService;
  @Autowired
  UserSecurityService userSecurityService;
  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("ListApps",applicationService.findAll());
    return "application/index";
  }

  @GetMapping("/create")
  public String create(Model model) {
    model.addAttribute("response", "");
    return "application/create";
  }
  @PostMapping("/create")
  public String addApplication(Application application, Model model) {
    ApplicationDto applicationDto = applicationService.addApplication(application);
    if (applicationDto.getStatus() == 400) {
      model.addAttribute("response", applicationDto.getMessage());
      return "application/create";
    }
    return "application/index";
  }
}
