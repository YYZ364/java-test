# 一、什么是Spring框架

> ​		Spring 是一款开源的轻量级 Java 开发框架，Spring 框架指的都是 Spring Framework，它是很多模块的集合，使用这些模块可以很方便地协助我们进行开发，比如说 Spring 支持 IoC（Inversion of Control:控制反转） 和 AOP(Aspect-Oriented Programming:面向切面编程)、可以很方便地对数据库进行访问、可以很方便地集成第三方组件（电子邮件，任务，调度，缓存等等）、对单元测试支持比较好、支持 RESTful Java 应用程序的开发。

## Spring4 主要模块

​		<img src="D:\files\assets\image-20230821165901419.png" alt="image-20230821165901419" style="zoom: 80%;" />

> **spring-aop**
>
> ​		面向切面编程时使用。Spring通过"横切"的方式将贯穿于多业务中的公共功能独立抽取出来，形成单独的切面，并指定切面的具体动作，在需要使用该功能时，动态地将该功能切入到需要的地方。
>
> **spring-aspects**
>
> ​		用来实现AspectJ框架的集成。而AspectJ是一个通过对java扩展出之后的框架，框架里面定义了AOP的语法，通过特殊的编译器完成编译期间的代码织入，最后生成增强之后的Class文件。
>
> **spring-instrument**
>
> ​		实现Spring对服务器的代理接口功能实现，实现的是类级别或者ClassLoader级别的代理功能。
>
> **spring-beans**
>
> ​		完成Spring框架的基本功能，里面定义了大量和Bean有关的接口，类及注解，提供对 bean 的创建、配置和管理等功能的支持。例如：bean定义的顶层接口BeanDefinition、bean装配相关的注解Autowired/Qualifier/Value、用来创建bean的工厂接口BeanFactory及一些具体的工厂方法等。
>
> **spring-context**
>
> ​		用来实现Spring上下文功能，及Spring的IOC，例如初始化Spring容器时所使用的ApplicationContext接口及常用的抽象实现类AnnotationConfigApplicatoinContext或者ClasspathXmlApplicationContext等。
>
> **spring-core**
>
> ​		Spring的核心功能实现，例如：控制反转(IOC)、依赖注入(DI)、asm以及cglib的实现。
>
> **spring-expression**
>
> ​		提供Spring表达式语言的支持，SPEL。
>
> **spring-jdbc**
>
> ​		Spring对JDBC(Java Data Base Connector)功能的支持，里面定义了用于操作数据的多种API，常用的即：**JdbcTemplate**，通过模板设计模式将数据库的操作和具体业务分离，降低了数据库操作和业务功能的耦合。提供了对数据库访问的抽象 JDBC。不同的数据库都有自己独立的 API 用于操作数据库，而 Java 程序只需要和 JDBC API 交互，这样就屏蔽了数据库的影响。
>
> **spring-transaction**
>
> ​		提供对事务的支持。
>
> **spring-orm**
>
> ​		提供对 Hibernate、JPA、iBatis 等 ORM 框架的支持
>
> **spring-oxm**
>
> ​		提供一个抽象层支撑 OXM(Object-to-XML-Mapping)，例如：JAXB、Castor、XMLBeans、JiBX 和 XStream 等。
>
> **spring-jms**
>
> 消息服务。自 Spring Framework 4.1 以后，它还提供了对 spring-messaging 模块的继承。
>
> **spring-web**
>
> ​		用来支持Web系统的功能。例如：文件上传，与JSF的集成，过滤器Filter的支持等。
>
> **spring-webmvc**
>
> ​		用来支持SpringMVC的功能，包括了和SpringMVC框架相关的所有类或者接口，例如常用的DispatcherServlet、ModelAndView、HandlerAdaptor等。另外提供了支持国际化、标签、主题、FreeMarker、Velocity、XSLT的相关类。注意：如果使用了其他类似于smart-framework的独立MVC框架，则不需要使用该模块中的任何类。
>
> **spring-websocket**
>
> ​		Spring对websocket的简单封装，提供了及时通信的功能，常用于一些即时通讯功能的开发。
>
> **spring-test**
>
> ​		Spring对Junit测试框架的简单封装，用来快速构建应用的单元测试功能及Mock测试。

<img src="D:\files\assets\image-20230821170052364.png" alt="image-20230821170052364" style="zoom:67%;" />



# 二、Spring、SpringMVC、SpringBoot之间的关系

> ​		Spring 是一款开源的轻量级 Java 开发框架，Spring 框架指的都是 Spring Framework，它是很多模块的集合，使用这些模块可以很方便地协助我们进行开发，比如说 Spring 支持 IoC（Inversion of Control:控制反转） 和 AOP(Aspect-Oriented Programming:面向切面编程)、可以很方便地对数据库进行访问、可以很方便地集成第三方组件（电子邮件，任务，调度，缓存等等）、对单元测试支持比较好、支持 RESTful Java 应用程序的开发。
>
> ​		Spring 包含了多个功能模块，其中最重要的是 Spring-Core（主要提供 IoC 依赖注入功能的支持） 模块， Spring 中的其他模块（比如 Spring MVC）的功能实现基本都需要依赖于该模块。
>
> ​		Spring MVC 是 Spring 中的一个很重要的模块，主要赋予 Spring 快速构建 MVC 架构的 Web 程序的能力。MVC 是模型(Model)、视图(View)、控制器(Controller)的简写，其核心思想是通过将业务逻辑、数据、显示分离来组织代码。
>
> <img src="D:\files\assets\image-20230822144138319.png" alt="image-20230822144138319" style="zoom:67%;" />
>
> ​		使用 Spring 进行开发各种配置过于麻烦比如开启某些 Spring 特性时，需要用 XML 或 Java 进行显式配置。于是，Spring Boot 诞生了！
>
> Spring 旨在简化 J2EE 企业应用程序开发。Spring Boot 旨在简化 Spring 开发（减少配置文件，开箱即用！）。
>
> Spring Boot 只是简化了配置，如果你需要构建 MVC 架构的 Web 程序，你还是需要使用 Spring MVC 作为 MVC 框架，只是说 Spring Boot 帮你简化了 Spring MVC 的很多配置，真正做到开箱即用！

# 三、Spring为什么是轻量级的框架

