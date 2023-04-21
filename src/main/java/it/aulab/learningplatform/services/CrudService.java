package it.aulab.learningplatform.services;

import java.util.List;
import java.util.Map;
//! Read -> DTO di lettura
//! Create -> DTO di scrittura
//! Update -> DTO di aggiornamento
//! ID -> Chiave primaria del modello


public interface CrudService<Read, Create, Update, ID> {
    List<Read> readAll();
    Read readOne(ID id) throws Exception;
    List<Read> read(Map<String, String> params);
    Read create(Create createDTO);
    Read update(Long id, Update createDTO) throws Exception;
    Read delete(ID id) throws Exception;
}
