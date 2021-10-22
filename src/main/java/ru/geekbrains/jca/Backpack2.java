package ru.geekbrains.jca;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Backpack2 {

    private List<Thing> bestItems = null;

    private int maxWeightBackpack;
    private int bestPrice;

    public static void main(String[] args) {
        List<Thing> subjects = new ArrayList<>();
        subjects.add(new Thing("Phone", 1, 100));
        subjects.add(new Thing("Weight", 5, 10));
        subjects.add(new Thing("Watch", 2, 50));
        subjects.add(new Thing("Notebook", 3, 150));
        Backpack2 backpack2= new Backpack2(5);
        System.out.println(subjects);
        backpack2.bestVariant(subjects);
    }

    public Backpack2(int maxWeightBackpack) {
        this.maxWeightBackpack = maxWeightBackpack;
    }

    public void bestVariant(List<Thing> things) {
        makeKits(things);
        System.out.println(checkKit(things));
    }

    public void makeKits(List<Thing> things) {
        if (things.size() > 0) {
            this.checkKit(things);
        }
        for (int i = 0; i < things.size(); i++) {
            List<Thing> supportingSet = new ArrayList<>(things);
            supportingSet.remove(i);
            makeKits(supportingSet);
        }
    }

    private List<Thing> checkKit(List<Thing> things) {
        if (this.bestItems == null) {
            if (this.weigthOfKit(things) <= this.maxWeightBackpack) {
                this.bestItems = things;
                this.bestPrice = this.priceOfKit(things);
            }
        } else {
            if (this.weigthOfKit(things) <= this.maxWeightBackpack && this.priceOfKit(things) > this.bestPrice) {
                this.bestItems = things;
                this.bestPrice = this.priceOfKit(things);
            }
        }
        return this.bestItems;
    }

    private int weigthOfKit(List<Thing> things) {
        int result = 0;
        for (Thing thing : things) {
            result += thing.getWeight();
        }
        return result;
    }

    private int priceOfKit(List<Thing> things) {
        int result = 0;
        for (Thing thing : things) {
            result += thing.getPrice();
        }
        return result;
    }



}
