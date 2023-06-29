package jspBoard2.sevice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Service {
	
	String service(HttpServletRequest request,
			HttpServletResponse response) throws IOException;
}
