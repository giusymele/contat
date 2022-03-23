package com.example.contat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import com.example.contat.dto.ContattoDTO;
import com.example.contat.dto.RispostaContatti;
import com.example.contat.dto.request.NewPdfDto;
import com.example.contat.dto.response.PdfDto;
import com.example.contat.entity.Contatti;
import com.example.contat.repository.ContatRepositoryextends;
import com.example.contat.repository.UtentiRepository;
import com.example.contat.util.RestTemplateClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ContatService {

    @Autowired
    private ContatRepositoryextends contRepository;

    @Autowired
    private UtentiRepository utentiRepository;

    @Autowired
    private RestTemplateClient restTemplateClient;

    // creare
    public ResponseEntity<?> creaContat(ContattoDTO cont) {

        Contatti contattoEntity = new Contatti();

        contattoEntity.setDescrizione(cont.getDescrizione());
        contattoEntity.setIdUtente(cont.getIdUtente());

        contattoEntity = contRepository.save(contattoEntity);

        cont.setId(contattoEntity.getId());

        return ResponseEntity //
                .status(HttpStatus.OK) //
                .header(HttpHeaders.CONTENT_TYPE) //
                .body(cont);
    }

    // red
    public ResponseEntity<?> getContat() {
        List<ContattoDTO> listaContattiDTO = new ArrayList<ContattoDTO>();

        List<Contatti> listaContattiEntity = contRepository.findAll();

        RispostaContatti rispostaContatti = new RispostaContatti();
        ContattoDTO contatto;

        for (Contatti item : listaContattiEntity) {

            contatto = new ContattoDTO(item.getId(), item.getDescrizione(), item.getIdUtente());

            listaContattiDTO.add(contatto);

        }

        if (listaContattiDTO.isEmpty()) {

            return ResponseEntity //
                    .status(HttpStatus.INTERNAL_SERVER_ERROR) //
                    .header(HttpHeaders.CONTENT_TYPE) //
                    .body("lista vuota");

        }
        rispostaContatti.setListaContatti(listaContattiDTO);

        return ResponseEntity //
                .status(HttpStatus.OK) //
                .header(HttpHeaders.CONTENT_TYPE) //
                .body(rispostaContatti);
    }

    public ResponseEntity<?> getContatById(Long id) {

        if (id > 0 && utentiRepository.findById(id).isPresent()) {
            // recupero il contatto e lo passo a oggetto di Contatti
            Optional<Contatti> contattoEntity = contRepository.findById(id);

            Contatti c = contattoEntity.get();

            ContattoDTO contatto = new ContattoDTO(c.getId(), c.getDescrizione(), c.getIdUtente());

            return ResponseEntity //
                    .status(HttpStatus.OK) //
                    .header(HttpHeaders.CONTENT_TYPE) //
                    .body(contatto);

        } else {
            return ResponseEntity //
                    .status(HttpStatus.INTERNAL_SERVER_ERROR) //
                    .header(HttpHeaders.CONTENT_TYPE) //
                    .body("utente non trovato, non è stato possibile trovare l'elemento desiderato");
        }
    }

    public ResponseEntity<?> deletebyId(Long id) {

        ResponseEntity<?> esisteID = getContatById(id);
        HttpStatus status = esisteID.getStatusCode();
        if (status.is2xxSuccessful()) {

            contRepository.deleteById(id);

            return ResponseEntity //
                    .status(HttpStatus.OK) //
                    .header(HttpHeaders.CONTENT_TYPE) //
                    .body("eliminato");

        } else {
            return ResponseEntity //
                    .status(HttpStatus.INTERNAL_SERVER_ERROR) //
                    .header(HttpHeaders.CONTENT_TYPE) //
                    .body("eliminato");
        }
    }

    public ResponseEntity<?> upDateById(ContattoDTO contattoDto) {

        Contatti contattoModificato = null;

        if (contRepository.findById(contattoDto.getId()).isPresent()) {

            contattoModificato = new Contatti(contattoDto.getId(), contattoDto.getDescrizione(),
                    contattoDto.getIdUtente());

            contattoModificato = contRepository.save(contattoModificato);

        } else {

            contattoModificato = new Contatti();
            contattoModificato.setDescrizione(contattoDto.getDescrizione());
            contattoModificato.setIdUtente(contattoDto.getIdUtente());

            contattoModificato = contRepository.save(contattoModificato);

        }

        return ResponseEntity //
                .status(HttpStatus.OK) //
                .header(HttpHeaders.CONTENT_TYPE) //
                .body(contattoModificato);
    }

    public ResponseEntity<?> getAllContatPdf(String titolo) {

        ResponseEntity<NewPdfDto> result = null;
        String url = "http://localhost:8085/pdf";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        NewPdfDto newPdfDto = new NewPdfDto();
        newPdfDto.setTitolo(titolo);

        List<Contatti> lista = new ArrayList();
        List<String> listaDiContatti = new ArrayList();

        lista = contRepository.findAll();
        if (!lista.isEmpty()) {

            for (Contatti item : lista) {

                listaDiContatti.add(item.getDescrizione());

            }
            newPdfDto.setLista(listaDiContatti);

            HttpEntity<NewPdfDto> entity = new HttpEntity<NewPdfDto>(newPdfDto, headers);

            try {
                //	SSLValidation.turnOffSslChecking();

                result = restTemplateClient.exchange(url, HttpMethod.POST,entity , NewPdfDto.class);

            } catch (HttpStatusCodeException ex) {

                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(ex.getMessage());
            } catch (Exception ex) {

                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(ex.getMessage());
            }
        }
        return result;
    }
}
