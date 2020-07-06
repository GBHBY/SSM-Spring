#AOP基础-动态代理
1.获取连接会在应用加载一开始，在web应用中，tomcat会在启动加载应用时，就会获取链接，在项目运行时，不会再次获取        
2.我们使用tomcat，tomcat有一个线程池，我们每次获取链接都是去线程池中获取，    


```java
//这个close方法不是真正的关闭连接，而是把还回连接池中
   public void release() {
        try {
            connectionUtils.getLocalConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
```