package JavaCore.Compare;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Student implements Comparable{
    String name;
    int rollNo;

    public Student(String name, int rollNo) {
        this.rollNo = rollNo;
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        Student student = (Student) o;
        return this.name.compareTo(student.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNo=" + rollNo +
                '}';
    }

    public static void main(String[] args) {

        Student s1 = new Student("Xava", 125);
        Student shraddha = new Student("Shraddha", 123);
        Student snehashish = new Student("Snehashish", 124);
        Student s3 = new Student("ABC", 456);

        List<Student> studentList = Arrays.asList(s1, shraddha, snehashish, s3);
        int i = s1.compareTo(s3);
        Collections.sort(studentList);
        studentList.stream().forEach(System.out::println);



        Collections.sort(studentList, (o1, o2) -> {
            if(o1.rollNo < o2.rollNo) return -1;
            if(o1.rollNo == o2.rollNo) return 0;
            return 1;
        });

        studentList.stream().forEach(System.out::println);
    }
}
