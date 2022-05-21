package com.java8.travel_spirit_api.service.implementation;

import com.java8.travel_spirit_api.dto.RatingDTO;
import com.java8.travel_spirit_api.entity.Rating;
import com.java8.travel_spirit_api.repository.RatingRepository;
import com.java8.travel_spirit_api.service.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RatingServiceImpl implements RatingService {

    protected RatingRepository ratingRepository;

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
