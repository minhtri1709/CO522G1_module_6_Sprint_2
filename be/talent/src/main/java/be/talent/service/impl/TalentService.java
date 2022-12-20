package be.talent.service.impl;

import be.talent.dto.ITalentDto;
import be.talent.repository.ITalentRepository;
import be.talent.service.ITalentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TalentService implements ITalentService {
    @Autowired
    private ITalentRepository iTalentRepository;

    @Override
    public Page<ITalentDto> showList(String name,Pageable pageable) {
        return iTalentRepository.showListTalent(name,pageable);
    }
}
