package aoc2022.day1;

import java.io.IOException;

public class Day1Part2Test {
    public static void main(String[] args){
        Day1 codeUnderTest = new Day1();

        try {
            codeUnderTest.loadFileIntoElves("src/test/resources/day1.txt");
            System.out.println("part1");
            System.out.println(codeUnderTest.getElfCarryingMostSnacks().toString());
            System.out.println("part2");
            System.out.println(codeUnderTest.getTop3ElvesCarryingMostSnacks().toString());
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
}
