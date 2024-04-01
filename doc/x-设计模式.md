# 第 x 章 设计模式

## x.1 设计模式概述

### x.1.1 设计模式

设计模式蝇面对同类软件工程设计问题的总结，是某类问题的通信解决方案，代表了最佳的实践。

设计模式是本质是提高软件的维护性、通用性和扩展性，并降低软件的复杂度。

### x.1.2 设计模式七大原则

1. 单一职责原则

    对类来说，一个类应该只负责一项职责。

    - 降低类的复杂度，一个类只负责一项职责
    - 提高类的可读性，可维护性
    - 降低变更引起的风险

        通常情况下，都应当遵守单一职责原则，只有逻辑足够简单，才可以在代码级违反单一职责原则；只有类中方法数量足够少，才可以在方法级别保持单一职责原则。

2. 接口隔离原则

    客户端不应该依赖它不需要的接口，一个类对另一个类的依赖应该建立在最小的接口上。

3. 依赖倒置原则

    - 高层模块不应该依赖低层模块，二者都应该依赖其抽象
    - 抽象不应该依赖细节，细节应该依赖抽象
    - 依赖倒置的中心思想是面向接口编程
    - 以抽象为基础搭建的架构比以细节为基础的架构要稳定得多
    - 使用接口或抽象的目的是制定好规范，而不涉及任何具体的操作，把细节交给实现类去完成

    依赖传递的方式：

    - 接口传递
    - 构造器传递
    - setter 传递

4. 里氏替换原则

    - 所有引用基类的地方必须能透明地使用其子类的对象
    - 使用继承时，子类中尽量不要重写父类方法

5. 开闭原则

    - 一个软件实体，模块和函数应该对扩展开放，对修改关闭。用抽象构建框架，用实现扩展细节
    - 当软件需求变化时，尽量通过扩展软件实体的行为来实现变化，而不是通过修改已有的代码来实现变化
    - 编程中遵循其它原则，及使用设计模式的目的是遵循开闭原则

6. 迪米特法则

    一个类对自己依赖的类知道的越少越好，即对于被依赖的类不管多么复杂，都尽量将逻辑封装在类内部，对外除了提供 public 方法，不泄露任何信息。

    迪米特法则的核心是隐你类之间的耦合。

7. 合成复用原则

    尽量使用合成/聚合方式，而不使用继承。

设计原则核心思想：

-   找出应用中可能需要变化的地方，独立出来
-   针对接口编程，而不是针对实现编程
-   为了交互对象之间的松耦合而努力

### x.1.3 设计模式类型

1. 创建型模式

    - 单例模式
    - 抽象工厂模式
    - 原型模式
    - 建造者模式
    - 工厂模式

2. 结构型模式

    - 适配器模式
    - 桥接模式
    - 装饰模式
    - 组合模式
    - 外观模式
    - 享元模式
    - 代理模式

3. 行为型模式

    - 模版方法模式
    - 命令模式
    - 访问者模式
    - 迭代器模式
    - 观察者模式
    - 中介者模式
    - 备忘录模式
    - 解释器模式
    - 状态模式
    - 策略模式
    - 责任链模式

## x.2 单例模式

### x.2.1 单例模式概述

单例模式，是采用一定的方法保证整个系统中，某个类只存在一个对象实例，并且该类只提供一个获取其对象实例的方法。

### x.2.2 单例模式实现

1.  饿汉式

    -   构造器私有化
    -   类内部创建对象
    -   向外暴露一个静态的公共方法

    ```java
    class Singleton {
        // 1. 私有化构造器
        private Singleton() {}

        // 2. 类内部创建对象实例
        private final static Singleton instance = new Singleton();

        // 3. 提供公有的静态方法，返回实例对象
        public static Singleton getInstance() {
            return instance;
        }
    }
    ```

    ```java
    class Singleton {
        // 1. 私有化构造器
        private Singleton() {}

        // 2. 类内部创建对象实例
        // 静态代码块实现
        private static Singleton instance;
        static {
            instance = new Singleton();
        }

        // 3. 提供公有的静态方法，返回实例对象
        public static Singleton getInstance() {
            return instance;
        }
    }
    ```

    实现分析：

    -   写法简单，在类装载时完成实例化，避免了线程同步问题
    -   类装载时完成实例化，没有达到懒加载的效果，可能会造成内存浪费

2.  懒汉式（线程不安全）

    ```java
    class Singleton {
        private static Singleton instance;

        private Singleton() {}

        public static Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }
    }
    ```

    实现分析：

    -   起到了懒加载效果，但只能在单线程下使用
    -   多线程下，一个线程进入了`if(singleton == null)`判断，还未来得及往下执行，另一个线程也通过了判断语句，此时会产生多个实例，多线程环境下不可使用

