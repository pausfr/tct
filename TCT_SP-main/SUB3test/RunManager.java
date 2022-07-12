package com.lgcns.test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.servlet.ServletHandler;


//HTTP 서버 구동(ex. "http://127.0.0.1:8080/")
public class RunManager {

	public static void main(String[] args) throws Exception{
		new RunManager().start();

	}
	
	public void start() throws Exception {
		
		
		Server server = new Server();
		ServerConnector http = new ServerConnector(server);
		http.setHost("127.0.0.1");
		http.setPort(8080);
		server.addConnector(http);

		ServletHandler servletHandler = new ServletHandler();
		servletHandler.addServletWithMapping(MyServlet.class, "/mypath");
		server.setHandler(servletHandler);
		HttpClient httpClient = new HttpClient();
		httpClient.start();
		server.start();

		System.out.println("start");
		ContentResponse contentRes = httpClient.newRequest("http://127.0.0.1:8080/mypath").method(HttpMethod.GET)
				.send();
		System.out.println(contentRes.getContentAsString());
		
		
		
    	String s;
        try {
            Process oProcess = new ProcessBuilder("MOCK.exe").start();
            
            // read external program OUT, ERR
            BufferedReader stdOut = new BufferedReader(new InputStreamReader(oProcess.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(oProcess.getErrorStream()));
            
            while((s = stdOut.readLine())!=null) System.out.println(s);
            while((s = stdError.readLine())!=null) System.out.println(s);
            
            System.out.println("Exit Code: " + oProcess.exitValue());
            System.exit(oProcess.exitValue());
        }
        catch(IOException e){
            System.err.println("Error! Fail to run external program!");
            System.exit(-1);
        }
		
		server.join();
		
		
		
		
	}

}



// 
