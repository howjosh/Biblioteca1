package com.twu.biblioteca;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by richiethomas on 6/17/14.
 */
public class TestUserTypesBookList {

  @Test
  public void testUserTypesBookList() throws IOException {
    BufferedReader reader = mock(BufferedReader.class);
    when(reader.readLine()).thenReturn("list");
    String input = reader.readLine();


    
  }
}
