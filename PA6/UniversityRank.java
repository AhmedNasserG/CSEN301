package CSEN301.PA6;

public class UniversityRank {
    static class University implements Comparable {
        String name;
        int rank;

        University(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }


        public int compareTo(Object o) {
            University u = (University) o;
            if (rank > u.rank) {
                return 1;
            } else if (rank < u.rank) {
                return -1;
            }
            return name.compareTo(u.name);
        }

        @Override
        public String toString() {
            return "UniversityRanking{" +
                    "name='" + name + '\'' +
                    ", rank=" + rank +
                    '}';
        }
    }

    PriorityQueue pq;

    public UniversityRank(int maxSize) {
        pq = new PriorityQueue(maxSize);
    }




    public static void main(String[] args) {
        PriorityQueue x = new PriorityQueue(5);
        x.insert(new University("FCIC", 4));
        x.insert(new University("GUC", 3));
        x.insert(new University("BUE", 4));
        x.insert(new University("AUC", 2));
        x.insert(new University("FCIS", 1));
        while (!x.isEmpty()) System.out.println(x.remove());
    }
}
