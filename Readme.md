# 手写spring核心功能

7/10
day01 Bean 容器存取实现核心思想
+ 选定好容器（HashMap）
  + 原因 散列hash（扰动函数,负载因子,自动扩容红黑树） 取的时候速度快

+ 定义  注册  实现
  + 定义 ：需要一个初始化的bean，可以注册进去（BeanDefinition）
  + 注册 ：创建bean工厂，放入选定的容器中 key（name） - value（Object），value就是存入的初始化bean
  + 实现 ：写一个get方法，传入创建时候的key值 获取 bean 
  
7/10
day02 迭代更新Bean容器 
+ Bean 注册的时候只注册一个类信息，而不会直接把实例化信息注册到 Spring 容器中
  + 把pojo中Bean的类型从object改为class从而内部实例化
+ 使用模板设计模式 AbstractBeanFactory.class
  + 使得扩展性提高，使得让他们都围绕者核心方法进行操作 DefaultSingletonBeanRegistry.class
  + 各个类逐一实现模板中的方法 （单一职责）  
    + AbstractAutowireCapableBeanFactory.class 创建bean 放入容器 
    + DefaultListableBeanFactory.class 获取 bean
 

7/11
day03 解决容器不能生成只能无参构造类的问题
+ 使用策略模式来选择构造有参的类
  + java 原始
  + cglib 

   