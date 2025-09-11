package task.battilana.com.services.impl;

import org.springframework.stereotype.Service;
import task.battilana.com.dto.CarpetaRequest;
import task.battilana.com.dto.CarpetaResponse;
import task.battilana.com.mapper.CarpetaMapper;
import task.battilana.com.repository.CarpetasRepository;
import task.battilana.com.services.CarpetasService;

import java.util.List;

@Service
public class CarpetasServiceImpl implements CarpetasService {

    private final CarpetasRepository carpetasRepository;
    private final CarpetaMapper carpetaMapper;

    public CarpetasServiceImpl(CarpetasRepository carpetasRepository, CarpetaMapper carpetaMapper) {
        this.carpetasRepository = carpetasRepository;
        this.carpetaMapper = carpetaMapper;
    }

    @Override
    public List<CarpetaResponse> findAll() {
        return this.carpetaMapper.toListCarpetaResponse(this.carpetasRepository.findAll());
    }

    @Override
    public CarpetaResponse saveCarpetas(CarpetaRequest carpetaRequest) {
        return this.carpetaMapper.toCarpetaResponse(this.carpetasRepository.save(this.carpetaMapper.toCarpetaEntity(carpetaRequest)));
    }
}
