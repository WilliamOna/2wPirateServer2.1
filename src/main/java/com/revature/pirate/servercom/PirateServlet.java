package com.revature.pirate.servercom;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pirate.dao.DatabasePirateDAO;
import com.revature.pirate.dao.FilePirateDAO;
import com.revature.pirate.model.Pirate;

public class PirateServlet extends HttpServlet{
	
	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DatabasePirateDAO pirateRepository = new DatabasePirateDAO();
		String jsonString = objectMapper.writeValueAsString(pirateRepository.getAllPirates());
		resp.getWriter().append(jsonString);
		
		resp.setContentType("application/json"); // This corresponds to MIME type standards
		resp.setStatus(200);
	}
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		BufferedReader reader = req.getReader();
//		
//		StringBuilder sb = new StringBuilder();
//		String line;
//		while ((line = reader.readLine()) != null) {
//			sb.append(line);
//		}
//		
//		String jsonString = sb.toString();
//		
//		try {
//			Pirate pirate = objectMapper.readValue(jsonString, Pirate.class);
//			
//			DatabasePirateDAO pirateRepository = new DatabasePirateDAO();
//			Pirate insertedPirate = pirateRepository.insertPirate(pirate);
//			
//			String insertedPirateJSON = objectMapper.writeValueAsString(insertedPirate);
//			resp.getWriter().append(insertedPirateJSON);
//			
//			resp.setContentType("application/json");
//			resp.setStatus(201);
//		} catch (JsonProcessingException e) {
//			resp.setStatus(400);
//		}
//		
//	}
	
}
