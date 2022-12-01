package aoc2022.day1;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Day1Part1Test {

  public static void main(String[] args){
      Day1 codeUnderTest = new Day1();

      try {
          codeUnderTest.loadFileIntoElves("src/test/resources/day1.txt");
          System.out.println(codeUnderTest.getElfCarryingMostSnacks().toString());
      } catch (IOException e) {
          System.out.println("failed to load file");
          e.printStackTrace();
          throw new RuntimeException(e);
      } catch (NumberFormatException e) {
          System.out.println("failed to parse file");
          e.printStackTrace();
          throw new RuntimeException(e);
      }
  }
  @Test
  public void test(){
      assertTrue(true);
  }

}
