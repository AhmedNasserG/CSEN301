package CSEN301.PA2;

import java.util.Arrays;

public class StudentRecords {
    static class Student{
        String name;
        int id;
        double GPA;
        public Student(String name, int id, double GPA){
            this.name = name;
            this.id = id;
            this.GPA = GPA;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    ", GPA=" + GPA +
                    '}';
        }
    }

    static void sort(Student[] arr){
        boolean isSorted = false;
        for (int i = 0; i < arr.length - 1 && !isSorted; i++) {
            isSorted = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].name.compareTo(arr[j + 1].name) > 0) {
                    Student temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSorted = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Student[] records =new Student[3];
        records[0] =new Student("Mohamed",9181, 2.1);
        records[1] =new Student("Amira", 2241, 1.2);
        records[2] =new Student("Yasmine",1902,0.9);
        System.out.println("AftersortingbyID:");
        System.out.println(Arrays.toString(records));
        System.out.println("-------------------------------------------------");
        sort(records);
        System.out.println("AftersortingbyName:");
        System.out.println(Arrays.toString(records));
        System.out.println("-------------------------------------------------");
    }
}
