package BinPack.service.binpacking;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PackingProblemTest {

    @Test
    public void testProblemHasSolution() {
        int[] listWeightObjects = { 1, 1 };
        PackingProblem packingProblem = new PackingProblem(listWeightObjects, 1, 2);

        assertTrue(packingProblem.hasSolution());
    }

    @Test
    public void testProblemHasNoSolution() {
        int[] listWeightObjects = { 5, 1 };
        PackingProblem packingProblem = new PackingProblem(listWeightObjects, 1, 2);

        assertFalse(packingProblem.hasSolution());
    }
}
