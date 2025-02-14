package BinPack.service.binpacking;

import java.util.Arrays;

public class PackingCertificate {
    private PackingProblem packingProblem;

    public PackingCertificate(PackingProblem packingProblem) {
        this.packingProblem = packingProblem;
    }

    public int[] firstCertificate() {
        int[] certificate = new int[packingProblem.getListWeightObjects().length];
        return Arrays.stream(certificate).map(x -> 0).toArray();
    }

    public int[] lastCertificate() {
        int[] certificate = new int[packingProblem.getNumberPacks()];
        return Arrays.stream(certificate).map(x -> packingProblem.getNumberPacks() - 1).toArray();
    }
}
