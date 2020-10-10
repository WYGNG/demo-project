package net.xdclass.demoproject.handler;

import net.xdclass.demoproject.utils.JsonData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * tag this is a class of exception
 */
//@RestControllerAdvice //return json data
@ControllerAdvice //return error page
public class CustomExtHandler {
    //max exception level,get the global exception
//    @ExceptionHandler(value = Exception.class)
//    JsonData handlerException(Exception e, HttpServletRequest request){
//        return JsonData.buildError("server problem", -2);
//    }
//        return JsonData.buildError("server problem", -2);

    @ExceptionHandler(value = Exception.class)
    Object handlerException(Exception e, HttpServletRequest request){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error.html");
        System.out.println(e.getMessage());
        modelAndView.addObject("msg", e.getMessage());

        return modelAndView;
    }


}
