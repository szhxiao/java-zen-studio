# 第 18 章 Vue.js

## 18.1 初识 Vue

### 18.1.1 Vue 是什么

### 18.1.2 Vue 特点

1. 组件化模式
2. 声明式编码
3. 虚拟 DOM+Diff 算法

### 18.1.3 Hello Vue

引入 Vue.js

```js
<!-- 开发环境版本，包含了有帮助的命令行警告 -->
<script src="https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js"></script>

<!-- 生产环境版本，优化了尺寸和速度 -->
<script src="https://cdn.jsdelivr.net/npm/vue@2"></script>

<!-- cdn.jsdelivr可能出现异常，可替代 -->
<script src="https://unpkg.zhimg.com/vue@2/dist/vue.js"></script>
<script src="https://unpkg.com/vue@2/dist/vue.js"></script>
```

```javascript
new Vue({
    // el用于指定当前Vue实例为哪个容器服务，值通常为css选择器字符
    el: "#app",
    // data用于存储数据，数据供el所指定的容器使用
    data: {
        message: "Hello Vue!"
    }
});
```

-   el
-   data

    -   对象式
    -   函数式

    学习组件时，data 必须使用函数式，否则会报错

## 18.2 Vue 核心

### 18.2.1 Vue 模板语法

1. 插值

    用于解析标签体的内容。

    ```vue
    <h1>{{message}}</h1>
    ```

2. 指令

    用于解析标签（如标签属性、标签体内容、绑定事件等）

    ```vue
    <a v-bind:href="url">B站大学</a>
    <!-- v-bind可简写为: -->
    <a :href="url">B站大学</a>
    ```

### 18.2.2 数据绑定

1. 单向数据绑定

    使用 v-bind 指令，数据只能从 data 流向页面。

    ```vue
    <input type="text" v-bind:value="name" />
    ```

2. 双向数据绑定

    使用 v-model:value(可简写为:v-model)指令，一般应用于表单类元素（如：input,select）

    ```vue
    <input type="text" v-model:value="name" />
    ```

### 18.2.3 MVVM 模型

    ![MVVM模型](../resources/images/MVVM模型.png)

    - M：模型(Model)，data中的数据
    - V：视图(View)，模板代码
    - VM：视图模型(ViewModel)，Vue实例

    vm所有的属性及Vue原型上的所有属性，在Vue模板中都可以直接使用。

### 18.2.4 数据代理

Object.defineProperty 方法

通过一个对象代理对另一个对象中属性的操作：读/写。

通过 vm 对象来代理 data 对象中属性的操作（读/写），更加方便地操作 data 中的数据。

基本原理：通过 Object.defineProperty()方法把 data 对象中所有属性添加到 vm 上，为每一个添加到 vm 上的属性，都指定一个 getter/setter，在 getter/setter 内部去操作 data 中对应的属性。

### 18.2.5 事件处理

1. 事件基本使用

    使用 v-on:xxx 或@xxx 绑定事件，其中 xxx 是事件名；事件回调需要配置在 methods 对象中，最终会在 vm 上，methods 中配置的函数都是被 Vue 管理的函数，this 的指向是 vm 或组件实例对象。

2. 事件修饰符

    - prevent

        阻止默认事件

    - stop

        阻止事件冒泡

    - once

        事件只触发一次

    - capture

        使用事件捕获模式

    - self

        只有 event,target 是当前操作的元素时才触发事件

    - passive

        事件默认行为立即执行，无需等待事件回调执行完毕

3. Vue 中常用按键别名

    | 按键       | 别名   | 备注                                                      |
    | ---------- | ------ | --------------------------------------------------------- |
    | 回车       | enter  |
    | 删除       | delete | 捕获“删除”和“退格”键                                      |
    | 退出       | esc    |
    | 空格       | space  |
    | 换行       | tab    | 必须配合 keydown 使用                                     |
    | 上         | up     |
    | 下         | down   |
    | 左         | left   |
    | 右         | right  |
    | 系统修饰键 | ctrl   | 配合 keyup 使用，按下修饰键的同时，再按下其他键，事件触发 |
    |            | shift  | 配合 keydown 使用，正常触发事件(不推荐)                   |
    |            | alt    |
    |            | meta   |

