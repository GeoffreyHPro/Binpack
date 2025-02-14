package BinPack.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BinPack.exception.NoSolutionException;
import BinPack.request.BinPackConfiguration;
import BinPack.service.binpacking.PackingCertificate;
import BinPack.service.binpacking.PackingProblem;

@RestController
@RequestMapping(path = "/binPack")
public class BinPackProblemController {

    @PostMapping
    public ResponseEntity<?> getMapp(@RequestBody BinPackConfiguration binPackConfiguration) {
        try {
            PackingProblem packingProblem = new PackingProblem(binPackConfiguration.getListWeightObject(),
                    binPackConfiguration.getCapacityPack(), binPackConfiguration.getNumberPacks());
            PackingCertificate packingCertificate = new PackingCertificate(packingProblem);
            int[] certificate = packingCertificate.exhaustiveSearch();
            return ResponseEntity.status(200).body(certificate);
        } catch (NoSolutionException e) {
        }
        return ResponseEntity.status(400).body("");
    }
}
