package com.fsd.sba.service;

import com.fsd.sba.entity.MentorTechnology;
import com.fsd.sba.entity.MentorTechnologyId;
import com.fsd.sba.entity.Technology;
import com.fsd.sba.exception.BusinessException;
import com.fsd.sba.repository.MentorTechRepository;
import com.fsd.sba.repository.TechnologyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TechnologyService {
	private static final Logger logger = LoggerFactory.getLogger(TechnologyService.class);
	
	@Autowired
	private TechnologyRepository techRepository;


	public List<Technology> getTechnologies() {
		logger.debug("entering getTechnologies.");
		List<Technology> list = techRepository.findAll();
		logger.debug("returned technology list from db is {}", list);
		return list;
	}
}
