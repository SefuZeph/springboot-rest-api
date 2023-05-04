package com.sefu.springbootrestapi.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    // HTTP GET request
    // http://localhost:8080/hello-world

    @GetMapping("/hello-world")
    fun helloWorld():String{
        return "Hello World!"
    }
}