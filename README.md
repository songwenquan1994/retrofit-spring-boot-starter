## retrofit 依赖

```xml
<dependency>
    <groupId>com.sohu.no.retrofit</groupId>
    <artifactId>retrofit-spring-boot-starter</artifactId>
    <version>${retrofit-boot.version}</version>
</dependency>
```

## YAML
baseUrl：norns 的调用地址
```yaml
spring:
  # retrofit
  retrofit:
    connection:
      readTimeout: 10000
      writeTimeout: 10000
      connectTimeout: 10000
      maxIdleConnections: 5 # The maximum number of idle connections for each address.
      keepAliveDuration: 5 # The time (minutes) to live for each idle connections.
      retryTimes: 2
    endpoints:
    - identity: norns
      baseUrl: https://norns.no.sohu.com/
```

      
      
### Configuration配置类   

Configuration 类需要用RetrofitServiceScan 注解说明endpoint的包路径，endpoint借口类用
```java
 @RetrofitService("service") //标注，与yml的identity对应。
 
 @Configuration
 @AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
 @ConditionalOnClass(RetrofitCallAdaptor.class)
 @AutoConfigureAfter(RetrofitAutoConfiguration.class)
 @RetrofitServiceScan("com.sohu.no.doc.endpoint")
```