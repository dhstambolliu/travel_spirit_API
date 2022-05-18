package com.java8.travel_spirit_api.service.implementation;

import com.java8.travel_spirit_api.dto.RatingDTO;
import com.java8.travel_spirit_api.entity.Rating;
import com.java8.travel_spirit_api.repository.RatingRepository;
import com.java8.travel_spirit_api.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    private RatingDTO mapRatingToDTO(Rating rating) {
        RatingDTO ratingDTO = new RatingDTO();
        ratingDTO.setId(rating.getId());
        ratingDTO.setRating(rating.getRating());
        return ratingDTO;
    }

    private Rating mapDTOToRating(RatingDTO ratingDTO) {
        Rating rating = new Rating();
        rating.setId(ratingDTO.getId());
        rating.setRating(ratingDTO.getRating());
        return rating;
    }
}
