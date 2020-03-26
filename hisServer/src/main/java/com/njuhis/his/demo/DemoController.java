package com.njuhis.his.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/printUserWithRequestBody")
    public void printUserWithRequestBody(@RequestBody DemoUser demoUser){
        System.out.println(demoUser.getName()+" "+demoUser.getPassword());
    }

    @RequestMapping("/printUserWithRequestParam")
    public void printUserWithRequestParam(@RequestParam String name, String password){
        System.out.println(name+" "+password);
    }

    @RequestMapping("/printUserWithPathVariable/{name}/{password}")
    public void printUserWithPathVariable(@PathVariable String name, @PathVariable String password){
        System.out.println(name+" "+password);
    }
}
