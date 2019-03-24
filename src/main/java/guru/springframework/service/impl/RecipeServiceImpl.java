package guru.springframework.service.impl;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

 final RecipeRepository recipeRepository;

  public RecipeServiceImpl(RecipeRepository recipeRepository) {
    this.recipeRepository = recipeRepository;
  }

  @Override
  public Set<Recipe> getAll() {
    Set<Recipe> recipeSet = new HashSet<>();
    log.debug("getting all recipe");
    recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
    return recipeSet;
  }
}
