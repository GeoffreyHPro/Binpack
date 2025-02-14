package BinPack.service.binpacking;

import java.util.Arrays;

public class PackingProblem {
    private int listWeightObjects[];
    private int capacityPack;
    private int numberPacks;

    public PackingProblem(int listWeightObjects[], int capacityPack, int numberPacks) {
        this.capacityPack = capacityPack;
        this.numberPacks = numberPacks;
        this.listWeightObjects = listWeightObjects;
    }

    public int getCapacityPack() {
        return capacityPack;
    }

    public int[] getListWeightObjects() {
        return listWeightObjects;
    }

    public int getNumberPacks() {
        return numberPacks;
    }

    public void setCapacityPack(int capacityPack) {
        this.capacityPack = capacityPack;
    }

    public void setListWeightObjects(int[] listWeightObjects) {
        this.listWeightObjects = listWeightObjects;
    }

    public void setNumberPacks(int numberPacks) {
        this.numberPacks = numberPacks;
    }

    public boolean hasSolution() {
        boolean exceedsPacksCapacity;
        int[] getListWeightObjects = getListWeightObjects();

        int totalWeight = Arrays.stream(getListWeightObjects)
                .sum();
        exceedsPacksCapacity = totalWeight <= getNumberPacks()
                * getCapacityPack();

        boolean exceedsCapacity = Arrays.stream(getListWeightObjects)
                .anyMatch(x -> x > getCapacityPack());

        return exceedsPacksCapacity && !exceedsCapacity;
    }
}
