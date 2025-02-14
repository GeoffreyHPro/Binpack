package BinPack.service.binpacking;

public class PackingProblem {
    private int listWeightObjects[];
    private int capacityPack;
    private int numberPacks;

    public PackingProblem(int listWeightObjects[], int capacityPack, int numberPacks) {
        this.capacityPack = capacityPack;
        this.numberPacks = numberPacks;
        this.numberPacks = numberPacks;
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

}