3.  懒汉式（线程安全）

    ```java
    class Singleton {
        private static Singleton instance;

        private Singleton() {
        }

        // 加入同步处理，解决线程安全问题
        public static synchronized Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }
    }
    ```

    实现分析：

    -   解决了线程不安全问题
    -   方法进行同步效率太低

4.  双重检查

    ```java
    class Singleton {
        private static volatile Singleton instance;

        private Singleton() {
        }

        // 加入双重检查，解决线程安全问题，同时解决懒加载
        public static synchronized Singleton getInstance() {
            if (instance == null) {
                synchronized (Singleton.class) {
                    if (instance == null) {
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
    }
    ```

    实现分析：

    -   Double-Check 是多线程开发中常用的，可以保证线程安全
    -   实例化代码只执行一次，后面再次访问时进行判断，避免反复进行方法同步
    -   线程安全，延迟加载，效率较高，推荐使用

5.  静态内部类

    ```java
    class Singleton {

        private Singleton() {
        }

        private static class SingletonInstance {
            private static final Singleton INSTANCE = new Singleton();
        }

        public static Singleton getInstance() {
            return SingletonInstance.INSTANCE;
        }
    }
    ```

    实现分析：

    -   静态内部类试在 Singleton 被装载时并不立即实例化，而是在需要时调用 getInstalce()方法，才会装载 SingletonInstance 类，完成 Singleton 的实例化
    -   类的静态属性只会在第一次加载类时初始化，JVM 保证了线程的安全性，在类初始化时，另的线程是无法进入的
    -   避免了线程不安全，复用静态内部类实现延迟载，效率高

6.  枚举

    ```java
    enum Singleton {
        INSTANCE;
    }
    ```

### x.2.3 源码分析

1. JDK 源码 RunTime 类：

    ```java
    public class Runtime {
        private static final Runtime currentRuntime = new Runtime();

        public static Runtime getRuntime() {
            return currentRuntime;
        }

        private Runtime() {
        }

        ...
    }
    ```

2. 使用场景

    - 单例模式保证系统内存中类只存在一个对象，节省了系统资源，对于一些需要频繁创建销毁的对象，使用单例模式可以提高系统性能
    - 单例模式使用场景：需要频繁进行创建和销毁对象，创建对象耗时过多或耗费资源过多，经常用到的对象、工具类对象、频繁访问数据库或文件的对象

## x.3 工厂模式

### x.3.1 简单工厂模式

1. 简单工厂模式简介

    简单工厂模式属于创建型模式，是由一个工厂决定创建出哪一种产品类的实例。

    简单工厂模式定义了一个创建对象的类，由该类来封装实例化对象的行为。

2. 简单工厂模式实现

### x.3.2 工厂方法模式

1. 工厂方法模式简介

    定义一个创建对象的抽象方法，由子类决定要实例化的类。工厂方法模式将对象的实例化推迟到子类。

2. 工厂方法模式实现

### x.3.3 抽象工厂模式

1. 抽象工厂模式简介

    抽象工厂模式定义了一个接口，用于创建相关或有依赖关系的对象簇，而无需指明具体的类。

    抽象工厂模式可以将简单工厂模式和工厂方法模式进行整合，将工厂抽象为抽象工厂和具体实现的工厂子类。

2. 抽象工厂模式实现

### x.3.4 源码分析

1. 源码分析

    JDK 源码 Calendar 类：

    ```java
    public static Calendar getInstance() {
        Locale aLocale = Locale.getDefault(Category.FORMAT);
        return createCalendar(defaultTimeZone(aLocale), aLocale);
    }
    ```

    ```java
    private static Calendar createCalendar(TimeZone zone, Locale aLocale) {
            CalendarProvider provider = LocaleProviderAdapter.getAdapter(CalendarProvider.class, aLocale).getCalendarProvider();
            if (provider != null) {
                try {
                    return provider.getInstance(zone, aLocale);
                } catch (IllegalArgumentException var7) {
                }
            }

            Calendar cal = null;
            if (aLocale.hasExtensions()) {
                String caltype = aLocale.getUnicodeLocaleType("ca");
                if (caltype != null) {
                    Object var10000;
                    switch (caltype) {
                        case "buddhist":
                            var10000 = new BuddhistCalendar(zone, aLocale);
                            break;
                        case "japanese":
                            var10000 = new JapaneseImperialCalendar(zone, aLocale);
                            break;
                        case "gregory":
                            var10000 = new GregorianCalendar(zone, aLocale);
                            break;
                        default:
                            var10000 = null;
                    }

                    cal = var10000;
                }
            }

            if (cal == null) {
                if (aLocale.getLanguage() == "th" && aLocale.getCountry() == "TH") {
                    cal = new BuddhistCalendar(zone, aLocale);
                } else if (aLocale.getVariant() == "JP" && aLocale.getLanguage() == "ja" && aLocale.getCountry() == "JP") {
                    cal = new JapaneseImperialCalendar(zone, aLocale);
                } else {
                    cal = new GregorianCalendar(zone, aLocale);
                }
            }

            return (Calendar)cal;
        }
    ```

