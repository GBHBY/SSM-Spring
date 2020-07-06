#动态代理
1.特点：      
- 字节码随用随加载，随用随创建     
     
2.作用：    
- 在不修改源码的基础上对，原来方法的增强    
       
3.分类：    
- 基于接口的动态代理(本项目)       
- 基于子类的动态代理    

```java
Proxy.newProxyInstance(ClassLoader loader,
                        Class<?>[] interfaces,
                        InvocationHandler h)
```   
ClassLoader loader    
- 用于加载代理对象字节码的，写的是被代理对象的类加载器，
和代理对象使用相同的类加载器,代理谁写谁，即：`代理对象.getClass().getClassLoader()`   

 Class<?>[] interfaces   
- 用于让代理对象和被代理对象有相同的方法，代理谁就谁的`代理对象.getClass().getInterfaces()`   

 InvocationHandler h
- 用于提供增强的代码，就是如何代理，我们一般都是写该接口的实现类，
通常情况下都是匿名内部类（但不是必须这样写的）  
 