package com.neoteric.projectc;

import com.neoteric.projectb.ProjectBService;

public class Helloworld2 {
    public String helloWorld() {
        ProjectBService projectBService = new ProjectBService();
        return "helloWorld";
    }
}
