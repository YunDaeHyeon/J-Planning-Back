package com.meonjicompany.planning.jplanningbackend.dto;

import lombok.Data;

@Data
public class PieceSaveDTO {
    private int pieceId; // PK
    private int planId; // FK
    private String pieceTime;
    private String pieceContents;
}
