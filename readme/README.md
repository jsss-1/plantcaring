
#### 项目结构
项目采用按功能分模块的开发方式，结构如下

- `plcaring-common` 为系统的公共模块，各种工具类，公共配置存在该模块

- `plcaring-system` 为系统核心模块也是项目入口模块，也是最终需要打包部署的模块

- `plcaring-logging` 为系统的日志模块，其他模块如果需要记录日志需要引入该模块

- `plcaring-tools` 为第三方工具模块，包含：图床、邮件、云存储、本地存储、支付宝

- `plcaring-main` 为系统的功能模块
  - `plcaring-client` 为客户端模块
  - `plcaring-cloud` 为云端端模块

#### 详细结构

```
- plcaring-common 公共模块
    - annotation 为系统自定义注解
    - aspect 自定义注解的切面
    - base 提供了Entity、DTO基类和mapstruct的通用mapper
    - config 自定义权限实现、redis配置、swagger配置、Rsa配置等
    - exception 项目统一异常的处理
    - utils 系统通用工具类
- plcaring-system 系统核心模块（系统启动入口）
	- config 配置跨域与静态资源，与数据权限
	    - thread 线程池相关
	- modules 系统相关模块(登录授权、系统监控、定时任务、运维管理等)
- plcaring-logging 系统日志模块
- plcaring-tools 系统第三方工具模块
- plcaring-main 系统功能模块
    - `plcaring-client` 为客户端模块
    - `plcaring-cloud` 为云端端模块
```

