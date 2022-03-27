package com.meonjicompany.planning.jplanningbackend.dto;

import lombok.Data;

@Data
public class PlanSaveDTO {
    private int planId; // PK
    private int userId; // FK
    private String planTitle;
    private String planDate;
}
