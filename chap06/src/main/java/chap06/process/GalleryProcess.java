package chap06.process;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GalleryProcess implements RequestProcess{
	
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		
		// 이미지 경로들을 DB에서 꺼냈다고 가정한다
		List<String> paths = new ArrayList<>();
		
		paths.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTeW_UmcOSSM5fldymyD1vtZl0Hz6cCVPWC-w&usqp=CAU");
		paths.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRWpol9gKXdfW9lUlFiWuujRUhCQbw9oHVIkQ&usqp=CAU");
		paths.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRX7BDa0z9STmshQwO0VAn9f2nQ9iGVnf7icA&usqp=CAU");
		paths.add(request.getContextPath() + "/resources/img/animal/penguin.jpg");
		paths.add(request.getContextPath() + "/resources/img/animal/bird.jpg");
		paths.add(request.getContextPath() + "/resources/img/animal/frog.png");
		
		request.setAttribute("img_paths", paths);
		
		return "/gallery";
	}
}
