package guru.springframework.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {

  Category category;

  @Before
  public void setUp() {
    category = new Category();
  }

  @Test
  public void getId() {
    Long categoryId = 4L;
    category.setId(categoryId);
    assertEquals(category.getId(), categoryId);

  }

  @Test
  public void getDescription() {
    String description = "some text";
    category.setDescription(description);
    assertEquals(category.getDescription(), description);
  }


  @After
  public void tearDown() {
    category = null;
  }
}