> ##### 1、加载的资源
>
> **Spring相对于EJB是轻量级的**，但这就好像说大象比鲸轻。
> 如果你想要运行一个Java EE应用程序，你不能够简单地创建一个应用并直接运行它本身。需要一个JavaEE服务器来运行应用，例如Glassfish，WebLogic或WebSphere。多数应用服务器都是非常巨大并且复杂的，并不容易安装和配置。
> EJB应用启动时要消耗大量的资源，内存、CPU等，把所有的服务都加载进来；Spring则是可定制服务，需要什么加载什么。
>
> ##### 2、侵入性（或曰框架依赖性，耦合性）
>
> 重量级框架（如EJB2.0和Struts1.2）侵入性较高。它强制开发者写一些与框架绑定的类。这使得这些类很难被测试。
> **Spring将侵入性降到最低，它允许使用POJO进行开发。Spring并不强制实现Spring API接口或扩展Spring** API类。这使得这些类方便测试。这使得把类迁移到其他轻量级容器更加容易。
>
> ##### 3、开发的方便程度
>
> 如上条所述，使用重量级框架要写一些框架绑定的类，部署、运行及测试过程都较为复杂，开发起来并不方便。而轻量级框架反之。
>
> ##### 4、解决问题的侧重点不同：
>
> **轻量级框架侧重于减小开发的复杂度，相应它的处理能力较弱（事务功能弱，不具备分布式处理能力），适用于开发中小型企业应用。** 重量级框架则强调高可伸缩性，适合于开发大型企业应用。
>
> ##### 5、轻量级框架的特点
>
> 一般是非侵入性的、依赖的东西非常少，占用资源非常少，部署简单，比较容易使用。
>
> ##### 6、为何说Spring是轻量级框架
>
> - Spring以集中的、自动化的方式进行应用程序对象创建和装配，管理对象生命周期，组合成复杂的应用程序。
> - Spring提供了不同的模块，基于需求可以灵活选择。Spring jar的大小通常在几MB。
> - 相比较EJB，Spring需要写更少的代码和更少的配置。使得开发人员能够更关注业务逻辑。
> - Spring容器是非侵入性的，完全采用POJO进行开发，方便测试。
> - Spring方便与其他框架与第三方类库无缝集成。
> - Spring与其他基于POJO的容器相比，例如Guice和Plexus，仍然称得上是“重量级”。因为完整的Spring技术栈包含了POJO之上的层次，它的MVC框架需要Servlets基础设施。
> - Spring相比EJB2.x确实是轻量级，最主要的卖点是POJO的使用。
>
> ##### 7、为何说EJB是重量级框架？
>
> 首先这是Rod Johnson说的，Spring狂热者奉之为圭臬的论断。
> 2004年以前EJB2.x确实是重量级，它需要EJB容器来运行，需要加载较多的资源，代码侵入性较高–需要实现特定的EJB接口，相对来说开发并不方便。
>
> ##### 8、总结
>
> 轻重量级是相对的，主要从加载资源、代码侵入性和开发便捷性等方面去考虑和比较。类似地，使用volatile变量可以用来确保变量的更新操作被同步到其他线程，这种同步机制相对于同步容器就是轻量级的（当然更具可伸缩性和实用性的是并发容器而非上述二者）；而jetty相对于tomcat而言，由于其加载资源更少，也可以称之为轻量级的。

# 四、Spring Ioc

## 1、Ioc

> **IoC（Inversion of Control:控制反转）** 是一种设计思想，而不是一个具体的技术实现。IoC 的思想就是将原本在程序中手动创建对象的控制权，交由 Spring 框架来管理。不过， IoC 并非 Spring 特有，在其他语言中也有应用。

> **为什么叫控制反转？**
>
> - **控制**：指的是对象创建（实例化、管理）的权力
> - **反转**：控制权交给外部环境（Spring 框架、IoC 容器）
>
> ![image-20230822151807337](D:\files\assets\image-20230822151807337.png)

> ​		将对象之间的相互依赖关系交给 IoC 容器来管理，并由 IoC 容器完成对象的注入。这样可以很大程度上简化应用的开发，把应用从复杂的依赖关系中解放出来。 IoC 容器就像是一个工厂一样，当我们需要创建一个对象的时候，只需要配置好配置文件/注解即可，完全不用考虑对象是如何被创建出来的。
>
> ​		在实际项目中一个 Service 类可能依赖了很多其他的类，假如我们需要实例化这个 Service，你可能要每次都要搞清这个 Service 所有底层类的构造函数，这可能会把人逼疯。如果利用 IoC 的话，你只需要配置好，然后在需要的地方引用就行了，这大大增加了项目的可维护性且降低了开发难度。
>
> ​		在 Spring 中， IoC 容器是 Spring 用来实现 IoC 的载体， IoC 容器实际上就是个 Map（key，value），Map 中存放的是各种对象。key是对象类名，value是一个对象实例。
>
> ​		Spring 时代我们一般通过 XML 文件来配置 Bean，后来开发人员觉得 XML 文件来配置不太好，于是 SpringBoot 注解配置就慢慢开始流行起来。

## 2、源码分析：

### 通过配置文件启动一个ApplicationContext

```java
public class App {
    public static void main(String[] args) {
        // 用我们的配置文件来启动一个 ApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        System.out.println("context 启动成功");
        // 从 context 中取出我们的 Bean，而不是用 new MessageServiceImpl() 这种方式
        MessageService messageService = context.getBean(MessageService.class);
        // 这句将输出: hello world
        System.out.println(messageService.getMessage());
    }
}
```

### BeanFactory简介

> 生产 bean 的工厂，它负责生产和管理各个 bean 实例。（ ApplicationContext 其实就是一个 BeanFactory）

BeanFactory 接口相关的主要的继承结构

<img src="D:\files\assets\image-20230822162631371.png" alt="image-20230822162631371" style="zoom:67%;" />

- ApplicationContext 继承了 ListableBeanFactory，这个 Listable 的意思就是，通过这个接口，我们可以获取多个 Bean，大家看源码会发现，最顶层 BeanFactory 接口的方法都是获取单个 Bean 的。
- ApplicationContext 继承了 HierarchicalBeanFactory，Hierarchical 单词本身已经能说明问题了，也就是说我们可以在应用中起多个 BeanFactory，然后可以将各个 BeanFactory 设置为父子关系。
- AutowireCapableBeanFactory 这个名字中的 Autowire 大家都非常熟悉，它就是用来自动装配 Bean 用的，但是仔细看上图，ApplicationContext 并没有继承它，不过不用担心，不使用继承，不代表不可以使用组合，如果你看到 ApplicationContext 接口定义中的最后一个方法 getAutowireCapableBeanFactory() 就知道了。
- ConfigurableListableBeanFactory 也是一个特殊的接口，看图，特殊之处在于它继承了第二层所有的三个接口，而 ApplicationContext 没有。这点之后会用到。

### 3、启动过程分析

#### ClassPathXmlApplicationContext 的构造方法

> ```java
> public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {
>   private Resource[] configResources;
> 
>   // 如果已经有 ApplicationContext 并需要配置成父子关系，那么调用这个构造方法
>   public ClassPathXmlApplicationContext(ApplicationContext parent) {
>     super(parent);
>   }
>   ...
>   public ClassPathXmlApplicationContext(String[] configLocations, boolean refresh, ApplicationContext parent)
>       throws BeansException {
>     super(parent);
>     // 根据提供的路径，处理成配置文件数组(以分号、逗号、空格、tab、换行符分割)
>     setConfigLocations(configLocations);
>     if (refresh) {
>       refresh(); // 核心方法
>     }
>   }
>     ...
> }
> ```

>  ApplicationContext 建立起来以后，其实我们是可以通过调用 refresh() 这个方法重建的，refresh() 会将原来的 ApplicationContext 销毁，然后再重新执行一次初始化操作。

####  refresh()

