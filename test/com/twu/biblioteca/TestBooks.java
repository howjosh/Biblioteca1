package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by richiethomas on 6/17/14.
 */
public class TestBooks {

  @Test
  public void testBookAttributes() {
    Book got = new Book("Game of Thrones", "George RR Martin", 2001);
    assertThat(got.getTitle(), is("Game of Thrones"));
    assertThat(got.getAuthor(), is("George RR Martin"));
  }
}
