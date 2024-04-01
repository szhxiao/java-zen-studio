# 第 16 章 HTML 和 CSS

## 16.1 HTML 简介

HTML 即 Hyper Text Markup Language，超文本标记语言。

## 16.2 HTML 标签

### 16.2.1 文档结构

```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title></title>
    </head>
    <body></body>
</html>
```

1. head 标签

    | 标签      | 说明                 |
    | --------- | -------------------- |
    | \<title>  | 定义文档标题         |
    | \<meta>   | 页面元数据           |
    | \<script> | 包含 JavaScript 脚本 |
    | \<link>   | 链接外部文件         |
    | \<style>  | 内部 CSS 样式        |

2. body 标签

    页面主要内容

### 16.2.2 常用标签

1.  块级标签

    | 标签            | 说明         |
    | --------------- | ------------ |
    | \<h1> ... \<h6> | 标题标签     |
    | \<p>\</p>       | 段落标签     |
    | \<hr>           | 水平线标签   |
    | \<ol>\</ol>     | 有序列表标签 |
    | \<ul>\<li>      | 无序列表标签 |
    | \<dl>\<dt>\<dd> | 定义描述标签 |
    | \<div>\</div>   | 分区标签     |

2.  行级标签

    -   文本格式化

        | 标签      | 含义         |
        | --------- | ------------ |
        | \<b>      | 粗体文本     |
        | \<i>      | 斜体文本     |
        | \<em>     | 强调文本     |
        | \<strong> | 定义         |
        | \<small>  | 小号文本     |
        | \<sub>    | 下标文本     |
        | \<sup>    | 上标文本     |
        | \<bdo>    | 文本显示方向 |

    -   超链接标签

        ```html
        <a href="URL" target=""></a>
        ```

    -   图像标签

        ```html
        <img src="" alt="" />
        ```

    -   其它

        \<span>

        \<br>

    -   常用特殊符号

        | 符号   | 含义 |
        | ------ | ---- |
        | \&nbsp | 空格 |
        | \&lti  | <    |
        | \&gti  | >    |
        | &copy  | 版权 |

3.  框架

    -   iframe

    -   frameset

4.  表格

    ```html
    <table>
     	<caption>标题</caption>
     	<thead>
     		<tr>
     			<td></td>
     		</tr>
     	<thead>
     	<tbody>
     		<tr>
     			<td></td>
     		</tr>
        <tbody>
    </table>
    ```

5.  表单

    -   form 标签

        -   action

            指定表单提交后服务器处理程序

        -   method

            指定服务器提交方式，get 或 post

    -   表单元素

        -   input

            | 标签     | 含义       |
            | -------- | ---------- |
            | text     | 单行文本   |
            | password | 密码       |
            | hidden   | 隐藏域     |
            | radio    | 单选框     |
            | checkbox | 复选框     |
            | image    | 图像域     |
            | file     | 文件上传域 |
            | submit   | 提交       |
            | reset    | 重置       |

        -   button

            ```html
            <button type=""></button>
            ```

            | 属性    | 含义                  |
            | ------- | --------------------- |
            | disable | 指定是否禁用          |
            | name    | 指定按钮名称          |
            | type    | button, reset, submit |

        -   select

        -   textarea

            ```html
            <textarea name="" cols="" rows="">
            ```

            | 属性     | 含义     |
            | -------- | -------- |
            | cols     | 指定宽度 |
            | rows     | 指定高度 |
            | readonly | 指定只读 |

## 16.3 CSS 简介

## 16.4 CSS 样式

### 16.4.1 CSS 声明引入

1. 内联样式

    将样式内联定义到具体元素上

2. 内部样式

    在 head 标签中使用 style 标签实现

3. 链接外部样式文件

    - CSS 与 HTML 文档分离，结构与表现分离，推荐使用。

### 16.4.2 CSS 选择器

1. 选择器类型

    - 标签选择器

        标签名{样式名 1:样式值 1;...}，为当前网页内所有标签添加相同样式

    - id 选择器

        #标签 id 属性值{样式名 1：样式值 1;...}，为某个指定的标签添加样式

    - 类选择器

        .类选择器名{样式名 1:样式值 1;...}，为不同标签添加相同的样式

    - 全部选择选择器

        \*{样式名 1:样式值 1;...}，选择所有标签，添加相同样式

    - 组合选择器

        选择器 1,选择器 2{样式名 1:样式值 1;...}

    - 子标签选择器

        选择器 1 选择器 2{样式名 1:样式值 1;...}

    - 属性选择器

        标签名[属性名=属性值]{样式名 1:样式值 1;...}

2. 选择器使用

    - 使用\*选择器来给整个页面添加基础样式

    - 使用类选择器给不同的标签添加基础样式

    - 使用标签选择器给某个标签添加基础样式

    - 使用 id，属性选择器，style 属性声明方式给某个标签添加个性化样式

### 16.4.3 CSS 盒子模型

1.  border

    设置元素边框

2.  padding

    控制 content 与 border 间的距离

3.  margin

    控制元素与元素间的距离

### 16.4.4 CSS 元素定位

1.  float

2.  position

    -   relative

        子块相对自身原有位置定位

    -   absolute

        子块脱离父块定位

3.  z-index

    调整定位时重叠块显示级别

### 16.4.5 常用样式属性

1. 字体属性

    | 样式        | 说明     |
    | ----------- | -------- |
    | font-family | 文本字体 |
    | font-size   | 字体尺寸 |
    | font-style  | 字体样式 |
    | font-weight | 字体粗细 |

2. 文本属性

    | 样式        | 说明     |
    | ----------- | -------- |
    | color       | 文本颜色 |
    | line-height | 文本行高 |
    | text-align  | 对齐方式 |

3. 边框属性

    | 样式         | 说明     |
    | ------------ | -------- |
    | border       | 边框属性 |
    | border-width | 边框宽度 |
    | border-style | 边框样式 |
    | border-color | 边框颜色 |

4. 背景属性

    | 样式                  | 说明                   |
    | --------------------- | ---------------------- |
    | background            | 所有背景属性           |
    | background-attachment | 背景图像是否固定       |
    | background-color      | 元素背景颜色           |
    | background-image      | 元素背景图像           |
    | background-position   | 背景图像开始位置       |
    | background-repeat     | 是否及如何重复背景图像 |

5. 列表属性

    | 样式                | 说明               |
    | ------------------- | ------------------ |
    | list-style          | 所有列表属性       |
    | list-style-image    | 图像为列表项标记   |
    | list-style-position | 列表项标记放置位置 |
    | list-style-type     | 列表项标记类型     |

6. 表格属性

    | 样式            | 说明                         |
    | --------------- | ---------------------------- |
    | border-collapse | 是否把表格边框合并为单一边框 |
    | border-spacing  | 分隔单元格边框的距离         |
    | caption-side    | 标题位置                     |
    | empty-cells     | 是否显示表格空单元格         |
