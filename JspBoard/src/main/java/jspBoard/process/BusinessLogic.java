package jspBoard.process;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 비지니스 로직 - 요청을 받으면 해줘야하는 처리는 어떤 사업이냐에 따라 달라지므로 비지니스 로직이라고 할 수 있다
//			   서비스(Service)라고 부르기도 한다
public interface BusinessLogic {	
	// 1. 모든 Http 요청 처리는 request와 response를 받아 진행되며
	// 2. 모든 처리의 결과는 다음으로 가야할 forward 또는 redirect를 알 수 있다
	String process(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
