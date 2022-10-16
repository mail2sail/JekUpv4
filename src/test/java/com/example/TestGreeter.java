package com.example;

import org.junit.Before;
import org.junit.Test;
//import org.mockito.internal.matchers.GreaterThan;
//import org.mockito.internal.matchers.LessThan;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class TestGreeter {

  private Greeter greeter;
  
  //This is the before method
  @Before
  public void setup() {
    greeter = new Greeter();
  }
  
  //This is the first test
  @Test
  public void greetShouldIncludeTheOneBeingGreeted() {
    String someone = "World";

    assertThat(greeter.greet(someone), containsString(someone));
  }
  
  //This is the second test
  @Test
  public void greetShouldIncludeGreetingPhrase() {
    String someone = "World";

    assertThat(greeter.greet(someone).length(), is(greaterThan(someone.length())));
  }
  
  //This is the third test
  @Test
  public void greetShouldIncludeGreetingMessage() {
    String someone = "World, Thanks you making me Happy";

    assertThat(greeter.greet(someone).length(), is(greaterThan(someone.length())));
  }
  
  //This is the fourth test
  @Test
  public void greetShouldIncludeSalutations() {
    String someone = "Hello World, Thanks you making me Happy";

    assertThat(greeter.greet(someone).length(), is(greaterThan(someone.length())));
  }
}
