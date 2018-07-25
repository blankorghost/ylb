# ylb
Spring注解+Hibernate实现的博客网站
1.	在Action类中添加注解，实现Struts2的注解开发（@NameSpace、@ParentPackage、@Action...）；
2.	在Spring 配置文件中注册组件扫描的基本包<context:component-scan base-package=" "/>，在Dao层、Service层和Action层中注解组件和依赖注入；
3.	在 Spring 配置文件中开启 Spring 事务注解驱动tx:annotation-driventransaction-manager="transactionManager"/，使用 Spring 的事务注解管理事务。
4.	删除Hibernate映射文件，在实体类中以注解的方式表明映射关系，并在 Spring 配置文件的 SessionFactory 定义中，删除映射文件的相关配置mappingResources，添加实体包扫描器packagesToScan。
