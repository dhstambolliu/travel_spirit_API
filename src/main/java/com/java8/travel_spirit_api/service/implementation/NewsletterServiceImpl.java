package com.java8.travel_spirit_api.service.implementation;

import com.java8.travel_spirit_api.dto.NewsletterDTO;
import com.java8.travel_spirit_api.entity.Newsletter;
import com.java8.travel_spirit_api.repository.SubscribeRepository;
import com.java8.travel_spirit_api.service.NewsletterService;
import com.java8.travel_spirit_api.utils.ServiceResponse;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NewsletterServiceImpl implements NewsletterService {
    protected SubscribeRepository subscribeRepository;

    @Override
    public ServiceResponse addNewsletter(NewsletterDTO newsletterDTO) {

        if (StringUtils.isAllBlank(newsletterDTO.getEmail()))
            return ServiceResponse.error("Provide a valid email");

        Newsletter newsletter = mapDTOToSubscribe(newsletterDTO);
        subscribeRepository.save(newsletter);
        return ServiceResponse.success();
    }

    @Override
    public List<NewsletterDTO> getSubscriptions() {
        List<Newsletter> newsletters = subscribeRepository.findAll();
        return newsletters.stream().map(newsletter -> mapSubscribeToDTO(newsletter)).collect(Collectors.toList());
    }

    private NewsletterDTO mapSubscribeToDTO(Newsletter newsletter) {
        NewsletterDTO newsletterDTO = new NewsletterDTO();
        newsletterDTO.setId(newsletter.getId());
        newsletterDTO.setEmail(newsletter.getEmail());
        newsletterDTO.setActive(newsletter.getActive());
        return newsletterDTO;
    }

    private Newsletter mapDTOToSubscribe(NewsletterDTO newsletterDTO) {
        Newsletter newsletter = new Newsletter();
        newsletter.setId(newsletterDTO.getId());
        newsletter.setEmail(newsletterDTO.getEmail());
        newsletter.setActive(newsletterDTO.getActive());
        return newsletter;
    }
}