> ```java
> @Override
> public void refresh() throws BeansException, IllegalStateException {
>    // 来个锁，不然 refresh() 还没结束，你又来个启动或销毁容器的操作，那不就乱套了嘛
>    synchronized (this.startupShutdownMonitor) {
> 
>       // 准备工作，记录下容器的启动时间、标记“已启动”状态、处理配置文件中的占位符
>       prepareRefresh();
> 
>       // 这步比较关键，这步完成后，配置文件就会解析成一个个 Bean 定义，注册到 BeanFactory 中，
>       // 当然，这里说的 Bean 还没有初始化，只是配置信息都提取出来了，
>       // 注册也只是将这些信息都保存到了注册中心(说到底核心是一个 beanName-> beanDefinition 的 map)
>       ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();
> 
>       // 设置 BeanFactory 的类加载器，添加几个 BeanPostProcessor，手动注册几个特殊的 bean
>       // 这块待会会展开说
>       prepareBeanFactory(beanFactory);
> 
>       try {
>          // 【这里需要知道 BeanFactoryPostProcessor 这个知识点，Bean 如果实现了此接口，
>          // 那么在容器初始化以后，Spring 会负责调用里面的 postProcessBeanFactory 方法。】
> 
>          // 这里是提供给子类的扩展点，到这里的时候，所有的 Bean 都加载、注册完成了，但是都还没有初始化
>          // 具体的子类可以在这步的时候添加一些特殊的 BeanFactoryPostProcessor 的实现类或做点什么事
>          postProcessBeanFactory(beanFactory);
>          // 调用 BeanFactoryPostProcessor 各个实现类的 postProcessBeanFactory(factory) 方法
>          invokeBeanFactoryPostProcessors(beanFactory);
> 
>          // 注册 BeanPostProcessor 的实现类，注意看和 BeanFactoryPostProcessor 的区别
>          // 此接口两个方法: postProcessBeforeInitialization 和 postProcessAfterInitialization
>          // 两个方法分别在 Bean 初始化之前和初始化之后得到执行。注意，到这里 Bean 还没初始化
>          registerBeanPostProcessors(beanFactory);
> 
>          // 初始化当前 ApplicationContext 的 MessageSource，国际化这里就不展开说了，不然没完没了了
>          initMessageSource();
> 
>          // 初始化当前 ApplicationContext 的事件广播器，这里也不展开了
>          initApplicationEventMulticaster();
> 
>          // 从方法名就可以知道，典型的模板方法(钩子方法)，
>          // 具体的子类可以在这里初始化一些特殊的 Bean（在初始化 singleton beans 之前）
>          onRefresh();
> 
>          // 注册事件监听器，监听器需要实现 ApplicationListener 接口。这也不是我们的重点，过
>          registerListeners();
> 
>          // 重点，重点，重点
>          // 初始化所有的 singleton beans
>          //（lazy-init 的除外）
>          finishBeanFactoryInitialization(beanFactory);
> 
>          // 最后，广播事件，ApplicationContext 初始化完成
>          finishRefresh();
>       }
> 
>       catch (BeansException ex) {
>          if (logger.isWarnEnabled()) {
>             logger.warn("Exception encountered during context initialization - " +
>                   "cancelling refresh attempt: " + ex);
>          }
> 
>          // Destroy already created singletons to avoid dangling resources.
>          // 销毁已经初始化的 singleton 的 Beans，以免有些 bean 会一直占用资源
>          destroyBeans();
> 
>          // Reset 'active' flag.
>          cancelRefresh(ex);
> 
>          // 把异常往外抛
>          throw ex;
>       }
> 
>       finally {
>          // Reset common introspection caches in Spring's core, since we
>          // might not ever need metadata for singleton beans anymore...
>          resetCommonCaches();
>       }
>    }
> }
> ```

##### 创建 Bean 容器前的准备工作---prepareRefresh()

```java
protected void prepareRefresh() {
   // 记录启动时间，
   // 将 active 属性设置为 true，closed 属性设置为 false，它们都是 AtomicBoolean 类型
   this.startupDate = System.currentTimeMillis();
   this.closed.set(false);
   this.active.set(true);

   if (logger.isInfoEnabled()) {
      logger.info("Refreshing " + this);
   }

   // Initialize any placeholder property sources in the context environment
   initPropertySources();

   // 校验 xml 配置文件
   getEnvironment().validateRequiredProperties();

   this.earlyApplicationEvents = new LinkedHashSet<ApplicationEvent>();
}
```

##### 创建 Bean 容器，加载并注册---Bean obtainFreshBeanFactory()

```java
protected ConfigurableListableBeanFactory obtainFreshBeanFactory() {
   // 关闭旧的 BeanFactory (如果有)，创建新的 BeanFactory，加载 Bean 定义、注册 Bean 等等
   refreshBeanFactory();

   // 返回刚刚创建的 BeanFactory
   ConfigurableListableBeanFactory beanFactory = getBeanFactory();
   if (logger.isDebugEnabled()) {
      logger.debug("Bean factory for " + getDisplayName() + ": " + beanFactory);
   }
   return beanFactory;
}
```

refreshBeanFactory()

```java
@Override
protected final void refreshBeanFactory() throws BeansException {
   // 如果 ApplicationContext 中已经加载过 BeanFactory 了，销毁所有 Bean，关闭 BeanFactory
   // 注意，应用中 BeanFactory 本来就是可以多个的，这里可不是说应用全局是否有 BeanFactory，而是当前
   // ApplicationContext 是否有 BeanFactory
   if (hasBeanFactory()) {
      destroyBeans();
      closeBeanFactory();
   }
   try {
      // 初始化一个 DefaultListableBeanFactory，为什么用这个，我们马上说。
      DefaultListableBeanFactory beanFactory = createBeanFactory();
      // 用于 BeanFactory 的序列化，我想不部分人应该都用不到
      beanFactory.setSerializationId(getId());

      // 下面这两个方法很重要，别跟丢了，具体细节之后说
      // 设置 BeanFactory 的两个配置属性：是否允许 Bean 覆盖、是否允许循环引用
      customizeBeanFactory(beanFactory);

      // 加载 Bean 到 BeanFactory 中
      loadBeanDefinitions(beanFactory);
      synchronized (this.beanFactoryMonitor) {
         this.beanFactory = beanFactory;
      }
   }
   catch (IOException ex) {
      throw new ApplicationContextException("I/O error parsing bean definition source for " + getDisplayName(), ex);
   }
}
```

> ApplicationContext 继承自 BeanFactory，但是它不应该被理解为 BeanFactory 的实现类，而是说其内部持有一个实例化的 BeanFactory（DefaultListableBeanFactory）。以后所有的 BeanFactory 相关的操作其实是委托给这个实例来处理的。

为什么选择实例化 **DefaultListableBeanFactory**

<img src="D:\files\assets\image-20230823163848695.png" alt="image-20230823163848695" style="zoom:80%;" />

> 可以看到 ConfigurableListableBeanFactory 只有一个实现类 DefaultListableBeanFactory，而且实现类 DefaultListableBeanFactory 还通过实现右边的 AbstractAutowireCapableBeanFactory 通吃了右路。所以结论就是，最底下这个家伙 DefaultListableBeanFactory 基本上是最牛的 BeanFactory 了，这也是为什么这边会使用这个类来实例化的原因。

###### customizeBeanFactory

> customizeBeanFactory(beanFactory) 比较简单，就是配置是否允许 BeanDefinition 覆盖、是否允许循环引用。

```java
protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory) {
   if (this.allowBeanDefinitionOverriding != null) {
      // 是否允许 Bean 定义覆盖
      beanFactory.setAllowBeanDefinitionOverriding(this.allowBeanDefinitionOverriding);
   }
   if (this.allowCircularReferences != null) {
      // 是否允许 Bean 间的循环依赖
      beanFactory.setAllowCircularReferences(this.allowCircularReferences);
   }
}
```

