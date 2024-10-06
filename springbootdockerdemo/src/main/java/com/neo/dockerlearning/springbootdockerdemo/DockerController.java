package com.neo.dockerlearning.springbootdockerdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {
    @GetMapping(value = "/docker")
    public String Helloworld(){
        return "hai from docker";
    }
}
