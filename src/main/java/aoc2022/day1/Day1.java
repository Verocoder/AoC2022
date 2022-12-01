package aoc2022.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day1 {

    private List<List<Integer>> elves;
    public void loadFileIntoElves(String filepath) throws IOException, NumberFormatException {
        elves = parseListIntoElves(loadFileIntoList(filepath));
    }
    protected List<List<Integer>> parseListIntoElves(List<String> rows) throws NumberFormatException{
        List<List<Integer>> elves = new ArrayList<>();
        List<Integer> elf = new ArrayList<>();
        for (String row: rows){
            if(row.isBlank()){
                if (!elf.isEmpty()){
                    elves.add(elf);
                }
                elf = new ArrayList<>();
            } else {
                elf.add(Integer.parseInt(row));
            }
        }
        return elves;
    }
    protected List<String> loadFileIntoList(String filepath) throws IOException {
        List<String> rows = new ArrayList<>();
        Files.lines(Paths.get(filepath)).forEach(rows::add);
        return rows;
    }

    public Integer getElfCarryingMostSnacks(){
        return elves.stream().mapToInt(this::sumValueFromAList).max().orElse(0);
    }

    public Integer getTop3ElvesCarryingMostSnacks(){
//        not sure why this cast is needed
        elves.sort(Comparator.comparingInt(v -> sumValueFromAList((List<Integer>) v)).reversed());
        List<Integer> top3 = new ArrayList<>();
        top3.add(sumValueFromAList(elves.get(0)));
        top3.add(sumValueFromAList(elves.get(1)));
        top3.add(sumValueFromAList(elves.get(2)));
        return sumValueFromAList(top3);
    }


    protected Integer parseLargestNumberFromList(List<Integer> list){
        return list.stream().mapToInt(v -> v).max().orElse(0);
    }

    protected Integer sumValueFromAList(List<Integer> list){
        return list.stream().mapToInt(v -> v).sum();
    }
}
