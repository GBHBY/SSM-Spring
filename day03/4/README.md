# AOP

- 切入点配置   
    - 具体看bean.xml，但是要注意一点，异常和后置通知只能存在一个，
    异常通知只有在出现异常的时候才能起作用
   - 环绕通知
        - 当配置了环绕通知，切入点（也就是增强的方法）没有执行，但是环绕却执行了
            - 原因：没有切入点方法调用，我们可以使用`ProceedingJionPiont`    即：    
            
               ![image-20200705125122004](C:\Users\asus\AppData\Roaming\Typora\typora-user-images\image-20200705125122004.png)
            
            - 环绕通知也就是spring为我们提供在代码中来增强方法的一种方式，我们不必局限于xml配置
        
