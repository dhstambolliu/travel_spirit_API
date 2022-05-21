package com.java8.travel_spirit_api.service.implementation;

import com.java8.travel_spirit_api.dto.SubscribeDTO;
import com.java8.travel_spirit_api.entity.Subscribe;
import com.java8.travel_spirit_api.repository.SubscribeRepository;
import com.java8.travel_spirit_api.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscribeServiceImpl implements SubscribeService {
    @Autowired
    private SubscribeRepository subscribeRepository;

    @Override
    public void addSubscription(SubscribeDTO subscribeDTO) {
        Subscribe subscribe = mapDTOToSubscribe(subscribeDTO);
        subscribeRepository.save(subscribe);
    }

    @Override
    public List<SubscribeDTO> getSubscriptions() {
        List<Subscribe> subscribes = subscribeRepository.findAll();
        return subscribes.stream().map(subscribe -> mapSubscribeToDTO(subscribe)).collect(Collectors.toList());
    }

    private SubscribeDTO mapSubscribeToDTO(Subscribe subscribe) {
        SubscribeDTO subscribeDTO = new SubscribeDTO();
        subscribeDTO.setId(subscribe.getId());
        subscribeDTO.setEmail(subscribe.getEmail());
        subscribeDTO.setIs_active(subscribe.getActive());
        return subscribeDTO;
    }

    private Subscribe mapDTOToSubscribe(SubscribeDTO subscribeDTO) {
        Subscribe subscribe = new Subscribe();
        subscribe.setId(subscribeDTO.getId());
        subscribe.setEmail(subscribeDTO.getEmail());
        subscribe.setActive(subscribeDTO.getIs_active());
        return subscribe;
    }
}
