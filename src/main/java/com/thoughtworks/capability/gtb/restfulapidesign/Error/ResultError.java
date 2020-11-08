package com.thoughtworks.capability.gtb.restfulapidesign.Error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultError {
    private String errorCode;
    private String errorMessage;
}