> BeanDefinition 的覆盖问题就是在配置文件中定义 bean 时使用了相同的 id 或 name，默认情况下，allowBeanDefinitionOverriding 属性为 null，如果在同一配置文件中重复了，会抛错，但是如果不是同一配置文件中，会发生覆盖。
>
> 循环引用也很好理解：A 依赖 B，而 B 依赖 A。或 A 依赖 B，B 依赖 C，而 C 依赖 A。
>
> 默认情况下，Spring 允许循环依赖，当然如果你在 A 的构造方法中依赖 B，在 B 的构造方法中依赖 A 是不行的。

###### loadBeanDefinitions--加载 Bean

> 这个方法将根据配置，加载各个 Bean，然后放到 BeanFactory 中。读取配置的操作在 XmlBeanDefinitionReader 中，其负责加载配置、解析。



```java
// AbstractXmlApplicationContext.java 80

/** 我们可以看到，此方法将通过一个 XmlBeanDefinitionReader 实例来加载各个 Bean。*/
@Override
protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException, IOException {
   // 给这个 BeanFactory 实例化一个 XmlBeanDefinitionReader
   XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

   // Configure the bean definition reader with this context's
   // resource loading environment.
   beanDefinitionReader.setEnvironment(this.getEnvironment());
   beanDefinitionReader.setResourceLoader(this);
   beanDefinitionReader.setEntityResolver(new ResourceEntityResolver(this));

   // 初始化 BeanDefinitionReader，其实这个是提供给子类覆写的，
   // 我看了一下，没有类覆写这个方法，我们姑且当做不重要吧
   initBeanDefinitionReader(beanDefinitionReader);
   // 重点来了，继续往下
   loadBeanDefinitions(beanDefinitionReader);
}
```

```java
//loadBeanDefinitions(beanDefinitionReader) 

// AbstractXmlApplicationContext.java 120

protected void loadBeanDefinitions(XmlBeanDefinitionReader reader) throws BeansException, IOException {
   Resource[] configResources = getConfigResources();
   if (configResources != null) {
      // 往下看
      reader.loadBeanDefinitions(configResources);
   }
   String[] configLocations = getConfigLocations();
   if (configLocations != null) {
      // 2
      reader.loadBeanDefinitions(configLocations);
   }
}

// 上面虽然有两个分支，不过第二个分支很快通过解析路径转换为 Resource 以后也会进到这里
@Override
public int loadBeanDefinitions(Resource... resources) throws BeanDefinitionStoreException {
   Assert.notNull(resources, "Resource array must not be null");
   int counter = 0;
   // 注意这里是个 for 循环，也就是每个文件是一个 resource
   for (Resource resource : resources) {
      // 继续往下看
      counter += loadBeanDefinitions(resource);
   }
   // 最后返回 counter，表示总共加载了多少的 BeanDefinition
   return counter;
}

// XmlBeanDefinitionReader 303
@Override
public int loadBeanDefinitions(Resource resource) throws BeanDefinitionStoreException {
   return loadBeanDefinitions(new EncodedResource(resource));
}

// XmlBeanDefinitionReader 314
public int loadBeanDefinitions(EncodedResource encodedResource) throws BeanDefinitionStoreException {
   Assert.notNull(encodedResource, "EncodedResource must not be null");
   if (logger.isInfoEnabled()) {
      logger.info("Loading XML bean definitions from " + encodedResource.getResource());
   }
   // 用一个 ThreadLocal 来存放配置文件资源
   Set<EncodedResource> currentResources = this.resourcesCurrentlyBeingLoaded.get();
   if (currentResources == null) {
      currentResources = new HashSet<EncodedResource>(4);
      this.resourcesCurrentlyBeingLoaded.set(currentResources);
   }
   if (!currentResources.add(encodedResource)) {
      throw new BeanDefinitionStoreException(
            "Detected cyclic loading of " + encodedResource + " - check your import definitions!");
   }
   try {
      InputStream inputStream = encodedResource.getResource().getInputStream();
      try {
         InputSource inputSource = new InputSource(inputStream);
         if (encodedResource.getEncoding() != null) {
            inputSource.setEncoding(encodedResource.getEncoding());
         }
         // 核心部分是这里，往下面看
         return doLoadBeanDefinitions(inputSource, encodedResource.getResource());
      }
      finally {
         inputStream.close();
      }
   }
   catch (IOException ex) {
      throw new BeanDefinitionStoreException(
            "IOException parsing XML document from " + encodedResource.getResource(), ex);
   }
   finally {
      currentResources.remove(encodedResource);
      if (currentResources.isEmpty()) {
         this.resourcesCurrentlyBeingLoaded.remove();
      }
   }
}

// 还在这个文件中，第 388 行
protected int doLoadBeanDefinitions(InputSource inputSource, Resource resource)
      throws BeanDefinitionStoreException {
   try {
      // 这里就不看了，将 xml 文件转换为 Document 对象
      Document doc = doLoadDocument(inputSource, resource);
      // 继续
      return registerBeanDefinitions(doc, resource);
   }
   catch (...
}
// 还在这个文件中，第 505 行
// 返回值：返回从当前配置文件加载了多少数量的 Bean
public int registerBeanDefinitions(Document doc, Resource resource) throws BeanDefinitionStoreException {
   BeanDefinitionDocumentReader documentReader = createBeanDefinitionDocumentReader();
   int countBefore = getRegistry().getBeanDefinitionCount();
   // 这里
   documentReader.registerBeanDefinitions(doc, createReaderContext(resource));
   return getRegistry().getBeanDefinitionCount() - countBefore;
}
// DefaultBeanDefinitionDocumentReader 90
@Override
public void registerBeanDefinitions(Document doc, XmlReaderContext readerContext) {
   this.readerContext = readerContext;
   logger.debug("Loading bean definitions");
   Element root = doc.getDocumentElement();
   // 从 xml 根节点开始解析文件
   doRegisterBeanDefinitions(root);
}         
```

> 经过漫长的链路，一个配置文件终于转换为一颗 DOM 树了，注意，这里指的是其中一个配置文件，不是所有的，下面开始从根节点开始解析。

###### doRegisterBeanDefinitions(root)

```java
// DefaultBeanDefinitionDocumentReader 116
protected void doRegisterBeanDefinitions(Element root) {
   // 我们看名字就知道，BeanDefinitionParserDelegate 必定是一个重要的类，它负责解析 Bean 定义，
   // 这里为什么要定义一个 parent? 看到后面就知道了，是递归问题，
   // 因为 <beans /> 内部是可以定义 <beans /> 的，所以这个方法的 root 其实不一定就是 xml 的根节点，也可以是嵌套在里面的 <beans /> 节点，从源码分析的角度，我们当做根节点就好了
   BeanDefinitionParserDelegate parent = this.delegate;
   this.delegate = createDelegate(getReaderContext(), root, parent);

   if (this.delegate.isDefaultNamespace(root)) {
      // 这块说的是根节点 <beans ... profile="dev" /> 中的 profile 是否是当前环境需要的，
      // 如果当前环境配置的 profile 不包含此 profile，那就直接 return 了，不对此 <beans /> 解析
      // 不熟悉 profile 为何物，不熟悉怎么配置 profile 读者的请移步附录区
      String profileSpec = root.getAttribute(PROFILE_ATTRIBUTE);
      if (StringUtils.hasText(profileSpec)) {
         String[] specifiedProfiles = StringUtils.tokenizeToStringArray(
               profileSpec, BeanDefinitionParserDelegate.MULTI_VALUE_ATTRIBUTE_DELIMITERS);
         if (!getReaderContext().getEnvironment().acceptsProfiles(specifiedProfiles)) {
            if (logger.isInfoEnabled()) {
               logger.info("Skipped XML bean definition file due to specified profiles [" + profileSpec +
                     "] not matching: " + getReaderContext().getResource());
            }
            return;
         }
      }
   }

   preProcessXml(root); // 钩子
   // 往下看
   parseBeanDefinitions(root, this.delegate);
   postProcessXml(root); // 钩子

   this.delegate = parent;
}
```

