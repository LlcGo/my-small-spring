# 手写spring核心功能

7/10
day01 Bean 容器存取实现核心思想
+ 选定好容器（HashMap）
  + 原因 散列hash（扰动函数,负载因子,自动扩容红黑树） 取的时候速度快

+ 定义  注册  实现
  + 定义 ：需要一个初始化的bean，可以注册进去（BeanDefinition）
  + 注册 ：创建bean工厂，放入选定的容器中 key（name） - value（Object），value就是存入的初始化bean
  + 实现 ：写一个get方法，传入创建时候的key值 获取 bean 
  
7/10 一。 也就是bean生命周期的实例化阶段！！！ 原本的spring还添加了实例化前和实例化后的方法
day02 迭代更新Bean容器  
+ Bean 注册的时候只注册一个类信息，而不会直接把实例化信息注册到 Spring 容器中
  + 把pojo中Bean的类型从object改为class从而内部实例化
+ 使用模板设计模式 AbstractBeanFactory.class
  + 使得扩展性提高，使得让他们都围绕者核心方法进行操作 DefaultSingletonBeanRegistry.class
  + 各个类逐一实现模板中的方法 （单一职责）  
    + AbstractAutowireCapableBeanFactory.class 创建bean 放入容器 
    + DefaultListableBeanFactory.class 获取 bean
 
7/11
day03 增加容器内部生成构造器   
+ 使用策略模式来选择构造有参的类 
  + java 原始
  + cglib 

7/13 二：属性赋值阶段！！！！
day04 解决类的属性注入问题     
 + 建立一个属性类pojo ，可能有多个属性类，在添加一个存储多个pojo的类，并且设置添加
 + 判断是否是对象类型注入，需要设置一个类来判断 BeanReference 

7/14
day5 将所有注入的信息设置到配置中
1.如何读取文件？
+ 用户肯定会向应用里面放入文件的路径位置等等，所以先定义一个接口可以根据文件的路径获取流，同样实现这个接口还可以用其他的方式来获取流例如直接传入文件，或者直接传入
  路径
+ 接下来有了这个获取流的方法之后，我们就需要使用这个流，根据输入不一样的信息来获取不一样的流的方法，我们先定义一个获取流的接口，之后我们实现这个接口里面实现父类要获得具体资源的接口
  根据用户传入的信息来判断创建出上面的哪个流
2.接下来如何用上面的方法来读取bean信息？
+ 先定义一个初始化读取bean信息的接口 BeanDefinitionReader 里面写上如下几个几口
  + 首先你肯定要有文件，所以可以多建立几个接口读取不一样的文件并且进行解析
  + 其次，你还要一些 注册的数据信息 所以要加一个 获取的接口 ，还要加一个获取 资源解析器 
  + 接下来用一个抽象类实现里面的获取资源和注册信息的方法
  + 最后用一个类继承这个抽象类来实现最后的解析方法
  
7/15 三 初始化bean之前执行的方法和初始化之后执行的方法！！！！ 总体为初始化
day6 
1.使用上下文来创建bean(直接一类拥有，配置文件和创建工厂的功能)  
+ 新建一个能够直接构造的时候就可以驱动所有流程的类（上下文ClassPathXmlApplicationContext）
  + 真正实现这个集合起来的类是AbstractApplicationContext 他实现了beanFactory 和 DefaultResourceLoader
2.怎么加接口可以是的用户在构造bean赋值前和赋值后做一些扩展的  
  + 定义BeanPostProcessor和BeanPostProcessor俩个接口里面写上赋值的方法
  + 之后在 AbstractApplicationContext 的 refresh() 获取bean工厂之后执行俩个方法
  
7/17   四 再初始化的内部再加入 1.InitializingBean 和 2.init—method  并且定义最后一步销毁的方法
day08 添加bean初始化时候调用的方法 和 销毁 时候的方法
+ 初始化方法在 createbean的方法里面最后一步放入
  新增初始化时候的接口 
+ 销毁的方法在 上下文类 的最后一步执行 也就是 调用Runtime.getRuntime().addShutdownHook(new Thread(this::close))虚拟机关闭的时候方法   
  新增销毁的接口 
1.如何做到一个类实现这个接口之后就能够执行？
  在初始化的时候加入一个方法里面判断是否 属于这个接口的类如果属于就执行这个里面的方法
  销毁的时候也是同理判断这个类是否是 属于这个接口
  
 
7/20 
day07  
只需要实现特定的Aware接口就可以获得bean初始化中的一些值，并且做一些操作
+ 创建这几个接口，然后在初始化的时候根据instanceof判断来执行添加到哪个信息
+ 要获得 上下文的话需要在实例化的时候先添加进去

7/23
day09
根据xml的scope来创建 是否为单例的对象
+ 主要是在创建bean的时候判断的时候根据已经读取的scope值来确定是否为单例模式，如果是那就添加到hashmap内存中不是就直接返回一个新的对象

day10
创建监听器监听spring的各种生命周期
+ 实现EventObject接口实现监听

day11
Aop代理