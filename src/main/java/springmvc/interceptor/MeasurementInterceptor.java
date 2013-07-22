package springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MeasurementInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		    throws Exception {
			long startTime = System.currentTimeMillis();
			System.out.println("StartTime: " + startTime);
			request.setAttribute("startTime", startTime);
			return true;
		}
	
	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
			long startTime = (Long)request.getAttribute("startTime");
			long endTime = System.currentTimeMillis();
			System.out.println("EndTime in: " + endTime);
			modelAndView.addObject("handlingTime", (endTime-startTime)*1000);	
	}

}
