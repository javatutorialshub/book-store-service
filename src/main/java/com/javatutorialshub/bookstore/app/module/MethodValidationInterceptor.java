package com.javatutorialshub.bookstore.app.module;

import com.javatutorialshub.bookstore.core.validator.MethodParametersValidator;
import com.javatutorialshub.bookstore.core.validator.MethodResultValidator;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MethodValidationInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        MethodParametersValidator methodParametersValidator = new MethodParametersValidator();
        methodParametersValidator.validate(methodInvocation.getThis(), methodInvocation.getMethod(), methodInvocation.getArguments());

        MethodResultValidator methodResultValidator = new MethodResultValidator();
        Object result = methodInvocation.proceed();
        methodResultValidator.validate(methodInvocation.getThis(), methodInvocation.getMethod(), result);

        return result;
    }
}
