package com.java8.travel_spirit_api.controller;

import com.java8.travel_spirit_api.dto.SubscribeDTO;
import com.java8.travel_spirit_api.service.SubscribeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/subscribe")
public class SubscribeController {

    protected SubscribeService subscribeService;

    @GetMapping()
    public List<SubscribeDTO> getSubscriptions() {
        return subscribeService.getSubscriptions();
    }

    @PostMapping("/add")
    public void addSubscription(@RequestBody SubscribeDTO subscribeDTO) {
        subscribeService.addSubscription(subscribeDTO);
    }
}