### 18.2.6 计算属性

1. 定义

    要用的属性不存在，通过已有属性计算得到。

2. 原理

    底层借助了 Object,defineproperty 方法提供的 getter 和 setter。

```vue
new Vue({ el: "#root", data:{ firstName:"bilibili", lastName:"university" }, computed:{ fullName:{ get(){ return
this.firstName + "-" + this.lastName; } } } })
```

3. get

    get 调用时机：

    - 初次读取计算属性时
    - 所依赖的数据发生变化时

计算属性相比于 methods 实现，内部有缓存机制，效率更高。

计算属性最终会出现在 vm 上，直接读取使用即可，如果计算属性要被修改，必须写 set 方法去响应修改。

### 18.2.7 侦听属性

1. 侦听属性

    - 当被侦听的属性变化时，回调函数自动调用，执行相关操作
    - 监视属性必须存在，才能进行监视
    - 两种写法：
        - new Vue 时传入 watch 配置
        - 通过 vm.$watch 监视

2. 深度侦听

    - Vue 中的 watch 默认不监测对象内部值的改变
    - 配置 deep:true 可以监测对象内部值的改变
    - 使用 watch 时根据数据具体结构，决定是否采用深度侦听

3. 对比 computed 与 watch

    - computed 能完成的功能，watch 都可以完成；
    - watch 能完成的功能，computed 不一定能完成，如 watch 可以进行异步操作。

    重要原则：

    - 被 Vue 管理的函数，最好写成普通孙灵，此时 this 指向才是 vm 或组件实例对象；
    - 所有不被 Vue 管理的函数（定时器的回调函数、ajax 的回调函数），最好写成箭头函数，此时 this 的指向才是 vm 或组件实例对象。

### 18.2.8 绑定 class 样式

1. class 样式

2. style 样式

### 18.2.9 条件渲染

1. 条件渲染指令

    - v-show

        不展示的 DOM 元素未被移除，仅使用样式隐藏，适用于切换频率较高的场景。

    - v-if

        不展示的 DOM 元素直接被移除，适用于切换频率较低的场景，可以配合 template, v-else-if, v-else 使用。

### 18.2.10 列表渲染

最好使用每条数据的唯一标识作为 key。

Vue 会监视 data 中所有层次的数据。

1. 监测对象中的数据

    通过 setter 实现监视，且要在 new Vue 时就传入要监测的数据。

    - 对象中后追加的属性，Vue 默认不做响应式处理
    - 如需给后添加的属性做响应式，使用 Vue.set(target, propertyName/index, value), vm.$set(target, propertyName/index, value)

2. 监测数组中的数据

    通过数组更新元素的方法实现，本质上做了：

    - 调用原生对应的方法对数组进行更新
    - 重新解析模板，进行更新页面

    Vue.set()和 vm.$set()不能给 vm 或 vm 的根数据对象添加属性。

### 18.2.11 收集表单数据

-   `<input type="text"/>`，则 v-model 收集的是 value 值，即用户输入
-   `<input type="radio"/>`，则 v-model 收集的是 value 值，要给标签配置 value 值
-   `<input type="checkbox"/>`
    -   没有配置 input 的 value 属性，收集的就是 checked(布尔值);
    -   配置 input 的 value 属性，v-model 的初始值是非数组，收集的就是 checked；v-model 的初始值是数组，收集的就是 value 组成的数组

v-model 的第二个修饰符：

-   lazy 失去焦点再收集数据
-   number 输入字符串转为有效的数字
-   trim 输入首尾空格过滤

### 18.2.12 过滤器

过滤器对要显示的数据进行特定格式化后再显示（适用于一些简单逻辑的处理）。

过滤器也可以接收额外参数、多个过滤器也可以串联。

过滤器并没有改变原本的数据，是产生新的对应的数据。

### 18.2.13 指令

1. 常用指令

