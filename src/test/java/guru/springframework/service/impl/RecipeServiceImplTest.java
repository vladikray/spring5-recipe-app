package guru.springframework.service.impl;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.service.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

  RecipeServiceImpl recipeService;

  @Mock
  RecipeRepository recipeRepository;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    recipeService = new RecipeServiceImpl(recipeRepository);

  }

  @Test
  public void getAll() {
    Set<Recipe> recipies = new HashSet<Recipe>() {{
      add(new Recipe());
    }};

    when(recipeRepository.findAll()).thenReturn(recipies);
    assertEquals(recipeService.getAll().size(), 1);
    verify(recipeRepository, times(1)).findAll();
  }
}
