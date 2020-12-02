package com.revature.pirate.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StaticResourceServlet extends HttpServlet {

	public StaticResourceServlet() {
		super();
	}
	
	@Override
//	If our endpoint that led us here is defined as http://localhost:8080/PirateServer
//	forward("static/index.html") would extend upon that when passing onto another Servlet
//	http://localhost:8080/PirateServer/static/index.html
//	The response will then be sent from the Servlet we forwarded to back to the user
//	include would do the same, but instead return the response back to this servlet first
//	and then this Servlet will send the response back to the user
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getRequestURI());
		String resource = req.getRequestURI().replace("/PirateServer", "");
		if (resource != null) {
			switch(resource) {
				case "/":
					System.out.println("invoked forwarding of index.html");
					req.getRequestDispatcher("static/index.html").include(req, resp);
					
					resp.setContentType("text/html");
					resp.setStatus(200);
					
//					Hey tomcat, forward our request and response object to this other endpoint 
//					http://localhost:8080/PirateServer/index.html
//					In this case, we're forwarding this endpoint to the default servlet, which will then process our .html file
//					and send the response contents to our browser
					break;
				case "/pirate-list":
					System.out.println("invoked forwarding of pirate-list.html");
					req.getRequestDispatcher("/static/pirate-list.html").include(req, resp);
					
					resp.setContentType("text/html");
					resp.setStatus(200);
					break;
				case "/pirate-form":
					System.out.println("invoked forwarding of pirate-form.html");
					req.getRequestDispatcher("/static/pirate-form.html").include(req, resp);
					
					resp.setContentType("text/html");
					resp.setStatus(200);
					break;
				case "/styles/pirate-1":
					System.out.println("invoked forwarding of styles.css");
					req.getRequestDispatcher("/static/css/styles.css").include(req, resp);
					
					resp.setContentType("text/css");
					resp.setStatus(200);
					break;
				case "/js/pirate-list":
					System.out.println("invoked forwarding of pirate-list.js");
					req.getRequestDispatcher("/static/js/pirate-list.js").include(req, resp);
					
					resp.setContentType("text/javascript");
					resp.setStatus(200);
					break;
				case "/js/pirate-form":
					System.out.println("invoked forwarding of pirate-form.js");
					req.getRequestDispatcher("/static/js/pirate-form.js").include(req, resp);
					
					resp.setContentType("text/javascript");
					resp.setStatus(200);
					break;
				case "/img/pirate-ship.jpg":
					System.out.println("invoked forwarding of pirate-ship.jpg");
					req.getRequestDispatcher("/static/img/pirate-ship.jpg").include(req, resp);
					
					resp.setContentType("image/jpeg");
					resp.setStatus(200);
					break;
				default:
					resp.setStatus(404);
			}
		} else {
			resp.setStatus(404);
		}
	}

}
