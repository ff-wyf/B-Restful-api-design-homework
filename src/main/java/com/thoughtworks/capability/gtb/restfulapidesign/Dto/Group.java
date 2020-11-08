package com.thoughtworks.capability.gtb.restfulapidesign.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Group {
    private Integer id;
    private String name;
    private String note;
}
