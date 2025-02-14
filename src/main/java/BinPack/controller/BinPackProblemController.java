package BinPack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/binPack")
public class BinPackProblemController {

    @GetMapping
    public String getMapp() {
        return "hello world";
    }
}
