package com.revature.pirate.servercom;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pirate.model.Pirate;
import com.revature.pirate.repository.PirateRepository;

public class GetAllPirateServlet extends HttpServlet{
	
	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PirateRepository pirateRepository = new PirateRepository();
		String jsonString = objectMapper.writeValueAsString(pirateRepository.readFile());
		resp.getWriter().append(jsonString);
	}
	
}
