# 注解AOP
```java

/**
 * 记录日志
 */
@Component("logger")
//表示当前类是一个切面类
@Aspect
public class Logger {
    //    切入点表达式
    @Pointcut("execution(* com.gyb.service.impl.*.*(..))")
    private void piontCutMetod() {
    }

    /**
     * 前置通知
     */
    @Before("piontCutMetod()")
    public void beforePrintLog() {
        System.out.println("前置");
    }

    /**
     * 后置通知
     */
    @AfterReturning("piontCutMetod()")
    public void afterPrintLog() {
        System.out.println("后置");
    }

    /**
     * 环绕通知
     */
    //@Around("piontCutMetod()")
    public Object aroundPrintLog(ProceedingJoinPoint proceedingJoinPoint) {
        Object object = null;
        try {
            //调用方法所需要的参数
            Object[] o = proceedingJoinPoint.getArgs();
//            写在proceed之前就是前置通知，写在proceed之后就是后置通知，写在catch就是异常，写在finally中就是最终
            System.out.println("环绕-前置");
            object = proceedingJoinPoint.proceed(o);
            int i = 1 / 0;
            System.out.println("环绕-后置");
        } catch (Throwable throwable) {
            System.out.println("环绕-异常");
            throwable.printStackTrace();
        } finally {
            System.out.println("环绕-最终");
        }

        return object;
    }

    /**
     * 异常通知
     */
    @AfterThrowing("piontCutMetod()")
    public void exceptionPrintLog() {
        System.out.println("异常");
    }

    /**
     * 最终通知
     */
    @After("piontCutMetod()")
    public void finnalyPrintLog() {
        System.out.println("最终");
    }
}

```