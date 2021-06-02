package com.company;

import java.io.*;
import java.util.*;
//implements Comparable<Capital>
class Capital {
    String name;
    String group;
    ArrayList<Integer> grade = new ArrayList<>();
    double sr;
    /*public int compareTo(Capital o) {
        return countr.compareTo(o.countr);
    }
    public void printT(){
        System.out.println(countr + ", " + cap);
    }*/
}

class Asd{
    String fname;
    double midd;
}

public class Main {

    public static void main(String[] args) {
        String path = "a.csv";
        String line = "";
        LinkedList<Capital> list = new LinkedList<>();
        TreeSet<Asd> tree1 = new TreeSet<>();
        TreeSet<Asd> tree2 = new TreeSet<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Capital ex = new Capital();
                ex.name = values[0];
                ex.group = values[1];
                for (int i = 2; i < (values.length - 1); i++) {
                    int num = Integer.parseInt(values[i]);
                    ex.grade.add(num);
                }
                list.add(ex);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Collections.sort(list,Capital::compareTo);

        for (Capital s : list) {
            System.out.println(s.name);
            System.out.println(s.group);
            System.out.println(s.grade);
            double sum = 0;
            for (int j = 0; j < s.grade.size() - 1; j++) {
                sum += s.grade.get(j);
            }
            double sred = sum / s.grade.size();
            s.sr = sred;
            System.out.println(s.name);
            System.out.println(s.group);
            System.out.println(s.sr);
            Asd asd1 = new Asd();
            //Asd asd2 = new Asd();
            asd1.fname = s.name;
            asd1.midd = s.sr;
            tree1.add(asd1);
        }
        //tree2 = tree1;
        for (Asd s : tree1) {
            System.out.println(s.fname);
            System.out.println(s.midd);
        }
    }
}