package chap10.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

// ContextLoaderListener  Context 내부의 내용에 변화가 있는 경우 리로드 할 때 호출되는 이벤트 리스너
public class ContextLoaderListener implements ServletContextListener {
	
	public ContextLoaderListener() {
		System.out.println("ContextLoaderListener: 컨텍스트 내부에 변화가 있었습니다");
		System.out.println("ContextLoaderListener : 다시 초기화 합니다");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ContextLoaderListener: ServletContext Destroyed...");
	}
}
