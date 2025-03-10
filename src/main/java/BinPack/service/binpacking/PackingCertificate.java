package BinPack.service.binpacking;

import java.util.Arrays;

import BinPack.exception.NoSolutionException;

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
        int[] certificate = new int[packingProblem.getListWeightObjects().length];
        return Arrays.stream(certificate).map(x -> packingProblem.getNumberPacks() - 1).toArray();
    }

    public boolean certificateIsSolution(int[] certificate) {
        if (certificate.length != packingProblem.getListWeightObjects().length) {
            return false;
        }
        int[] listWeigthPacks = problemAndCertificateToListWeigthPacks(certificate);

        boolean anyPackExceedsCapacity = Arrays.stream(listWeigthPacks)
                .anyMatch(x -> x > packingProblem.getCapacityPack());

        return !anyPackExceedsCapacity;
    }

    public int[] problemAndCertificateToListWeigthPacks(int[] certificate) {
        int[] listWeightPacks = new int[packingProblem.getNumberPacks()];

        for (int i = 0; i < certificate.length; i++) {
            listWeightPacks[certificate[i]] += packingProblem.getListWeightObjects()[i];
        }

        return listWeightPacks;
    }

    public int[] nextCertificate(int[] certificate) throws NoSolutionException {
        for (int i = certificate.length - 1; i > -1; i--) {
            if (certificate[i] != packingProblem.getNumberPacks() - 1) {
                certificate[i]++;
                return certificate;
            } else {
                certificate[i] = 0;
            }
        }
        throw new NoSolutionException();
    }

    public int[] exhaustiveSearch() throws NoSolutionException {
        if (!packingProblem.hasSolution()) {
            throw new NoSolutionException();
        }

        int[] currentCertificate = firstCertificate();

        while (!Arrays.equals(currentCertificate, lastCertificate())) {
            if (certificateIsSolution(currentCertificate)) {
                return currentCertificate;
            }
            currentCertificate = nextCertificate(currentCertificate);
        }
        if (certificateIsSolution(currentCertificate)) {
            return currentCertificate;
        }
        throw new NoSolutionException();
    }
}
