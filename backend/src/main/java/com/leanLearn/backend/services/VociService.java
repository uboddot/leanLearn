package com.leanLearn.backend.services;

import com.leanLearn.backend.model.VociKasten;
import java.util.List;

import org.springframework.stereotype.Service;

import com.leanLearn.backend.model.Voci;
import com.leanLearn.backend.model.VociRequest;
import com.leanLearn.backend.repository.VociRepository;
import com.leanLearn.backend.repository.VociKastenRepository;

@Service
public class VociService {

    private final VociRepository vociRepository;
    private final VociKastenRepository vociKastenRepository;

    public VociService(VociRepository vociRepository, VociKastenRepository vociKastenRepository) {
        this.vociRepository = vociRepository;
        this.vociKastenRepository = vociKastenRepository;
    }

    public List<Voci> getAllWords() {
        return vociRepository.findAll();
    }

    public Voci addWord(VociRequest entity) {
        Voci voci = new Voci();
        voci.setOriginal(entity.original());
        voci.setTranslation(entity.translation());
        Voci savedVoci = vociRepository.save(voci);
        return savedVoci;
    }

    public VociKasten getVociKasten(Voci voci) {
        return voci.getVociKastenId() != null ? vociKastenRepository.findById(voci.getVociKastenId()).orElse(null)
                : null;
    }
}
