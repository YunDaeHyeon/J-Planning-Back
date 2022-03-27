package com.meonjicompany.planning.jplanningbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class PlanDTO {
    @JsonProperty("user_id") // 카멜(json), 스네이크(java) 케이스 매핑
    private int userId;
    @JsonProperty("plan_title")
    private String planTitle;
    @JsonProperty("plan_date")
    private String planDate;
    @JsonProperty("contents")
    private ArrayList<Piece> Pieces = new ArrayList<Piece>();

}
