package CSEN301.PA4;

public class AverageGPA {
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

    static double calculate(StackObj stack) {
        int size = stack.size();
        int GPASum = 0;
        while (!stack.isEmpty()) {
            GPASum += ((Student) stack.pop()).GPA;
        }
        return GPASum / size;
    }

    public static void main (String[] args) {
        StackObj stack = new StackObj(2);
        stack.push(new Student("ahmed", 1, 2));
        stack.push(new Student("mohamed", 2, 4));
        System.out.println(calculate(stack));

    }
}
