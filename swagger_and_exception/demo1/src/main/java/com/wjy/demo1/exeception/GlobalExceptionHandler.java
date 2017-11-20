package com.wjy.demo1.exeception;

import com.wjy.demo1.vo.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by apple on 2017/7/22.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW="geh";
/***
 * 无法使用试图解析器
    @ExceptionHandler(value=Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request,Exception e) throws Exception{
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception",e);
        mav.addObject("url",request.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }
***/
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void processMethod(MissingServletRequestParameterException ex,HttpServletRequest request ,HttpServletResponse response) throws IOException {
        System.out.println("抛异常了！"+ex.getLocalizedMessage());
        response.getWriter().printf(ex.getMessage());
        response.flushBuffer();
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public BaseResponse nullPointException(NullPointerException e,HttpServletRequest request, HttpServletResponse response){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(1);
        baseResponse.setMsg(e.getMessage());
        Date date = new Date();
        baseResponse.setData(date);
        return baseResponse;
    }

    //抛出的new Exception被传到方法中的Exception ex 所以 如果在controller的new Exception()为空 那么这里的ex.getLocalizedMessage就是空了
    //但是这里Exception ex有没有都可以
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void exceptionMethod(Exception ex,HttpServletRequest request ,HttpServletResponse response) throws IOException {
        System.out.println("抛异常了！"+ex.getLocalizedMessage());
        response.getWriter().printf("error");
        response.flushBuffer();
    }
}
