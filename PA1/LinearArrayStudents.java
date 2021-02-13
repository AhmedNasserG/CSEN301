package CSEN301.PA1;

public class LinearArrayStudents {

    static class Student {
        String firstName;
        String lastName;
        String id;

        Student(String firstName, String lastName, String id) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.id = id;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", id='" + id + '\'' +
                    '}';
        }
    }

    Student[] arr;
    int numOfStudents;

    LinearArrayStudents(int maxNumOfStudents) {
        arr = new Student[maxNumOfStudents];
        numOfStudents = 0;
    }

    void insertFirst(Student s) {
        if (numOfStudents == arr.length) {
            System.out.println("Array is full");
        } else {
            for (int i = numOfStudents - 1; i >= 0; i--) {
                arr[i + 1] = arr[i];
            }
            arr[0] = s;
            numOfStudents++;
        }
    }

    int search(Student s) {
        for (int i = 0; i < numOfStudents; i++) {
            if (s.equals(arr[i])) {
                return i;
            }
        }
        return -1;
    }

    void delete(Student s) {
        int idx = search(s);
        if (idx == -1) {
            System.out.println("Item is not found");
        } else {
            for (int i = idx; i < numOfStudents - 1; i++) {
                arr[i] = arr[i + 1];
            }
            numOfStudents--;
        }

    }

    void display() {
        for (int i = 0; i < numOfStudents; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {

    }
}


