# SpringSecurity+JWT整合Demo

> 本项目是整合SpringSecurity和JWT的Demo，SpringSecurity是Spring家族中的的安全框架。

#### 项目实现：
1. 基础的认证和鉴权
2. 认证通过验证token的有效性判断
3. 鉴权通过角色来匹配

#### 项目结构
config:配置文件

controller:测试认证鉴权的接口

entity:返回实体类相关

exception:异常处理器（token认证和鉴权错误处理器）

filter:过滤器，token验证正确后，向SpringSecurity添加权限信息

util:JWT工具类。生成，验证，获取token角色信息等

#### 正式使用改造
1. 添加数据库链接
2. 把生成token的参数修改为数据库查询出来的id和角色信息


#### 注意事项
1. @PreAuthorize 注解中的参数是角色名称
> 动态权限设置
> https://www.maosi.vip/2021/09/11/springsecurity%ef%bc%9a%e5%ae%9e%e7%8e%b0%e6%8e%a5%e5%8f%a3%e5%8a%a8%e6%80%81%e6%9d%83%e9%99%90/