> preProcessXml(root) 和 postProcessXml(root) 是给子类用的钩子方法，鉴于没有被使用到，也不是此处重点，直接跳过。

###### parseBeanDefinitions(root, this.delegate)

```java
// default namespace 涉及到的就四个标签 <import />、<alias />、<bean /> 和 <beans />，
// 其他的属于 custom 的
protected void parseBeanDefinitions(Element root, BeanDefinitionParserDelegate delegate) {
   if (delegate.isDefaultNamespace(root)) {
      NodeList nl = root.getChildNodes();
      for (int i = 0; i < nl.getLength(); i++) {
         Node node = nl.item(i);
         if (node instanceof Element) {
            Element ele = (Element) node;
            if (delegate.isDefaultNamespace(ele)) {
               // 解析 default namespace 下面的几个元素
               parseDefaultElement(ele, delegate);
            }
            else {
               // 解析其他 namespace 的元素
               delegate.parseCustomElement(ele);
            }
         }
      }
   }
   else {
      delegate.parseCustomElement(root);
   }
}
```

> 从上面的代码，我们可以看到，对于每个配置来说，分别进入到 parseDefaultElement(ele, delegate); 和 delegate.parseCustomElement(ele); 这两个分支了。
>
> parseDefaultElement(ele, delegate) 代表解析的节点是 `<import />`、`<alias />`（别名）、`<bean />`、`<beans />` 这几个。
>
> 这里的四个标签之所以是 **default** 的，是因为它们是处于这个 namespace 下定义的：
>
> ```xml
> http://www.springframework.org/schema/beans
> ```

> 又到初学者科普时间，不熟悉 namespace 的读者请看下面贴出来的 xml，这里的第二行 **xmlns** 就是咯。
>
> ```xml
> <beans xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
>        xmlns="http://www.springframework.org/schema/beans"
>        xsi:schemaLocation="
>             http://www.springframework.org/schema/beans
>           http://www.springframework.org/schema/beans/spring-beans.xsd"
>        default-autowire="byName">
> ```
>
> 而对于其他的标签，将进入到 delegate.parseCustomElement(element) 这个分支。如我们经常会使用到的 `<mvc />`、`<task />`、`<context />`、`<aop />`等。

###### 处理 default 标签的方法：

```java
private void parseDefaultElement(Element ele, BeanDefinitionParserDelegate delegate) {
   if (delegate.nodeNameEquals(ele, IMPORT_ELEMENT)) {
      // 处理 <import /> 标签
      importBeanDefinitionResource(ele);
   }
   else if (delegate.nodeNameEquals(ele, ALIAS_ELEMENT)) {
      // 处理 <alias /> 标签定义
      // <alias name="fromName" alias="toName"/>
      processAliasRegistration(ele);
   }
   else if (delegate.nodeNameEquals(ele, BEAN_ELEMENT)) {
      // 处理 <bean /> 标签定义，这也算是我们的重点吧
      processBeanDefinition(ele, delegate);
   }
   else if (delegate.nodeNameEquals(ele, NESTED_BEANS_ELEMENT)) {
      // 如果碰到的是嵌套的 <beans /> 标签，需要递归
      doRegisterBeanDefinitions(ele);
   }
}
```

######  processBeanDefinition 解析 bean 标签

> **`<bean />`** 标签中可以定义哪些属性：
>
> | Property                 |                                                              |
> | ------------------------ | ------------------------------------------------------------ |
> | class                    | 类的全限定名                                                 |
> | name                     | 可指定 id、name(用逗号、分号、空格分隔)                      |
> | scope                    | 作用域                                                       |
> | constructor arguments    | 指定构造参数                                                 |
> | properties               | 设置属性的值                                                 |
> | autowiring mode          | no(默认值)、byName、byType、 constructor                     |
> | lazy-initialization mode | 是否懒加载(如果被非懒加载的bean依赖了那么其实也就不能懒加载了) |
> | initialization method    | bean 属性设置完成后，会调用这个方法                          |
> | destruction method       | bean 销毁后的回调方法                                        |
>
> 简单地说就是像下面这样：
>
> ```xml
> <bean id="exampleBean" name="name1, name2, name3" class="com.javadoop.ExampleBean"
>       scope="singleton" lazy-init="true" init-method="init" destroy-method="cleanup">
> 
>     <!-- 可以用下面三种形式指定构造参数 -->
>     <constructor-arg type="int" value="7500000"/>
>     <constructor-arg name="years" value="7500000"/>
>     <constructor-arg index="0" value="7500000"/>
> 
>     <!-- property 的几种情况 -->
>     <property name="beanOne">
>         <ref bean="anotherExampleBean"/>
>     </property>
>     <property name="beanTwo" ref="yetAnotherBean"/>
>     <property name="integerProperty" value="1"/>
> </bean>
> ```
>
> 当然，除了上面举例出来的这些，还有 factory-bean、factory-method、`<lockup-method />`、`<replaced-method />`、`<meta />`、`<qualifier />` 这几个

下面是 processBeanDefinition 解析 `<bean />` 标签：

```java
// DefaultBeanDefinitionDocumentReader 298
protected void processBeanDefinition(Element ele, BeanDefinitionParserDelegate delegate) {
   // 将 <bean /> 节点中的信息提取出来，然后封装到一个 BeanDefinitionHolder 中，细节往下看
   BeanDefinitionHolder bdHolder = delegate.parseBeanDefinitionElement(ele);

   // 下面的几行先不要看，跳过先，跳过先，跳过先，后面会继续说的

   if (bdHolder != null) {
      bdHolder = delegate.decorateBeanDefinitionIfRequired(ele, bdHolder);
      try {
         // Register the final decorated instance.
         BeanDefinitionReaderUtils.registerBeanDefinition(bdHolder, getReaderContext().getRegistry());
      }
      catch (BeanDefinitionStoreException ex) {
         getReaderContext().error("Failed to register bean definition with name '" +
               bdHolder.getBeanName() + "'", ele, ex);
      }
      // Send registration event.
      getReaderContext().fireComponentRegistered(new BeanComponentDefinition(bdHolder));
   }
}
```

###### delegate.parseBeanDefinitionElement(ele)

// BeanDefinitionParserDelegate 428   (AbstractBeanDefinition封装为BeanDefinitionHolder)

