package com.java8.travel_spirit_api.service.implementation;

import com.java8.travel_spirit_api.dto.SubscribeDTO;
import com.java8.travel_spirit_api.entity.Subscribe;
import com.java8.travel_spirit_api.repository.SubscribeRepository;
import com.java8.travel_spirit_api.service.SubscribeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SubscribeServiceImpl implements SubscribeService {
    protected SubscribeRepository subscribeRepository;

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
        subscribeDTO.setActive(subscribe.getActive());
        return subscribeDTO;
    }

    private Subscribe mapDTOToSubscribe(SubscribeDTO subscribeDTO) {
        Subscribe subscribe = new Subscribe();
        subscribe.setId(subscribeDTO.getId());
        subscribe.setEmail(subscribeDTO.getEmail());
        subscribe.setActive(subscribeDTO.getActive());
        return subscribe;
    }
}
