# 第 17 章 JavaScript

## 17.1 JavaScript 基础语法

### 17.1.1 变量

1. 变量概述
2. 定义变量

    ```js
    var var_name = var_value;
    ```

### 17.1.2 数据类型

1. 数值型

    number

2. 字符串类型

    string

3. 对象类型

    object

4. 布尔类型

    boolean

    非零数值、非空字符串、非空对象均为 true；零、空字符串、null、undefined 均为 false。

5. 函数类型

    function

6. 特殊值

    - undefined

        未定义，所有 js 变量未赋初始值时，默认为 undefined

    - null

        空值

    - NAN

        即 Not A Number，非数字，非数值

JavaScript 是弱类型语言，变量数据类型由值的类型决定。

### 17.1.3 运算符

1. 比较运算符

    | 运算符 | 含义   | 说明                 |
    | ------ | ------ | -------------------- |
    | ==     | 等于   | 字面量比较           |
    | ===    | 全等于 | 比较字面量和数据类型 |

2. 逻辑运算符

    在 JavaScript 中，所有变量都可以作为 boolean 类型的变量使用。

### 17.1.4 数组

## 17.2 函数

### 17.2.1 定义函数

注意：JavaScript 中不允许函数重载，同名函数最后的定义会覆盖前面的所有定义。

### 17.2.2 隐形参数 arguments

## 17.3 面向对象

### 17.3.1 自定义对象

```js
var objectName = new Object();
```

```js
var objectName = {
    属性名: 属性值,
    函数名: 函数体
};
```

## 17.4 事件

### 17.4.1 事件概述

1. 事件概念
2. 事件注册

    - 静态注册
    - 动态注册

### 17.4.2 常见事件

1. onload
2. onclick
3. onblur
4. onchange
5. onsubmit

## 17.5 DOM 模型

### 17.5.1 Document 对象