```java
public BeanDefinitionHolder parseBeanDefinitionElement(Element ele) {
    return parseBeanDefinitionElement(ele, null);
}

public BeanDefinitionHolder parseBeanDefinitionElement(Element ele, BeanDefinition containingBean) {
   String id = ele.getAttribute(ID_ATTRIBUTE);
   String nameAttr = ele.getAttribute(NAME_ATTRIBUTE);

   List<String> aliases = new ArrayList<String>();

   // 将 name 属性的定义按照 “逗号、分号、空格” 切分，形成一个 别名列表数组，
   // 当然，如果你不定义 name 属性的话，就是空的了
   // 我在附录中简单介绍了一下 id 和 name 的配置，大家可以看一眼，有个20秒就可以了
   if (StringUtils.hasLength(nameAttr)) {
      String[] nameArr = StringUtils.tokenizeToStringArray(nameAttr, MULTI_VALUE_ATTRIBUTE_DELIMITERS);
      aliases.addAll(Arrays.asList(nameArr));
   }

   String beanName = id;
   // 如果没有指定id, 那么用别名列表的第一个名字作为beanName
   if (!StringUtils.hasText(beanName) && !aliases.isEmpty()) {
      beanName = aliases.remove(0);
      if (logger.isDebugEnabled()) {
         logger.debug("No XML 'id' specified - using '" + beanName +
               "' as bean name and " + aliases + " as aliases");
      }
   }

   if (containingBean == null) {
      checkNameUniqueness(beanName, aliases, ele);
   }

   // 根据 <bean ...>...</bean> 中的配置创建 BeanDefinition，然后把配置中的信息都设置到实例中,
   // 细节后面细说，先知道下面这行结束后，一个 BeanDefinition 实例就出来了。
   AbstractBeanDefinition beanDefinition = parseBeanDefinitionElement(ele, beanName, containingBean);

   // 到这里，整个 <bean /> 标签就算解析结束了，一个 BeanDefinition 就形成了。
   if (beanDefinition != null) {
      // 如果都没有设置 id 和 name，那么此时的 beanName 就会为 null，进入下面这块代码产生
      // 如果读者不感兴趣的话，我觉得不需要关心这块代码，对本文源码分析来说，这些东西不重要
      if (!StringUtils.hasText(beanName)) {
         try {
            if (containingBean != null) {// 按照我们的思路，这里 containingBean 是 null 的
               beanName = BeanDefinitionReaderUtils.generateBeanName(
                     beanDefinition, this.readerContext.getRegistry(), true);
            }
            else {
               // 如果我们不定义 id 和 name，那么我们引言里的那个例子：
               //   1. beanName 为：com.javadoop.example.MessageServiceImpl#0
               //   2. beanClassName 为：com.javadoop.example.MessageServiceImpl

               beanName = this.readerContext.generateBeanName(beanDefinition);

               String beanClassName = beanDefinition.getBeanClassName();
               if (beanClassName != null &&
                     beanName.startsWith(beanClassName) && beanName.length() > beanClassName.length() &&
                     !this.readerContext.getRegistry().isBeanNameInUse(beanClassName)) {
                  // 把 beanClassName 设置为 Bean 的别名
                  aliases.add(beanClassName);
               }
            }
            if (logger.isDebugEnabled()) {
               logger.debug("Neither XML 'id' nor 'name' specified - " +
                     "using generated bean name [" + beanName + "]");
            }
         }
         catch (Exception ex) {
            error(ex.getMessage(), ele);
            return null;
         }
      }
      String[] aliasesArray = StringUtils.toStringArray(aliases);
      // 返回 BeanDefinitionHolder
      return new BeanDefinitionHolder(beanDefinition, beanName, aliasesArray);
   }

   return null;
}
```

###### parseBeanDefinitionElement(ele, beanName, containingBean)

>  (AbstractBeanDefinition封装为BeanDefinitionHolder)
>
> 再看看怎么根据配置创建 BeanDefinition 实例的

```java
public AbstractBeanDefinition parseBeanDefinitionElement(
      Element ele, String beanName, BeanDefinition containingBean) {

   this.parseState.push(new BeanEntry(beanName));

   String className = null;
   if (ele.hasAttribute(CLASS_ATTRIBUTE)) {
      className = ele.getAttribute(CLASS_ATTRIBUTE).trim();
   }

   try {
      String parent = null;
      if (ele.hasAttribute(PARENT_ATTRIBUTE)) {
         parent = ele.getAttribute(PARENT_ATTRIBUTE);
      }
      // 创建 BeanDefinition，然后设置类信息而已，很简单，就不贴代码了
      AbstractBeanDefinition bd = createBeanDefinition(className, parent);

      // 设置 BeanDefinition 的一堆属性，这些属性定义在 AbstractBeanDefinition 中
      parseBeanDefinitionAttributes(ele, beanName, containingBean, bd);
      bd.setDescription(DomUtils.getChildElementValueByTagName(ele, DESCRIPTION_ELEMENT));

      /**
       * 下面的一堆是解析 <bean>......</bean> 内部的子元素，
       * 解析出来以后的信息都放到 bd 的属性中
       */

      // 解析 <meta />
      parseMetaElements(ele, bd);
      // 解析 <lookup-method />
      parseLookupOverrideSubElements(ele, bd.getMethodOverrides());
      // 解析 <replaced-method />
      parseReplacedMethodSubElements(ele, bd.getMethodOverrides());
    // 解析 <constructor-arg />
      parseConstructorArgElements(ele, bd);
      // 解析 <property />
      parsePropertyElements(ele, bd);
      // 解析 <qualifier />
      parseQualifierElements(ele, bd);

      bd.setResource(this.readerContext.getResource());
      bd.setSource(extractSource(ele));

      return bd;
   }
   catch (ClassNotFoundException ex) {
      error("Bean class [" + className + "] not found", ele, ex);
   }
   catch (NoClassDefFoundError err) {
      error("Class that bean class [" + className + "] depends on not found", ele, err);
   }
   catch (Throwable ex) {
      error("Unexpected failure during bean definition parsing", ele, ex);
   }
   finally {
      this.parseState.pop();
   }

   return null;
}
```

> 到这里，我们已经完成了根据 `<bean />` 配置创建了一个 BeanDefinitionHolder 实例。注意，是一个。

###### 我们回到解析 `<bean />` 的入口方法: processBeanDefinition()

> 这里已经根据一个 `<bean />` 标签产生了一个 BeanDefinitionHolder 的实例，这个实例里面也就是一个 BeanDefinition 的实例和它的 beanName、aliases 这三个信息，注意，我们的关注点始终在 BeanDefinition 上：
>
> ```java
> public class BeanDefinitionHolder implements BeanMetadataElement {
> 
>   private final BeanDefinition beanDefinition;
> 
>   private final String beanName;
> 
>   private final String[] aliases;
> ...
> ```

## 4、BeanDefinition 接口定义

> BeanDefinition 就是我们所说的 Spring 的 Bean，我们自己定义的各个 Bean 其实会转换成一个个 BeanDefinition 存在于 Spring 的 BeanFactory 中。
>
> 所以，Bean 在代码层面上可以简单认为是 BeanDefinition 的实例。
>
> BeanDefinition 中保存了我们的 Bean 信息，比如这个 Bean 指向的是哪个类、是否是单例的、是否懒加载、这个 Bean 依赖了哪些 Bean 等等。

