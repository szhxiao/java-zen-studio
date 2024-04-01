# QQZone

## 1. 业务需求

- 用户登录
- 登录成功，显示主界面，左侧显示好友列表，
- 查看日志详情

  - 日志本身信息（作者头像、昵称、日志标题、日志内容、日志日期）
  - 回复列表（回复者头像，昵称，回复内容，回复日期）
  - 主人回复信息

- 删除日志
- 删除特定回复
- 删除特定主人回复
- 添加日志，添加回复，添加主人回复
- 点击左侧好友链接，进入好友空间
## 2. 数据库设计

- 抽取实体

    用户登录信息、用户详情信息、日志、回帖、主人回复

- 分析属性

    - 用户登录信息：账号、密码、头像、昵称
    - 用户详情信息：真实姓名、性别、出生日期、邮箱、手机号
    - 日志：标题、内容、日期、作者
    - 回复：内容、日期、作者、日志
    - 主人回复：内容、日期、作者、回复

- 分析实体间的关系

    - 用户登录信息：用户详情信息，1:1 PK
    - 用户：日志 1:N
    - 日志：回复 1:N
    - 用户：好友 M:N
## 3. 数据库范式
    
- 第一范式：列不可再分
- 第二范式：一张表只表达一层含义（只描述一件事）
- 第三范式：表中的每一列和主键都是直接依赖关系，而不是间接依赖

数据库设计的范式和数据库查询性能很多时候是相悖的，需要根据实际业务选择：查询频次不高的情况下，更化身于提高数据库的设计范式，提高存储效率；查询频次很高时，更倾向提高查询性能。

## 4. 各模块功能实现

1. top.html页面显示登录者昵称、判断是否是自己的空间
   - 显示登录者昵称： ${session.userBasic.nickName}
   - 判断是否是自己的空间 : ${session.userBasic.id!=session.friend.id}
   如果不是期望的效果，首先考虑将两者的id都显示出来

2. 点击左侧的好友链接，进入好友空间
   - 根据id获取指定userBasic信息，查询这个userBasic的topicList，然后覆盖friend对应的value
   - main页面应该展示friend中的topicList，而不是userBasic中的topicList
   - 跳转后，在左侧（left）中显示整个index页面
     - 问题：在left页面显示整个index布局
     - 解决：给超链接添加target属性：   target="_top" 保证在顶层窗口显示整个index页面

   - top.html页面需要修改： "欢迎进入${session.friend}"
        top.html页面的返回自己空间的超链接需要修改：
        <a th:href="@{|/user.do?operate=friend&id=${session.userBasic.id}|}" target="_top">

3. 日志详情页面实现
    - 已知topic的id，需要根据topic的id获取特定topic
    - 获取topic关联的所有回复
    - 如果某个回复有主人回复，需要查询出来

4. 添加回复

5. 删除回复

    - 如果回复有关联的主人回复，需要先删除主人回复
    - 删除回复
      - 错误：java.sql.SQLIntegrityConstraintViolationException: 
      - Cannot delete or update a parent row: 
      - a foreign key constraint fails (`qqzonedb`.`t_host_reply`, CONSTRAINT `FK_host_reply` FOREIGN KEY (`reply`) REFERENCES `t_reply` (`id`))
        主人回复表中仍然有记录引用待删除的这条记录
        如果需要删除主表数据，需要首先删除子表数据

6. 删除日志