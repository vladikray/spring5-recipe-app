package guru.springframework.controller;

import guru.springframework.domain.Recipe;
import guru.springframework.service.impl.RecipeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


public class IndexControllerTest {


  IndexController indexController;

  @Mock
  RecipeServiceImpl recipeService;

  @Mock
  Model model;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    indexController = new IndexController(recipeService);
  }

  @Test
  public void testMockMvc() throws Exception {
    MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

    mockMvc.perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(view().name("index"));
  }

  @Test
  public void getAll() {
    // given
    Set<Recipe> recipies = new HashSet<Recipe>() {{
      add(new Recipe());
    }};

    ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

    //then
   when(recipeService.getAll()).thenReturn(recipies);
   String result = indexController.get(model);
   assertEquals(result, "index");
   verify(recipeService, times(1)).getAll();
   verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
   Set<Recipe> recipes = argumentCaptor.getValue();
   assertEquals(1, recipes.size());
  }
}
