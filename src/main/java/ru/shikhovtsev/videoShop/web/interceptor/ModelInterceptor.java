package ru.shikhovtsev.videoShop.web.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import ru.shikhovtsev.videoShop.AuthorizedUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This interceptor adds the user to the model of every requests managed
 */
public class ModelInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null && !modelAndView.isEmpty()) {
            AuthorizedUser authorizedUser = AuthorizedUser.safeGet();
            if (authorizedUser != null) {
                modelAndView.getModelMap().addAttribute("user", authorizedUser.getUser());
            }
        }
    }
}
