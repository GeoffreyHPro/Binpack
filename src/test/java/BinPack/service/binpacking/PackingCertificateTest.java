package BinPack.service.binpacking;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class PackingCertificateTest {

    @Test
    public void testCompareCertificate() {
        int[] certificateSuccess = new int[2];
        int[] certificateWrong = new int[3];

        PackingProblem packingProblem = new PackingProblem(new int[2], 1, 2);
        PackingCertificate packingCertificate = new PackingCertificate(packingProblem);

        assertTrue(Arrays.equals(packingCertificate.firstCertificate(), certificateSuccess));
        assertFalse(Arrays.equals(packingCertificate.firstCertificate(), certificateWrong));
    }
}