2. 使用场景

    工厂模式将对象实例化代码抽取出来，放到一个类中统一管理和维护，达到和主项目的依赖解耦，提高项目的扩展和维护性。

## x.4 原型模式

### x.4.1 原型模式概述

用原型实例指定创建对象的各类，并通过拷贝原型创建新的对象。

### x.4.2 原型模式实现

```java
public class Sheep implements Cloneable {
    // ...

    /**
     * 克隆实例
     */
    @Override
    protected Object clone() {
        Sheep sheep = null;
        try {
            sheep = (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return sheep;
    }
}
```

1. 浅拷贝

    - 数据类型是基本数据类型的成员变量，浅拷贝会直接进行值传递，即将属性值复制一份到新对象
    - 数据类型是引用类型的成员变量，如数组、对象等，浅拷贝进行引用传递，即将该成员变量的引用值（内存地址）复制一份给新对象，实际上两个对象成员变量都指向同一个实例，此时修改一个对象的成员变量值会景致到另一个对象的值

2. 深拷贝

    - 复制对象的所有基本数据类型的成员变量值
    - 为所有引用数据类型的成员变量申请存储空间，并复制每个引用数据类型成员变量所引用的对象，直到该对象可达的所有对象

    ```java
     // 深拷贝，对象序列化实现
    public Object deepClone() {
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;

        try {
            // 序列化
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            // 当前对象以对象流的方式输出
            oos.writeObject(this);

             // 反序列化
            bais = new ByteArrayInputStream(baos.toByteArray());
            ois = new ObjectInputStream(bais);
            DeepProtoType copyObject = (DeepProtoType) ois.readObject();
            return copyObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                baos.close();
                oos.close();
                bais.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    ```

### x.4.3 源码分析

Spring 对象创建时配置原型属性

注意事项：

-   创建新对象比较复杂时，可复用原型模式简化对象创建，提高效率
-   原型模式不用重新初始化对象，而是动态地获得对象运行时状态
-   原始对象发生变化时，其它克隆对象也会发生相应变化
-   需要为每个类编写一个 clone 方法

## x.5 建造者模式

### x.5.1 建造者模式概述

建造者模式也叫生成器模式，是一种对象构建模式。可以将复杂对象的建造过程抽象出来，使用抽象过程的不同实现方法构造出不同表现的对象。

建造者模式是一步一步创建一个复杂的对象，它允许用户只通过指定复杂对象的类型和内容构建，用户不需要知道内部的具体构建细节。

1. 建造者模式的角色

    - Product: 产品角色，一个具体的产品对象
    - Builder: 抽象建造者，创建一个 Product 对象的各个部件指定的接口或抽象类
    - ConcreteBuilder: 具体建造者，实现接口，构建和装配各个部件
    - Director: 指挥者，构建一个使用 Builder 接口或抽象类的对象，主要用于创建一个复杂对象
        - 隔离了客户与对象的生产过程
        - 负责控制产品对象的生产过程

### x.5.2 建造者模式实现

### x.5.3 源码分析

JDK 中 StringBuilder 类：

## x.6 适配器模式

### x.6.1 适配器模式概述

1. 适配器模式简介

    适配器模式是结构型模式，将某个类的接口转换成客户端期望的另一个接口表示，主要目的是兼容性，让原本接口不匹配的两个类可以协同工作。

    适配器模式主要分为三类：类适配器模式、对象适配器模式、接口适配器模式。

2. 适配器模式工作原理

    将一个类的接口转换成另一种接口，让原本接口不兼容的类可以兼容。

    用户调用适配器转化出来的目标接口方法，适配器再调用被适配者的相关接口方法。

### x.6.2 类适配器模式

1. 类适配器模式简介

    `Adapter`类，通过继承 src 类，实现 dst 类接口，完成 `src -> dst` 的适配。

2. 类适配器模式实现

3. 类适配器模式分析

    - Java 是单继承机制，类适配器需要继承 src 类，要求 dst 必须是接口，有一定的局限性
    - src 类的方法在 Adapter 中都会暴露出来，增加了使用成本
    - 可以根据需要重写 src 类的方法，增强了 Adapter 的灵活性