| 指令    | 作用                                 | 备注                                                          |
| ------- | ------------------------------------ | ------------------------------------------------------------- |
| v-bind  | 单向顷字解析表达式                   | 可简写为:xxx                                                  |
| v-model | 双向数据绑定                         |
| v-for   | 遍历数组、对象、字符串               |
| v-on    | 绑定事件监听                         | 可简写为@                                                     |
| v-if    | 条件渲染，动态控制节点是否存在       |
| v-else  | 条件渲染，动态控制节点是否存在       |
| v-show  | 条件渲染，动态控制节点是否展示       |
| v-text  | 向所在节点插入文本                   | 插值语法使用较多                                              |
| v-html  | 向指定节点中渲染包含 html 结构的内容 | 存在安全性问题，容易导致 XSS 攻击，不要在用户提交的内容上使用 |
| v-cloak |
| v-once  | 跳过所在节点的编译过程               | 没有使用指令语法、没有使用插值语法的节点，会加快编译          |

2. 自定义指令

### 18.2.14 生命周期

生命周期即生命周期回调函数，是 Vue 在关键时刻调用的一些特殊名称的函数，生命周期函数中的 this 指向 vm 或组件实例对象。

-   beforeCreate()
-   created()
-   beforeMount()
-   mounted()
-   beforeUpdate()
-   updated()
-   beforeDestroy()
-   destroyed()

## 18.3 Vue 组件化编程

### 18.3.1 模块与组件、模块化和组件化

1. 模块

    - 向外提供特定功能的 js 程序，一般是一个 js 文件
    - 作用：复用 js，简化 js 的编写，提高 js 运行效率

2. 组件

    - 组件是实现应用中局部功能代码和资源的集合
    - 作用：复用编码，提高运行效率

3. 模块化

4. 组件化

### 18.3.2 非单文件组件

1.  组件名

    | 组件名       | 写法       | 示例      | 备注                                     |
    | ------------ | ---------- | --------- | ---------------------------------------- |
    | 一个单词组成 | 首字母小写 | school    | 组件名尽可能回避 HTML 标签中已有的元素名 |
    |              | 首字母大写 | School    |
    | 多个单词组成 | kebab-case | my-school |
    |              | CameCase   | MySchool  | 需要 Vue 脚手架支持                      |

2.  组件标签

    | 组件标签 | 示例       |
    | -------- | ---------- |
    | 小写     | \<school\> |
    | 大写     | \<School\> |

3.  组件嵌套

4.  VueComponent

    组件的本质是一个名为 VueComponent 的构造函数，是由 Vue.extend 生成的。

    每次调用 Vue.extend 返回的都是一个全新的 VueComponent

    this 指向：

        - 组件配置中，data,methods, watch, computed中的函数的this均是VueComponent实例对象
        - .new Vue(options)配置中，data, methods, watch, computed中的函数中的this均是Vue实例对象

5.  一个重要的内置关系

    `school.prototype.__proto__ === Vue.prototype`

    组件实例对象可以访问到 Vue 原型上的属性、方法。

### 18.3.3 单文件组件

### 18.3.4 使用 Vue 脚手架

1. 初始化脚手架

    Vue 脚手架是 Vue 官方提供的标准化开发工具（开发平台）。

    - 安装 Vue 脚手架

    > npm install -g @vue/cli

    - 检查版本

    > vue --version

2. 脚手架文件结构

    ![脚手架文件结构](../resources/images/vue-cli-files.png)

    注：使用`vue inspect > output.js`可以查看 Vue 脚手架的默认配置，可以使用 vue.config.js 进行修改化定制。

3. 具体步骤

### 18.3.5 Vue 脚手架及属性

1. 脚手架

2. ref 属性

    为元素或子组件注册引用信息，当应用在 html 标签上时获取的是真实 DOM 元素，应用在组件标签时获取的是组件实例对象。

    ```javascript
    <h1 v-text="msg" ref="title"></h1>
    ```

