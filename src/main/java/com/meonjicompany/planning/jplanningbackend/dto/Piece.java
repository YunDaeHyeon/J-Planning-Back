package com.meonjicompany.planning.jplanningbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Piece {
    @JsonProperty("piece_time")
    private String pieceTime;
    @JsonProperty("piece_contents")
    private String pieceContents;
}
