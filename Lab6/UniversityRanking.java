package CSEN301.Lab6;

import CSEN301.PA6.PriorityQueue;


public class UniversityRanking {
    static class University implements Comparable {
        String name;
        int rank;

        public University(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Object o) {
            University u = (University) o;
            if (rank > u.rank) {
                return 1;
            } else if (rank == u.rank) {
                return name.compareTo(u.name);
            } else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return "University{" +
                    "name='" + name + '\'' +
                    ", rank=" + rank +
                    '}';
        }
    }

    PriorityQueue pq;

    public UniversityRanking(int maxSize) {
        pq = new PriorityQueue(maxSize);
    }
    public void addUni(University u){
        pq.insert(u);
    }

    public University getUni(){
        return (University) pq.remove();
    }

    public static void main(String[] args) {
        UniversityRanking rank = new UniversityRanking(4);
        rank.addUni(new University("GUC", 1));
        rank.addUni(new University("AUC", 1));
        rank.addUni(new University("MIU", 3));
        rank.addUni(new University("AAST", 2));
        for (int i = 0; i < 4; i++) {
            System.out.println(rank.getUni());
        }
    }

    public static class HospitalEmergencyRoom {
        static class Patient implements Comparable {
            int degreeOfSevere;
            String name;

            Patient(String name, int degreeOfSevere) {
                this.degreeOfSevere = degreeOfSevere;
                this.name = name;
            }

            @Override
            public int compareTo(Object o) {
                Patient p = (Patient) o;
                if (degreeOfSevere > p.degreeOfSevere) {
                    return 1;
                } else if (degreeOfSevere < p.degreeOfSevere) {
                    return -1;
                }
                return 0;
            }
        }

    }
}
