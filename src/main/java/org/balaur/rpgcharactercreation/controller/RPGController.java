package org.balaur.rpgcharactercreation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rpg/")
public class RPGController {

    @GetMapping("/name")
    public String name() {
        return "Hello World";
    }
}
