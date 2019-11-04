package com.fsd.sba.controller;

import com.fsd.sba.entity.MentorTechnology;
import com.fsd.sba.entity.MentorTechnologyId;
import com.fsd.sba.entity.Technology;
import com.fsd.sba.model.HttpResponse;
import com.fsd.sba.service.MentorService;
import com.fsd.sba.service.TechnologyService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Api(description = "Mentor Service")
public class MentorController {
	private static final Logger logger = LoggerFactory.getLogger(MentorController.class);

	@Autowired
	private TechnologyService technologyService;
	@Autowired
	private MentorService mentorService;

	/**
	 * Interface to get all technologies, Go through Zuul gateway, and should bypass authentication.
	 * @param
	 * @return
	 */
	@GetMapping(value = "/technologies", produces = "application/json")
	@ApiOperation(value = "Get all technologies information")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "No Authroization"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Error") })
	public ResponseEntity<HttpResponse<List<Technology>>> getTechnologies() {
		try {
			logger.debug("entering getTechnologies of Mentor service.");
			HttpResponse<List<Technology>> response =
						new HttpResponse(HttpStatus.OK.value(), technologyService.getTechnologies());
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception ex) {
			HttpResponse response = new HttpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Interface for mentor to add specific technology, Go through Zuul gateway, should be authenticated.
	 * @param mentorTech
	 * @return
	 */
	@PostMapping(value = "/addMentorTechnology", produces = "application/json")
	@ApiOperation(value = "Mentor adds specific technology")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "No Authroization"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Error") })
	public ResponseEntity<HttpResponse> addMentorTechnology(
				@ApiParam(name = "body", required = true) @RequestBody MentorTechnology mentorTech
	) {
		try {
			logger.debug("entering addMentorTechnology of Mentor service. param mentorTech is {}", mentorTech);
			mentorService.addMentorTechnology(mentorTech);
			HttpResponse response = new HttpResponse(HttpStatus.OK.value());
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception ex) {
			HttpResponse response = new HttpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Interface for mentor to delete specific technology, Go through Zuul gateway, should be authenticated.
	 * @param mentorTechId
	 * @return
	 */
	@DeleteMapping(value = "/deleteMentorTechnology", produces = "application/json")
	@ApiOperation(value = "Mentor adds specific technology")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "No Authroization"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Error") })
	public ResponseEntity<HttpResponse> deleteMentorTechnology(
			@ApiParam(name = "body", required = true) @RequestBody MentorTechnologyId mentorTechId
	) {
		try {
			logger.debug("entering deleteMentorTechnology of Mentor service. param mentorTechId is {}", mentorTechId);
			mentorService.deleteMentorTechnology(mentorTechId);
			HttpResponse response = new HttpResponse(HttpStatus.OK.value());
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception ex) {
			HttpResponse response = new HttpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Interface for mentor to delete all their own technologies, Go through Zuul gateway, should be authenticated.
	 * @param userId
	 * @return
	 */
	@DeleteMapping(value = "/deleteMentorTechnologies", produces = "application/json")
	@ApiOperation(value = "Mentor adds specific technology")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "No Authroization"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Error") })
	public ResponseEntity<HttpResponse> deleteMentorTechnologies(
			@RequestParam(value = "userId", required = true) String userId
	) {
		try {
			logger.debug("entering deleteMentorTechnologies of Mentor service. param userId is {}", userId);
			mentorService.deleteMentorTechnologies(Long.valueOf(userId));
			HttpResponse response = new HttpResponse(HttpStatus.OK.value());
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception ex) {
			HttpResponse response = new HttpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Internal interface for getting specific mentor's technologies, and should bypass authentication.
	 * @param
	 * @return
	 */
	@GetMapping(value = "/getMentorTechnologies", produces = "application/json")
	@ApiOperation(value = "Get all technologies information")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "No Authroization"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Error") })
	public ResponseEntity<HttpResponse<List<Technology>>> getTechnologies(
			@RequestParam(value = "userId", required = true) String userId) {
		try {
			logger.debug("entering getMentorTechnologies of Mentor service.");
			HttpResponse<List<Technology>> response =
					new HttpResponse(HttpStatus.OK.value(), technologyService.getTechnologies());
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception ex) {
			HttpResponse response = new HttpResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
