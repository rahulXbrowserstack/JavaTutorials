package learnCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class MyComparator implements Comparator<Integer> {

    // if we want to get o1 first then o2, then we should return a -ve number
    // if we want to get o1 and o2 at the same position, then we should return 0
    // if we want to get o2 first then o1, then we should return a +ve number
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }
}

class StringLengthComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}

class Student {
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }
}

public class LearnComparator {
    public static void main(String[] args) {
        List <Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);

        // list.sort(new MyComparator());
        list.sort((a, b) -> a - b); // using lambda expression to sort the list in natural order
        System.out.println(list); // [1, 2, 3]


        List <String> words = Arrays.asList("banana", "apple", "date");
        // words.sort(new StringLengthComparator());
        words.sort((s1, s2) -> s1.length() - s2.length()); // using lambda expression to sort the list based on string length
        System.out.println(words); // [date, apple, banana]


        List <Student> students = new ArrayList<>();
        students.add(new Student("Charlie", 3.5));
        students.add(new Student("Bob", 3.7));
        students.add(new Student("Alice", 3.5));
        students.add(new Student("Akshit", 3.9));

        Comparator<Student> comparator = Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName);

        students.sort((o1, o2) -> {
            if(o2.getGpa() - o1.getGpa() > 0) {
                return 1;
            }
            else if (o2.getGpa() - o1.getGpa() < 0) {
                return -1;
            }
            else {
                return o1.getName().compareTo(o2.getName());
            }
        });

        // students.sort(comparator);

        Collections.sort(students, comparator);

        for(Student student : students) {
            System.out.println(student.getName() + ": " + student.getGpa());
        }

    }
}
