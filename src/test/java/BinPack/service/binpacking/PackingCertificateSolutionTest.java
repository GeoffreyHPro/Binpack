package BinPack.service.binpacking;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PackingCertificateSolutionTest {

    private int[] certificateIsSolution = { 1, 1, 0 };
    private int[] listWeightPacks = { 0, 1, 1 };
    private PackingProblem packingProblem;
    private PackingCertificate packingCertificate;

    @BeforeEach
    public void init() {
        this.packingProblem = new PackingProblem(listWeightPacks, 1, 2);
        this.packingCertificate = new PackingCertificate(packingProblem);
    }

    @Test
    public void testCertificateIsS() {
        int[] certificate = { 1, 1 };
        int[] listPacks = packingCertificate.problemAndCertificateToListWeigthPacks(certificateIsSolution);
        assertTrue(Arrays.equals(listPacks, certificate));
    }
}
