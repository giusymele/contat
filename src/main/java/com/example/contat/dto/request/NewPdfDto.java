
package com.example.contat.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 *
 * @author giuseppina.mele
 */
@Data
public class NewPdfDto implements Serializable {
    

    @JsonProperty("titolo")
    private String titolo= null;
    //private int numeroRighe;
    @JsonProperty("numeroColonne")
    private Integer numeroColonne=1;
    @JsonProperty("lista")
    private List<String> lista=null;

}
