package LE4Q1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class EthanExerciseOnFileMapSet {

    public static void main(String[] args) throws FileNotFoundException {
        header(4);
        TreeMap<String, Integer> map = new TreeMap<>();
        populateTreeMap("SE2205Students.txt", "Last", map);
        System.out.println("List of the number of students with the same Last name:");
        System.out.printf("%18s %14s \n", "Last-name", "number");
        System.out.println("---------------------------------------");
        printList(map);

        TreeMap<String, Integer> map2 = new TreeMap<>();
        populateTreeMap("SE2205Students.txt", "First", map2);
        System.out.println("\nList of the number of students with the same First name");
        System.out.printf("%18s %14s \n", "First-name", "number");
        System.out.println("---------------------------------------");
        printList(map2);
        footer(4);

    }
    public static void populateTreeMap(String pathname, String name, TreeMap<String, Integer> map) throws FileNotFoundException {
        File file = new File(pathname);
        Scanner fileInput = new Scanner(file);
        if(!file.exists()) {
            System.out.println("File not found!");
            System.exit(0);
        }
        while(fileInput.hasNext()) {
            String[] words = fileInput.nextLine().split(" ");
            if (name.equals("Last")) {
                String key = words[0];
                if (map.get(key) == null) {
                    map.put(key, 1);
                } else {
                    int val = map.get(key);
                    val++;
                    map.put(key, val);
                }
            }
            if(name.equals("First")) {
                String key = words[1];
                if(map.get(key) == null) {
                    map.put(key, 1);
                } else {
                    int val = map.get(key);
                    val++;
                    map.put(key,val);
                }
            }
        }
        fileInput.close();
    }
    public static void printList(TreeMap<String, Integer> map) {
        Set<Map.Entry<String, Integer>> entry_Set = map.entrySet();
        for(Map.Entry<String, Integer> entry : entry_Set) {
            System.out.printf("%18s  %8d\n", entry.getKey(), entry.getValue());
        }
    }
    public static void header(int labE_number) {
        System.out.println("=============================================");
        System.out.println("Lab Exercise " + labE_number);
        System.out.println("Prepared by: Ethan Wong");
        System.out.println("Student Number: 251205049");
        System.out.println("Goal: To work with Map and TreeMaps to sort and get the key and value of a text file");
        System.out.println("=============================================\n");
    }
    public static void footer(int labE_number) {
        System.out.println("\n=============================================");
        System.out.println("Completion of Lab Exercise " + labE_number + "is successful!");
        System.out.println("Signing off -Ethan ");
        System.out.println("=============================================");
    }

}
