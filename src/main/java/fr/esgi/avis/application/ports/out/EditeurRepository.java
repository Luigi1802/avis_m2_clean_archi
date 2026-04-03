package fr.esgi.avis.application.ports.out;

import fr.esgi.avis.application.dto.out.EditeurDtoOut;import java.util.List;

//Port
public interface EditeurRepository {
    List<EditeurDtoOut> findAll();
}