```java
public interface BeanDefinition extends AttributeAccessor, BeanMetadataElement {

   // 我们可以看到，默认只提供 sington 和 prototype 两种，
   // 很多读者可能知道还有 request, session, globalSession, application, websocket 这几种，
   // 不过，它们属于基于 web 的扩展。
   String SCOPE_SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON;
   String SCOPE_PROTOTYPE = ConfigurableBeanFactory.SCOPE_PROTOTYPE;

   // 比较不重要，直接跳过吧
   int ROLE_APPLICATION = 0;
   int ROLE_SUPPORT = 1;
   int ROLE_INFRASTRUCTURE = 2;

   // 设置父 Bean，这里涉及到 bean 继承，不是 java 继承。请参见附录的详细介绍
   // 一句话就是：继承父 Bean 的配置信息而已
   void setParentName(String parentName);

   // 获取父 Bean
   String getParentName();

   // 设置 Bean 的类名称，将来是要通过反射来生成实例的
   void setBeanClassName(String beanClassName);

   // 获取 Bean 的类名称
   String getBeanClassName();


   // 设置 bean 的 scope
   void setScope(String scope);

   String getScope();

   // 设置是否懒加载
   void setLazyInit(boolean lazyInit);

   boolean isLazyInit();

   // 设置该 Bean 依赖的所有的 Bean，注意，这里的依赖不是指属性依赖(如 @Autowire 标记的)，
   // 是 depends-on="" 属性设置的值。
   void setDependsOn(String... dependsOn);

   // 返回该 Bean 的所有依赖
   String[] getDependsOn();

   // 设置该 Bean 是否可以注入到其他 Bean 中，只对根据类型注入有效，
   // 如果根据名称注入，即使这边设置了 false，也是可以的
   void setAutowireCandidate(boolean autowireCandidate);

   // 该 Bean 是否可以注入到其他 Bean 中
   boolean isAutowireCandidate();

   // 主要的。同一接口的多个实现，如果不指定名字的话，Spring 会优先选择设置 primary 为 true 的 bean
   void setPrimary(boolean primary);

   // 是否是 primary 的
   boolean isPrimary();

   // 如果该 Bean 采用工厂方法生成，指定工厂名称。对工厂不熟悉的读者，请参加附录
   // 一句话就是：有些实例不是用反射生成的，而是用工厂模式生成的
   void setFactoryBeanName(String factoryBeanName);
   // 获取工厂名称
   String getFactoryBeanName();
   // 指定工厂类中的 工厂方法名称
   void setFactoryMethodName(String factoryMethodName);
   // 获取工厂类中的 工厂方法名称
   String getFactoryMethodName();

   // 构造器参数
   ConstructorArgumentValues getConstructorArgumentValues();

   // Bean 中的属性值，后面给 bean 注入属性值的时候会说到
   MutablePropertyValues getPropertyValues();

   // 是否 singleton
   boolean isSingleton();

   // 是否 prototype
   boolean isPrototype();

   // 如果这个 Bean 是被设置为 abstract，那么不能实例化，
   // 常用于作为 父bean 用于继承，其实也很少用......
   boolean isAbstract();

   int getRole();
   String getDescription();
   String getResourceDescription();
   BeanDefinition getOriginatingBeanDefinition();
}
```

## 5、primary注解介绍



## 6、profile



## 7、BeanDefinitionParserDelegate





# 五、Bean

## @Component 和 @Bean 的区别是什么？

> - `@Component` 注解作用于类，而`@Bean`注解作用于方法。
> - `@Component`通常是通过类路径扫描来自动侦测以及自动装配到 Spring 容器中（我们可以使用 `@ComponentScan` 注解定义要扫描的路径从中找出标识了需要装配的类自动装配到 Spring 的 bean 容器中）。`@Bean` 注解通常是我们在标有该注解的方法中定义产生这个 bean,`@Bean`告诉了 Spring 这是某个类的实例，当我需要用它的时候还给我。
> - `@Bean` 注解比 `@Component` 注解的自定义性更强，而且很多地方我们只能通过 `@Bean` 注解来注册 bean。比如当我们引用第三方库中的类需要装配到 `Spring`容器时，则只能通过 `@Bean`来实现。

`@Bean`注解使用示例：

```java
@Configuration
public class AppConfig {
    @Bean
    public TransferService transferService() {
        return new TransferServiceImpl();
    }
}
```

上面的代码相当于下面的 xml 配置

```xml
<beans>
    <bean id="transferService" class="com.acme.TransferServiceImpl"/>
</beans>
```

下面这个例子是通过 `@Component` 无法实现的。

```java
@Bean
public OneService getService(status) {
    case (status)  {
        when 1:
                return new serviceImpl1();
        when 2:
                return new serviceImpl2();
        when 3:
                return new serviceImpl3();
    }
}
```

> **注入 Bean 的注解有哪些？**
>
> Spring 内置的 `@Autowired` 以及 JDK 内置的 `@Resource` 和 `@Inject` 都可以用于注入 Bean。
>
> | Annotaion    | Package                            | Source       |
> | ------------ | ---------------------------------- | ------------ |
> | `@Autowired` | `org.springframework.bean.factory` | Spring 2.5+  |
> | `@Resource`  | `javax.annotation`                 | Java JSR-250 |
> | `@Inject`    | `javax.inject`                     | Java JSR-330 |
>
> `@Autowired` 和`@Resource`使用的比较多一些

## @Autowired 和 @Resource 的区别是什么？

> `Autowired` 属于 Spring 内置的注解，默认的注入方式为`byType`（根据类型进行匹配），也就是说会优先根据接口类型去匹配并注入 Bean （接口的实现类）。当一个接口存在多个实现类的话，`byType`这种方式就无法正确注入对象了，因为这个时候 Spring 会同时找到多个满足条件的选择，默认情况下它自己不知道选择哪一个。
>
> 这种情况下，注入方式会变为 `byName`（根据名称进行匹配），这个名称通常就是类名（首字母小写）。就比如说下面代码中的 `smsService` 就是我这里所说的名称，这样应该比较好理解了吧。



```java
// smsService 就是我们上面所说的名称
@Autowired
private SmsService smsService;
```

> 举个例子，`SmsService` 接口有两个实现类: `SmsServiceImpl1`和 `SmsServiceImpl2`，且它们都已经被 Spring 容器所管理。

```java
// 报错，byName 和 byType 都无法匹配到 bean
@Autowired
private SmsService smsService;
// 正确注入 SmsServiceImpl1 对象对应的 bean
@Autowired
private SmsService smsServiceImpl1;
// 正确注入  SmsServiceImpl1 对象对应的 bean
// smsServiceImpl1 就是我们上面所说的名称
@Autowired
@Qualifier(value = "smsServiceImpl1")
private SmsService smsService;
```

> 我们还是建议通过 `@Qualifier` 注解来显式指定名称而不是依赖变量的名称。
>
> `@Resource`属于 JDK 提供的注解，默认注入方式为 `byName`。如果无法通过名称匹配到对应的 Bean 的话，注入方式会变为`byType`。
>
> `@Resource` 有两个比较重要且日常开发常用的属性：`name`（名称）、`type`（类型）。

```java
public @interface Resource {
    String name() default "";
    Class<?> type() default Object.class;
}
```

> 如果仅指定 `name` 属性则注入方式为`byName`，如果仅指定`type`属性则注入方式为`byType`，如果同时指定`name` 和`type`属性（不建议这么做）则注入方式为`byType`+`byName`。

```java
// 报错，byName 和 byType 都无法匹配到 bean
@Resource
private SmsService smsService;
// 正确注入 SmsServiceImpl1 对象对应的 bean
@Resource
private SmsService smsServiceImpl1;
// 正确注入 SmsServiceImpl1 对象对应的 bean（比较推荐这种方式）
@Resource(name = "smsServiceImpl1")
private SmsService smsService;
```

> 简单总结一下：
>
> - `@Autowired` 是 Spring 提供的注解，`@Resource` 是 JDK 提供的注解。
> - `Autowired` 默认的注入方式为`byType`（根据类型进行匹配），`@Resource`默认注入方式为 `byName`（根据名称进行匹配）。
> - 当一个接口存在多个实现类的情况下，`@Autowired` 和`@Resource`都需要通过名称才能正确匹配到对应的 Bean。`Autowired` 可以通过 `@Qualifier` 注解来显式指定名称，`@Resource`可以通过 `name` 属性来显式指定名称

