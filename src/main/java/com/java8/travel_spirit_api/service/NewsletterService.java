package com.java8.travel_spirit_api.service;

import com.java8.travel_spirit_api.dto.NewsletterDTO;
import com.java8.travel_spirit_api.utils.ServiceResponse;

import java.util.List;

public interface NewsletterService {
    ServiceResponse addNewsletter(NewsletterDTO newsletterDTO);

    List<NewsletterDTO> getSubscriptions();
}
