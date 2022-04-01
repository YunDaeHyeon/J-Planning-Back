package com.meonjicompany.planning.jplanningbackend.dto;

import lombok.Data;

@Data
public class PieceRoadDTO {
    private int pieceId; // 상세 계획 PK
    private String pieceTime;
    private String pieceContents;
}