### x.6.3 对象适配器模式

1. 对象适配器模式简介

    适配器模式常用的一种，将 Adapter 类加以修改，持有 src 类的实例，解决兼容性的问题。

2. 对象适配器模式实现
3. 对象适配器模式分析

### x.6.4 接口适配器模式

1. 接口适配器模式简介
2. 接口适配器模式实现
3. 接口适配器模式分析

## x.7 桥接模式

### x.7.1 桥接模式概述

桥接模式是一种结构型设计模式，将实现与抽象放在两个不同的类层次中，使两个层次可以独立地改变。

桥接模式甚于类的最小设计原则，通过使用封装、聚合及继承等行为让不同类承担不同职责，将抽象与行为分离开来。

### x.7.2 桥接模式实现

### x.7.3 源码分析

注意事项：

-   实现了抽象和实现的分离，极大提高了系统的灵活性，有助于系统分层设计，产生更好的结构化系统
-   对于系统高层部分，只需要知道抽象部分和实现部分的接口，其它由具体业务完成
-   桥接模式替代多层继承方式，可以减少子类个数

## x.8 装饰者模式

### x.8.1 装饰者模式概述

装饰者模式，动态地将新功能附加到对象上。

### x.8.2 装饰者模式实现

### x.8.3 源码分析

JDK 的 IO 结构中 FilterInputStream

## x.9 组合模式

### x.9.1 组合模式概述

组合模式也叫部分整体模式，它创建了对象组的树形结构，将对象组合成树状结构以表示“部分-整体”的层次关系。

组合模式使得用户对单个对象和组合对象的访问具有一致性，即组合能让客户以一致的方式处理个别对象以及组合对象。

### x.9.2 组合模式实现

### x.9.3 源码分析

JDK 中 Map 和 HashMap

注意事项：

-   简化客户端操作
-   具有较强的扩展性
-   方便创建出复杂的层次结构
-   需要遍历组织机构，或处理对象具有树形结构时，适合使用

## x.10 外观模式

### x.10.1 外观模式概述

外观模式也叫过程模式，它为子系统中的一组接口提供一个一致的界面，通过定义这个一致的接口，屏蔽内部子系统的细节，使得调用端只需跟这个接口发生调用，而无需关心子系统的内部细节。

外观模式就是解决多个复杂接口带来的使用困难，起到简化用户操作的作用。

### x.10.2 外观模式实现

### x.10.3 源码分析

MyBatis 中 Configuration 创建 MetaObject 对象：

注意事项：

-   外观模式对外屏蔽了子系统的细节，降低了客户端对子系统使用的复杂性
-   外观模式对客户端与子系统的耦合关系，让子系统内部的模块更易于维护和扩展
-   合理使用外观模式，可以更好地划分访问层次
-   使用外观模式，要以系统有层次、利于维护为目的

## x.10 享元模式

### x.10.1 享元模式概述

享元模式也是蝇量模式，运用共享技术有效地支持大量细粒度的对象，常用于系统底层开发，解决系统的性能问题，重点是重复对象的内存浪费。

-   内部状态：指对象共享出来的信息，存储在享元对象内部且不会随环境的改变而改变
-   外部状态：指对象得以依赖的标记，随环境改变而改变、不可共享的状态

### x.10.2 享元模式实现

### x.10.3 源码分析

JDK 中 Integer 类：

注意事项：

-   系统中有大量对象，需要消耗大量内存，并且对象的状态大部分可以外部化时，可以考虑使用享元模式
-   享元模式大大减少了对象的创建，降低了程序内存的占用，提高了效率
-   享元模式提高了系统的复杂度

## x.11 代理模式

### x.11.1 代理模式概述

代理模式为对象提供一个替身，以控制对该对象的访问，可以在目标对象实现的基础上，增强额外的功能操作，扩展目标对象的功能。

被代理的对象可以是远程对象、创建开销大的对象或需要安全控制的对象。

代理代工的形式：

-   静态代理
-   动态代理（JDK 代理）
-   Cglib 代理（可以在内存中动态创建对象，而不需要实现接口）

### x.11.2 静态代理

1. 静态代理简介

2. 静态代理实现

3. 静态代理分析

    - 在不修改目标对象功能的前提下，能够通过代理对象对目标功能进行扩展
    - 代理对象需要与目标对象实现一样的接口，产生很多代理类
    - 一旦接口增加方法，目标对象与代理对象都需要维护

### x.11.3 动态代理

1. 动态代理简介

    代理对象也叫 JDK 代理、接口代理，代理对象不需要实现接口，目标对象要实现接口，代理对象利用 JDK 的 API，动态在内存中构建代理对象。

2. 动态代理实现

3. 动态代理分析
