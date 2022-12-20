package be.talent.service;

import be.talent.dto.ITalentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITalentService {
    Page<ITalentDto> showList(String name,Pageable pageable);
}
