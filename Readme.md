# 手写spring核心功能

7/10
day01 Bean 容器存取实现核心思想
+ 选定好容器（HashMap）
  + 原因 散列hash（扰动函数,负载因子,自动扩容红黑树） 取的时候速度快

+ 定义  注册  实现
  + 定义 ：需要一个初始化的bean，可以注册进去（BeanDefinition）
  + 注册 ：创建bean工厂，放入选定的容器中 key（name） - value（Object），value就是存入的初始化bean
  + 实现 ：写一个get方法，传入创建时候的key值 获取 bean 

   