3. props 配置

    让组件接收外部传来的数据，适用于父组件与子组件间的通信，用于子组件与父组件通信时要求父组件先给子组件一个函数。

    - 传递数据

        ```javascript
        <Demo name="xxx">
        ```

    - 接收数据

        ```javascript
        // 只接收
        props:['name']

        // 限制类型
        props:{
            name:Number
        }

        // 限制类型、必要性及默认值
        props:{
            name:{
                type:String,
                required:true
                default:''
            }
        }
        ```

4. mixin 混入属性

    把多个组件共用的配置提取成一个混入对象。

    使用：

    - 定义混入

        ```javascript
        {
            data(){
                ...
            },
            methods:{
                ...
            }
        }
        ```

    - 使用混入

        ```javascript
        // 全局混入
        Vue.mixin(xxx);

        // 局部混入
        mixins: ["xxx"];
        ```

5. 插件

6. scoped 样式

    使样式在局部生效，防止冲突。

### 18.3.6 TodoList 案例

1. 组件化编码流程

    - 拆分静态组件

        组件要按功能点拆分，命名不能与 html 元素冲突。

    - 实现动态组件

        考虑好数据的存放位置：

        - 一个组件使用：放在组件自身即可
        - 一些组件使用：放在他们共同的父组件上（状态提升）

### 18.3.7 组件的自定义事件

组件自定义事件是一种组件间的通信方式，适用于子组件向父组件传递信息。

1. 绑定自定义事件

    ```javascript
    <Demo v-on:eventName="functionName">
    <Demo @eventName="functionName">
    ```

    只触发一次时使用`once`修饰。

2. 触发自定义事件

    ```javascript
    this.$emit("eventName");
    ```

3. 解绑自定义事件

    ```javascript
    this.$off("eventName");
    ```

### 18.3.8 全局事件总线

用于任意组件间通信。

使用步骤：

-   安装全局事件总线

    ```javascript
    new Vue({
        el: "#app",
        render: (h) => h(App),
        beforeCreate() {
            // 安装全局事件总线
            Vue.prototype.$bus = this;
        }
    });
    ```

-   接收数据

    ```javascript
    methods() {
        demo(data){
            ...
        }
    },
    mounted() {
        this.$bus.$on('xxx', this.demo)
    }
    ```

-   提供数据

    ```javascript
    this.$bus.$emit("xxx", 数据);
    ```

-   解绑事件

    ```javascript
    this.$bus.$off("xxx");
    ```

### 18.3.9 消息订阅与发布

消息订阅与发布是一种适用于任意组件间通信的组件间通信方式。

使用步骤：

-   安装 pubsub

    `npm i pubsub-js`

-   引入 pubsub

    `import pubsub from 'pubsub-js'`

-   接收数据

    ```javascript
    methods(){
        demo(message, data) {
            ...
        }
    },
    mounted() {
        this.pid = pubsub.subscribe('xxx', this.demo)
    }
    ```

-   提供数据

    ```javascript
    pubsub.publish("xxx", 数据);
    ```

-   取消订阅

    ```javascript
    pubsub.unsubscribe(pid);
    ```

### 18.3.10 过渡与动画

过渡与动画在插入、更新或移除 DOM 元素时，可以在合适的时候给元素添加样式类名。

使用步骤：

-   准备好样式

    -   元素进入的样式

        -   v-enter 进入的起点
        -   v-enter-active 进入过程中
        -   v-enter-to 进入的终点

    -   元素离开的样式

        -   v-leave 离开的起点
        -   v-leave-active 离开的过程中
        -   v-leave-to 离开的终点

-   使用`<transition></transition>`包裹要过渡的元素，并配置 name 属性，有多个元素时使用`<transition-group></transition-group>`，并配置 key 属性

## 18.4 vue 中的 ajax

## 18.5 vuex

### 18.5.1 vuex 概述

专门在 Vue 中实现集中式状态（数据）管理的 Vue 插件，对 Vue 应用中多个组件的共享状态进行集中式的管理，也是一种组件间的通信方式，且适用于任意组件间通信。

### 18.5.2 什么时候使用 Vuex

1. 多个组件依赖于同一状态
2. 来自不同组件的行为需要变更同一状态
