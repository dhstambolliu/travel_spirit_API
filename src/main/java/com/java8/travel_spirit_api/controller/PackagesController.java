package com.java8.travel_spirit_api.controller;

import com.java8.travel_spirit_api.service.PackagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/packages")
public class PackagesController {
    @Autowired
    private PackagesService packagesService;
}
