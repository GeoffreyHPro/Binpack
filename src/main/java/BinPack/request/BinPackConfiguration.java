package BinPack.request;

import lombok.Data;

@Data
public class BinPackConfiguration {
    private int[] listWeightObject;
    private int numberPacks;
    private int capacityPack;

    public BinPackConfiguration(int listWeightObject[], int numberPacks, int capacityPack) {
        this.listWeightObject = listWeightObject;
        this.numberPacks = numberPacks;
        this.capacityPack = capacityPack;
    }
}
