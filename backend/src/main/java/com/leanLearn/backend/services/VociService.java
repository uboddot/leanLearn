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
        voci.setOriginalLanguage(entity.originalLanguage());
        voci.setTranslationLanguage(entity.translationLanguage());
        Voci savedVoci = vociRepository.save(voci);
        return savedVoci;
    }

    public VociKasten getVociKasten(Voci voci) {
        return voci.getVociKastenId() != null ? vociKastenRepository.findById(voci.getVociKastenId()).orElse(null)
                : null;
    }

    public void bumpWord(String id) {
        Voci voci = vociRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Word not found"));
        int currentKastenLevel = voci.getVociKastenId() != null
                ? vociKastenRepository.findById(voci.getVociKastenId()).map(VociKasten::getLevel).orElse(0)
                : 0;
        vociKastenRepository.findByLevel(currentKastenLevel + 1).ifPresent(nextKasten -> {
            voci.setVociKastenId(nextKasten.getId());
        });
        vociRepository.save(voci);
    }

    public void resetWord(String id) {
        Voci voci = vociRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Word not found"));
        voci.setVociKastenId(vociKastenRepository.findFirstByOrderByLevelAsc()
                .orElseThrow(() -> new IllegalArgumentException("No VociKasten found")).getId());
        vociRepository.save(voci);
    }
}