## Bean 是线程安全的吗

> Spring 框架中的 Bean 是否线程安全，取决于其作用域和状态。
>
> 我们这里以最常用的两种作用域 prototype 和 singleton 为例介绍。几乎所有场景的 Bean 作用域都是使用默认的 singleton ，重点关注 singleton 作用域即可。
>
> prototype 作用域下，每次获取都会创建一个新的 bean 实例，不存在资源竞争问题，所以不存在线程安全问题。singleton 作用域下，IoC 容器中只有唯一的 bean 实例，可能会存在资源竞争问题（取决于 Bean 是否有状态）。如果这个 bean 是有状态的话，那就存在线程安全问题（有状态 Bean 是指包含可变的成员变量的对象）。
>
> 不过，大部分 Bean 实际都是无状态（没有定义可变的成员变量）的（比如 Dao、Service），这种情况下， Bean 是线程安全的。
>
> 对于有状态单例 Bean 的线程安全问题，常见的有两种解决办法：
>
> 1. 在 Bean 中尽量避免定义可变的成员变量。
> 2. 在类中定义一个 `ThreadLocal` 成员变量，将需要的可变成员变量保存在 `ThreadLocal` 中（推荐的一种方式）。

## Bean 的生命周期

- Bean 容器找到配置文件中 Spring Bean 的定义。
- Bean 容器利用 Java Reflection API 创建一个 Bean 的实例。
- 如果涉及到一些属性值 利用 `set()`方法设置一些属性值。
- 如果 Bean 实现了 `BeanNameAware` 接口，调用 `setBeanName()`方法，传入 Bean 的名字。
- 如果 Bean 实现了 `BeanClassLoaderAware` 接口，调用 `setBeanClassLoader()`方法，传入 `ClassLoader`对象的实例。
- 如果 Bean 实现了 `BeanFactoryAware` 接口，调用 `setBeanFactory()`方法，传入 `BeanFactory`对象的实例。
- 与上面的类似，如果实现了其他 `*.Aware`接口，就调用相应的方法。
- 如果有和加载这个 Bean 的 Spring 容器相关的 `BeanPostProcessor` 对象，执行`postProcessBeforeInitialization()` 方法
- 如果 Bean 实现了`InitializingBean`接口，执行`afterPropertiesSet()`方法。
- 如果 Bean 在配置文件中的定义包含 init-method 属性，执行指定的方法。
- 如果有和加载这个 Bean 的 Spring 容器相关的 `BeanPostProcessor` 对象，执行`postProcessAfterInitialization()` 方法
- 当要销毁 Bean 的时候，如果 Bean 实现了 `DisposableBean` 接口，执行 `destroy()` 方法。
- 当要销毁 Bean 的时候，如果 Bean 在配置文件中的定义包含 destroy-method 属性，执行指定的方法。

# 六、Spring AoP

### 谈谈自己对于 AOP 的了解

> AOP(Aspect-Oriented Programming:面向切面编程)能够将那些与业务无关，却为业务模块所共同调用的逻辑或责任（例如事务处理、日志管理、权限控制等）封装起来，便于减少系统的重复代码，降低模块间的耦合度，并有利于未来的可拓展性和可维护性。
>
> Spring AOP 就是基于动态代理的，如果要代理的对象，实现了某个接口，那么 Spring AOP 会使用 **JDK Proxy**，去创建代理对象，而对于没有实现接口的对象，就无法使用 JDK Proxy 去进行代理了，这时候 Spring AOP 会使用 **Cglib** 生成一个被代理对象的子类来作为代理，如下图所示：

![SpringAOPProcess](https://oss.javaguide.cn/github/javaguide/system-design/framework/spring/230ae587a322d6e4d09510161987d346.jpeg)SpringAOPProcess

当然你也可以使用 **AspectJ** ！Spring AOP 已经集成了 AspectJ ，AspectJ 应该算的上是 Java 生态系统中最完整的 AOP 框架了。

AOP 切面编程设计到的一些专业术语：

| 术语              |                             含义                             |
| :---------------- | :----------------------------------------------------------: |
| 目标(Target)      |                         被通知的对象                         |
| 代理(Proxy)       |             向目标对象应用通知之后创建的代理对象             |
| 连接点(JoinPoint) |         目标对象的所属类中，定义的所有方法均为连接点         |
| 切入点(Pointcut)  | 被切面拦截 / 增强的连接点（切入点一定是连接点，连接点不一定是切入点） |
| 通知(Advice)      | 增强的逻辑 / 代码，也即拦截到目标对象的连接点之后要做的事情  |
| 切面(Aspect)      |                切入点(Pointcut)+通知(Advice)                 |
| Weaving(织入)     |       将通知应用到目标对象，进而生成代理对象的过程动作       |

### [#](#spring-aop-和-aspectj-aop-有什么区别) Spring AOP 和 AspectJ AOP 有什么区别？

**Spring AOP 属于运行时增强，而 AspectJ 是编译时增强。** Spring AOP 基于代理(Proxying)，而 AspectJ 基于字节码操作(Bytecode Manipulation)。

Spring AOP 已经集成了 AspectJ ，AspectJ 应该算的上是 Java 生态系统中最完整的 AOP 框架了。AspectJ 相比于 Spring AOP 功能更加强大，但是 Spring AOP 相对来说更简单，

如果我们的切面比较少，那么两者性能差异不大。但是，当切面太多的话，最好选择 AspectJ ，它比 Spring AOP 快很多。

### [#](#aspectj-定义的通知类型有哪些) AspectJ 定义的通知类型有哪些？

- **Before**（前置通知）：目标对象的方法调用之前触发
- **After** （后置通知）：目标对象的方法调用之后触发
- **AfterReturning**（返回通知）：目标对象的方法调用完成，在返回结果值之后触发
- **AfterThrowing**（异常通知）：目标对象的方法运行中抛出 / 触发异常后触发。AfterReturning 和 AfterThrowing 两者互斥。如果方法调用成功无异常，则会有返回值；如果方法抛出了异常，则不会有返回值。
- **Around** （环绕通知）：编程式控制目标对象的方法调用。环绕通知是所有通知类型中可操作范围最大的一种，因为它可以直接拿到目标对象，以及要执行的方法，所以环绕通知可以任意的在目标对象的方法调用前后搞事，甚至不调用目标对象的方法

### [#](#多个切面的执行顺序如何控制) 多个切面的执行顺序如何控制？

1、通常使用`@Order` 注解直接定义切面顺序



```java
// 值越小优先级越高
@Order(3)
@Component
@Aspect
public class LoggingAspect implements Ordered {
```

**2、实现`Ordered` 接口重写 `getOrder` 方法。**



```java
@Component
@Aspect
public class LoggingAspect implements Ordered {

    // ....

    @Override
    public int getOrder() {
        // 返回值越小优先级越高
        return 1;
    }
}
```

------

著作权归Guide所有 原文链接：https://javaguide.cn/system-design/framework/spring/spring-knowledge-and-questions-summary.html#%E5%A4%9A%E4%B8%AA%E5%88%87%E9%9D%A2%E7%9A%84%E6%89%A7%E8%A1%8C%E9%A1%BA%E5%BA%8F%E5%A6%82%E4%BD%95%E6%8E%A7%E5%88%B6