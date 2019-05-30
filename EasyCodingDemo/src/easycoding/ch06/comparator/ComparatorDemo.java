package easycoding.ch06.comparator;

import java.util.*;

public class ComparatorDemo {
    public static void main(String[] args) {
        Comparator<Cup> comparator = new Comparator<Cup>() {
            @Override
            public int compare(Cup c1, Cup c2) {
                return c2.size - c1.size;
            }
        };

        List<MiniCup> cupList = new ArrayList<>(3);
        cupList.add(new MiniCup("A", 1));
        cupList.add(new MiniCup("B", 21));
        cupList.add(new MiniCup("C", 10));

        operateOnList(cupList);

//        Collections.sort(cupList, comparator);

        System.out.println(cupList);

//        List<? extends Cup> cupList = getCupList();
//        Collections.sort(cupList);
    }

    private static void operateOnList(List<MiniCup> cupList) {
//        for (MiniCup cup : cupList) {
//            System.out.println(cup.name);
//            if (cup.size < 10) {
//                cupList.remove(cup);
//            }
//        }
        int size = cupList.size();
        for (int i = 0; i < size; i++) {
            System.out.println("i = " + i + ", cup = " + cupList.get(i).name);
            if (i == 0) {
                cupList.remove(i);
            }

        }

//        Iterator<? extends  Cup> iterator = cupList.iterator();
//        while (iterator.hasNext()) {
//            Cup cup = iterator.next();
//            System.out.println(cup.name);
//            if (cup.size < 2) {
//                cupList.remove(cup);
//            }
//        }
    }

//    private static List<Cup> getCupList() {
//        List<Cup> cupList = new ArrayList<>(3);
//        cupList.add(new Cup("A", 1));
//        cupList.add(new Cup("B", 21));
//        cupList.add(new MiniCup("C", 10));
//        return cupList;
//    }
}
