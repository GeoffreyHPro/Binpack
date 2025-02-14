package BinPack.service.binpacking;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import BinPack.exception.NoSolutionException;

public class PackingCertificateTest {

    @Test
    public void testCompareFirstCertificate() {
        int[] rigthCertificate = new int[2];
        int[] wrongCertificate = new int[3];

        PackingProblem packingProblem = new PackingProblem(new int[2], 1, 2);
        PackingCertificate packingCertificate = new PackingCertificate(packingProblem);

        assertTrue(Arrays.equals(packingCertificate.firstCertificate(), rigthCertificate));
        assertFalse(Arrays.equals(packingCertificate.firstCertificate(), wrongCertificate));
    }

    @Test
    public void testCompareLastCertificate() {
        int[] rigthCertificate = { 1, 1 };
        int[] wrongCertificate = { 0, 0 };

        PackingProblem packingProblem = new PackingProblem(new int[2], 1, 2);
        PackingCertificate packingCertificate = new PackingCertificate(packingProblem);

        assertTrue(Arrays.equals(packingCertificate.lastCertificate(), rigthCertificate));
        assertFalse(Arrays.equals(packingCertificate.lastCertificate(), wrongCertificate));
    }

    @Test
    public void testCompareLastCertificateTwo() {
        int[] rigthCertificate = { 1, 1, 1 };
        int[] wrongCertificate = { 0, 0, 0 };

        PackingProblem packingProblem = new PackingProblem(new int[3], 2, 2);
        PackingCertificate packingCertificate = new PackingCertificate(packingProblem);

        Arrays.stream(packingCertificate.lastCertificate()).forEach(System.out::println);

        assertTrue(Arrays.equals(packingCertificate.lastCertificate(), rigthCertificate));
        assertFalse(Arrays.equals(packingCertificate.lastCertificate(), wrongCertificate));
    }

    @Test
    public void testCertificateIsSolution() {
        int[] certificateIsSolution = { 0, 0, 1 };
        int[] certificateIsSolutionTwo = { 1, 0, 0 };
        int[] certificateWrong = { 0, 0, 0 };

        int[] listWeightPacks = { 1, 1, 2 };

        PackingProblem packingProblem = new PackingProblem(listWeightPacks, 2, 2);
        PackingCertificate packingCertificate = new PackingCertificate(packingProblem);

        assertTrue(packingCertificate.certificateIsSolution(certificateIsSolution));
        assertTrue(packingCertificate.certificateIsSolution(certificateIsSolutionTwo));
        assertFalse(packingCertificate.certificateIsSolution(certificateWrong));
    }

    @Test
    public void testNextCertificate() throws NoSolutionException {
        int[] currentCertificate = { 0, 0, 0 };
        int[] expectedNextCertificateOne = { 0, 0, 1 };
        int[] expectedNextCertificateTwo = { 0, 1, 0 };

        int[] listWeightPacks = { 1, 1, 2 };

        PackingProblem packingProblem = new PackingProblem(listWeightPacks, 2, 2);
        PackingCertificate packingCertificate = new PackingCertificate(packingProblem);
        int[] nextCertificateValue = packingCertificate.nextCertificate(currentCertificate);

        assertTrue(Arrays.equals(expectedNextCertificateOne, nextCertificateValue));
        nextCertificateValue = packingCertificate.nextCertificate(currentCertificate);

        assertTrue(Arrays.equals(expectedNextCertificateTwo, nextCertificateValue));
    }

    @Test
    public void testFoundValidCertificate() throws NoSolutionException {
        int[] listWeightPacks = { 1, 1, 2 };
        int[] firstCertificate = { 0, 0, 1 };

        PackingProblem packingProblem = new PackingProblem(listWeightPacks, 2, 2);
        PackingCertificate packingCertificate = new PackingCertificate(packingProblem);
        int[] validCertificate = packingCertificate.exhaustiveSearch();

        assertTrue(Arrays.equals(validCertificate, firstCertificate));

        
    }

    @Test
    public void testFoundValidCertificateThrowException() {
        assertThrows(NoSolutionException.class, () -> {
            int[] listWeightPacks = { 1, 1, 2 };

            PackingProblem packingProblem = new PackingProblem(listWeightPacks, 1, 2);
            PackingCertificate packingCertificate = new PackingCertificate(packingProblem);
            packingCertificate.exhaustiveSearch();
        });
    }
}