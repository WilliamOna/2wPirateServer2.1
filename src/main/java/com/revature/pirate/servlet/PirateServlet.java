package com.revature.pirate.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pirate.dao.DatabasePirateDAO;
import com.revature.pirate.exception.RoleNotFoundException;
import com.revature.pirate.model.Pirate;
import com.revature.pirate.service.PirateService;
import com.revature.pirate.template.InsertPirateTemplate;

public class PirateServlet extends HttpServlet{
	
	private ObjectMapper objectMapper = new ObjectMapper();
	private PirateService pirateService = new PirateService();
	
	public PirateServlet() {
		super();
	}
	
	public PirateServlet(ObjectMapper objectMapper, PirateService pirateService) {
		this.objectMapper = objectMapper;
		this.pirateService = pirateService;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		String jsonString = objectMapper.writeValueAsString(pirateService.getAllPirates());
		resp.getWriter().append(jsonString);
		
		resp.setContentType("application/json"); // This corresponds to MIME type standards
		resp.setStatus(200);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader reader = req.getReader();
		
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		
		String jsonString = sb.toString();
		
		try {
			// Jackson Databind parsing the jsonString and creating an InsertPirateTemplate object, with that data
			InsertPirateTemplate pirateData = objectMapper.readValue(jsonString, InsertPirateTemplate.class);
			
			Pirate pirate = pirateService.insertPirates(pirateData);
			
			String insertedPirateJSON = objectMapper.writeValueAsString(pirate);
			resp.getWriter().append(insertedPirateJSON);
			
			resp.setContentType("application/json");
			resp.setStatus(201);
		} catch (JsonProcessingException | RoleNotFoundException e) {
			resp.setStatus(400);
		}
		
	}
	
}
