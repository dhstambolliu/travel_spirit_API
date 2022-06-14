package com.java8.travel_spirit_api.controller;

import com.java8.travel_spirit_api.dto.NewsletterDTO;
import com.java8.travel_spirit_api.service.NewsletterService;
import com.java8.travel_spirit_api.utils.ServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/newsletter")
public class NewsletterController {

    protected NewsletterService newsletterService;

    @GetMapping()
    public List<NewsletterDTO> getSubscriptions() {
        return newsletterService.getSubscriptions();
    }

    @PostMapping("/add")
    public ServiceResponse addNewsletter(@RequestBody NewsletterDTO newsletterDTO) {
        return newsletterService.addNewsletter(newsletterDTO);
    }
}
