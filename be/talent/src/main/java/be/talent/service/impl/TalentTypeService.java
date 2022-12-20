package be.talent.service.impl;

import be.talent.model.TalentType;
import be.talent.repository.ITalentTypeRepository;
import be.talent.service.ITalentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TalentTypeService implements ITalentTypeService {
    @Autowired
    private ITalentTypeRepository iTalentTypeRepository;


    @Override
    public List<TalentType> getListType() {
        return iTalentTypeRepository.findAll();
    }
}
