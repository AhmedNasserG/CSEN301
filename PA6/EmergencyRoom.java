package CSEN301.PA6;

public class EmergencyRoom {

    class Patient implements Comparable {
        String name;
        int p;

        public Patient(String name, int p) {
            this.name = name;
            this.p = p;
        }

        public int compareTo(Object o) {
            Patient patient = (Patient) o;
            if (this.p > patient.p) {
                return 1;
            }
            return -1;
        }

        @Override
        public String toString() {
            return "Patient{" +
                    "name='" + name + '\'' +
                    ", p=" + p +
                    '}';
        }
    }

    PriorityQueue pq;

    public EmergencyRoom(int maxSize) {
        pq = new PriorityQueue(maxSize);
    }

    void newPatient(String n, int p) {
        pq.insert(new Patient(n, p));
    }

    Patient nextPatient() {
        if (pq.isEmpty()) {
            return null;
        }
        return (Patient) pq.remove();
    }

    public static void main(String[] args) {
        EmergencyRoom r = new EmergencyRoom(5);
        r.newPatient("John", 3);
        r.newPatient("Erick", 5);
        r.newPatient("Jessica", 1);
        r.newPatient("Michael", 2);
        r.newPatient("Mona", 4);
        for (Patient p = r.nextPatient(); p != null; p = r.nextPatient()) System.out.println(p.name);
    }

}
