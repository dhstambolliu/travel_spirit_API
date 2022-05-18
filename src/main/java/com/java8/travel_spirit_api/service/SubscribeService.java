package com.java8.travel_spirit_api.service;

import com.java8.travel_spirit_api.dto.SubscribeDTO;

import java.util.List;

public interface SubscribeService {
    void addSubscription(SubscribeDTO subscribeDTO);

    List<SubscribeDTO> getSubscriptions();
}
