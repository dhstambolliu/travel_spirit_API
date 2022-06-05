package com.java8.travel_spirit_api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PackageFilter {
    protected Long cityId;
    protected String packageName;
    protected String query;
}
