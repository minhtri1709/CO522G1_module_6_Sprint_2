package be.talent.controller;

import be.talent.dto.ITalentDto;
import be.talent.service.ITalentService;
import be.talent.service.ITalentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/talent")
@CrossOrigin("*")
public class TalentController {
    @Autowired
    private ITalentService iTalentService;

    @Autowired
    private ITalentTypeService iTalentTypeService;

    @GetMapping("")
    public ResponseEntity<Page<ITalentDto>> showListTalent(@PageableDefault Pageable pageable,
                                                           @RequestParam("nameS") String nameS) {
        Page<ITalentDto> talentList = iTalentService.showList(nameS, pageable);
        System.out.println(nameS);
        return new ResponseEntity<>(talentList, HttpStatus.OK);
    }


}
