//package support.yz.data.configure;
//import com.sun.istack.internal.Nullable;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//@Slf4j
//public class LoginInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        log.info("==========登录状态拦截");
//        HttpSession session = request.getSession();
//        log.info("sessionId为：" + session.getId());        // 获取用户信息，如果没有用户信息直接返回提示信息
//        Object userInfo = session.getAttribute("user");
//        if (userInfo == null) {
//            log.info("没有登录");
//            response.getWriter().write("{\n" +
//                    "\"code\": \"false\",\n" +
//                    "\"msg\": \"404\",\n" +
//                    "\"data\": false\n" +
//                    "}");
//            return false;
//        } else {
//            log.info("已经登录过啦，用户信息为：" + session.getAttribute("user"));
//        }
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
//
//    }
//}
