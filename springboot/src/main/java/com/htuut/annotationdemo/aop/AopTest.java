package com.htuut.annotationdemo.aop;

import com.htuut.annotationdemo.annotation.DoSomething;
import com.htuut.annotationdemo.el.SpELParser;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class AopTest {

    /**
     * @Around("@annotation(com.htuut.annotationdemo.annotation.DoSomething)")
     */
    @Around("@annotation(dst)")
    public void around(ProceedingJoinPoint point, DoSomething dst) throws Throwable {

        String key = dst.key();
        String id = getId(key, point);
        System.out.println("==========id"+id);

        //执行
        point.proceed();
    }


    private String getId(String id, ProceedingJoinPoint point) {

        //获得当前 Method
        Signature signature = point.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        //获得形参的名字（反射是拿不到形参的名字的）
        String[] parameterNames = new LocalVariableTableParameterNameDiscoverer().getParameterNames(method);


        String key = SpELParser.getKey(id, parameterNames, point.getArgs());

        return key;
    }


}
