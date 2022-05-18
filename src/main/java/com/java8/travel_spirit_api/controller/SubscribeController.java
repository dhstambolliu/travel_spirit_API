package com.java8.travel_spirit_api.controller;

import com.java8.travel_spirit_api.dto.SubscribeDTO;
import com.java8.travel_spirit_api.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscribe")
public class SubscribeController {
    @Autowired
    private SubscribeService subscribeService;

    @GetMapping()
    public List<SubscribeDTO> getSubscriptions() {
        return subscribeService.getSubscriptions();
    }

    @PostMapping("/add")
    public void addSubscription(@RequestBody SubscribeDTO subscribeDTO) {
        subscribeService.addSubscription(subscribeDTO);
    }
}
