package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by richiethomas on 6/17/14.
 */
public class TestBooks {

  Book got;

  @Before
  public void setUp() {
    got = new Book("Game of Thrones", "George RR Martin", 2001);
  }

  @Test
  public void testBookGetTitle() {
    assertThat(got.getTitle(), is("Game of Thrones"));
  }

  @Test
  public void testBookHasAuthor() {
    assertThat(got.getAuthor(), is("George RR Martin"));
  }

  @Test
  public void testBookGetYear() {
    assertThat(got.getYear(), is(2001));
  }

}
