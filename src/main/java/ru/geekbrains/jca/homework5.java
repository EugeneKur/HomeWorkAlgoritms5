package ru.geekbrains.jca;

import java.util.ArrayList;
import java.util.List;

public class homework5 {
    public static void main(String[] args) {
        System.out.println(exponentiationRec(2,5));

    }

    public static int exponentiationRec(int a, int n) {
        if (n > 0) {
            return (a*exponentiationRec(a, n-1));
        }
        else return 1;
    }


}
