package com.java8.travel_spirit_api.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO {

    private Long id;
    private String fullName;
    private String email;
    private String subject;
}
