package com.example.contat.dto.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Data
public class PdfDto implements Serializable {


    @JsonProperty("id")
    private Integer id;

    @JsonProperty("titolo")
    private String titolo;
    
    @JsonProperty("base64")
    private String base64;
   
}
