package com.java8.travel_spirit_api.controller;

import com.java8.travel_spirit_api.service.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/rating")
public class RatingController {

    protected RatingService ratingService;
}
