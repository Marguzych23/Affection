//package ru.itis.affection.controllers;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//
//@ControllerAdvice
//public class ExceptionHandlerController {
//
//    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Some exception text")
//    @ExceptionHandler()
//    public void standard() {}
//
//    @ExceptionHandler()
//    public String simpleView() {
//        return "staticExceptionView";
//    }
//
//    @ExceptionHandler()
//    public ModelAndView informedView(HttpServletRequest req, Exception exception) {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", exception);
//        mav.addObject("url", req.getRequestURL());
//        mav.setViewName("exceptions/exceptionWithInfo");
//        return mav;
//    }
//
//}
