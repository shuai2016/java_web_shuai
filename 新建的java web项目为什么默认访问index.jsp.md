新建的java web项目为什么默认访问index.jsp

```java
1 org.apache.catalina.deploy.WebXml

public void configureContext(Context context)

i$ = this.servletMappings.entrySet().iterator();

while(i$.hasNext()) {
    entry = (Entry)i$.next();
    context.addServletMapping((String)entry.getKey(), (String)entry.getValue());
}

2 org.apache.catalina.core.StandardContext

public void addServletMapping(String pattern, String name) {
    this.addServletMapping(pattern, name, false);
}

3 org.apache.tomcat.util.http.mapper.Mapper

public void addWrapper(String path, Object wrapper, boolean jspWildCard, boolean resourceOnly) {
    this.addWrapper(this.context, path, wrapper, jspWildCard, resourceOnly);
}
    
protected void addWrapper(Mapper.ContextVersion context, String path, Object wrapper, boolean jspWildCard, boolean resourceOnly)
```

