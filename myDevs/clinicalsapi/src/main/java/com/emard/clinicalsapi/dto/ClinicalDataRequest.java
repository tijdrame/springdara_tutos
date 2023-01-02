package com.emard.clinicalsapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Builder@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClinicalDataRequest {
    private String componentName;
    private String componentValue;
    private Long patientId;
}
