package CSEN301.PA11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class HashedSymbolTable {
    LinkedList[] theTable;
    int size;
    double loadFactor = 0.7;
    int itemsCount;
    static int countReadItems = 0;


    public HashedSymbolTable() {
        size = 1000;
        theTable = new LinkedList[size];
        itemsCount = 0;
    }

    public HashedSymbolTable(int size) {
        this.size = size;
        theTable = new LinkedList[size];
        itemsCount = 0;
    }

    public int hash(String word) {
        return Math.abs(word.hashCode()) % size;
    }

    public boolean isFull() {
        return ((double) itemsCount) / size > loadFactor;
    }

    public void resize() {
        this.size = size * 2;
        LinkedList[] newTable = new LinkedList[size];

        for (int i = 0; i < theTable.length; i++) {
            if (theTable[i] != null) {
                while (!theTable[i].isEmpty()) {
                    int pos = hash((String) theTable[i].getFirst());
                    if (newTable[i] == null) {
                        newTable[i] = new LinkedList();
                    }
                    newTable[i].addLast((String) theTable[i].removeFirst());
                }

            }
            theTable = newTable;
        }
    }

    public boolean put(String word) {
        if (isFull()) {
            resize();
        }
        int pos = hash(word);

        if (theTable[pos] != null) {
            for (int i = 0; i < theTable[pos].size(); i++) {
                if (theTable[pos].getFirst().equals(word)) {
                    return false;
                }
                theTable[pos].addLast(theTable[pos].removeFirst());
            }
        } else {
            theTable[pos] = new LinkedList();
        }
        theTable[pos].addLast(word);
        itemsCount++;
        return true;
    }

    public boolean get(String word) {
        int pos = hash(word);
        if (theTable[pos] == null) {
            return false;
        }
        for (int i = 0; i < theTable[pos].size(); i++) {
            if (theTable[pos].getFirst().equals(word)) {
                return true;
            }
            theTable[pos].addLast(theTable[pos].removeFirst());
        }

        return false;
    }

    public void resetCounter(){
        countReadItems = 0;
    }
    public int getCounter(){
        return countReadItems;
    }
    public int size(){
        return itemsCount;
    }
    public double getLoadFactor(){
        return loadFactor;
    }


    public static void main(String[] args) throws Exception {
        HashedSymbolTable symTable = new HashedSymbolTable();
        String testFile = "wordlist.txt";// preparing to read input from input
        FileReader inputFile = new FileReader(testFile);
        BufferedReader br = new BufferedReader(inputFile);
        String temp = null;
        while ((temp = br.readLine()) != null) {
            symTable.put(temp);
        }// closing input
        inputFile.close();// resetting file to read from it
        inputFile = new FileReader(testFile);
        br = new BufferedReader(inputFile);// resetting counter to calculate average
        symTable.resetCounter();// couting number of read words
        int wordCount = 0;
        while ((temp = br.readLine()) != null) {
            wordCount++;
            symTable.get(temp);
        }// closing input
        inputFile.close();//calculating average comparisons
        int avg = symTable.getCounter() / wordCount;
        System.out.println("FinalsizeofSymbolTable:" + symTable.size() + "words\n");
        System.out.println("LoadfactorofSymbolTableis:" + symTable.getLoadFactor());
        System.out.println("\nAveragenumberofcomparisonstolookupaword:" + avg);
    }

}
