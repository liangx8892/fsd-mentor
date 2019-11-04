package com.fsd.sba.service;

import com.fsd.sba.entity.MentorTechnology;
import com.fsd.sba.entity.MentorTechnologyId;
import com.fsd.sba.entity.Technology;
import com.fsd.sba.repository.MentorTechRepository;
import com.fsd.sba.repository.TechnologyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MentorService {
	private static final Logger logger = LoggerFactory.getLogger(MentorService.class);
	
	@Autowired
	private TechnologyRepository techRepository;
	@Autowired
	private MentorTechRepository mentorTechRepository;


	public void addMentorTechnology(MentorTechnology mentorTech) {
		logger.debug("entering addMentorTechnology.");
		MentorTechnologyId id = new MentorTechnologyId(mentorTech.getUserId(), mentorTech.getTechId());
		Optional<MentorTechnology> mentorTechInDB = mentorTechRepository.findById(id);
		if(mentorTechInDB.isPresent()){
			MentorTechnology tech = mentorTechInDB.get();
			tech.setYears(mentorTech.getYears());
			mentorTechRepository.save(tech);
		}else{
			mentorTechRepository.save(mentorTech);
		}

	}

	public void deleteMentorTechnology(MentorTechnologyId id) {
		logger.debug("entering deleteMentorTechnology.");
		mentorTechRepository.deleteById(id);
	}

	@Transactional
	public void deleteMentorTechnologies(Long userId) {
		logger.debug("entering deleteMentorTechnologies.");
		mentorTechRepository.deleteByUserId(userId);
	}
}
