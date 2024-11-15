package com.github.bruce_mig.aspect_oriented_programming.aspect;


import org.aspectj.lang.annotation.Pointcut;

public class CommonPointCuts {

    /**
     * A join point is in the web layer if the method is defined
     * in a type in the com.github.bruce_mig.aspect_oriented_programming.controller package or any sub-package
     * under that.
     */
    /*@Pointcut("within(com.github.bruce_mig.aspect_oriented_programming.controller..*)")
    public void inWebLayer() {}
*/
    /**
     * A join point is in the service layer if the method is defined
     * in a type in the com.github.bruce_mig.aspect_oriented_programming.service package or any sub-package
     * under that.
     */
    /*@Pointcut("execution(* com.github.bruce_mig.aspect_oriented_programming.service..*.*(..))")
    public void inServiceLayer() {}*/

    /**
     * A join point is in the data access layer if the method is defined
     * in a type in the com.github.bruce_mig.aspect_oriented_programming.model package or any sub-package
     * under that.
     */
    /*@Pointcut("within(com.github.bruce_mig.aspect_oriented_programming.model..*)")
    public void inDataAccessLayer() {}*/


    @Pointcut("execution(* com.github.bruce_mig.aspect_oriented_programming.service.UserService.*(..))")
    public void methodsInServiceInterface() {}

    @Pointcut("execution(* com.github.bruce_mig.aspect_oriented_programming.controller.UserController.*(..))")
    public void methodsInUserController() {}

    /**
     * A data access operation is the execution of any method defined on a
     * DAO interface. This definition assumes that interfaces are placed in the
     * "dao" package, and that implementation types are in sub-packages.
     */
/*    @Pointcut("execution(* com.xyz.dao.*.*(..))")
    public void dataAccessOperation() {}*/

     /**
     * Pointcut for sensitive createUser method in UserService
      */
/*    @Pointcut("execution(* com.github.bruce_mig.aspect_oriented_programming.service.UserService.createUser(..))")
    public void sensitiveCreateUserMethod() {}*/

    /**
     * Pointcut excluding the sensitive service method
    */
    @Pointcut("methodsInServiceInterface() && !sensitiveMethod()")
    public void serviceLayerExcludingSensitive() {}

    /**
     * Pointcut excluding the sensitive method
     */
    @Pointcut("methodsInServiceInterface() && !sensitiveMethod()")
    public void webLayerExcludingSensitive() {}

    /**
     *  Pointcut for methods annotated with @SensitiveMethod
     */
    @Pointcut("@annotation(com.github.bruce_mig.aspect_oriented_programming.annotations.SensitiveMethod)")
    public void sensitiveMethod() {}
}