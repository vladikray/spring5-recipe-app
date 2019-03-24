package guru.springframework.controller;

import guru.springframework.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
public class IndexController {

  private final RecipeService recipeService;


  @RequestMapping
  String get(Model model) {
    model.addAttribute("recipes", recipeService.getAll());
    return  "index";
  }

}
