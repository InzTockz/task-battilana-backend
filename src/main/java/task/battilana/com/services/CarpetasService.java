package task.battilana.com.services;

import task.battilana.com.dto.CarpetaRequest;
import task.battilana.com.dto.CarpetaResponse;

import java.util.List;

public interface CarpetasService {

    List<CarpetaResponse> findAll();
    CarpetaResponse saveCarpetas(CarpetaRequest carpetaRequest);

}
