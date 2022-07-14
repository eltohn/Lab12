package miu.lab10.service.impl;

import miu.lab10.model.Transcript;
import miu.lab10.repository.TranscriptRepository;
import miu.lab10.service.TranscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranscriptServiceImpl implements TranscriptService {

    @Autowired
    private TranscriptRepository transcriptRepository;

    @Override
    public Transcript save(Transcript t) {
        return transcriptRepository.save(t);
    }
}
