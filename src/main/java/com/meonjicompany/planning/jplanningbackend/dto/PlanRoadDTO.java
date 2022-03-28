package com.meonjicompany.planning.jplanningbackend.dto;

import lombok.Data;

@Data
public class PlanRoadDTO {
    private int planId; // 계획 PK
    // private int userId; // 계획 <-> 유저 FK
    private String planDate;
    private String planTitle;
}
