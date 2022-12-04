package pe.isil.moduloseguridad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/modseg")
public class IndexController {
  @GetMapping("")
  public String index() {
    return "index";
  }
}
