# 1
配置 application.properties 

jdbc.username=WnplV/ietfQ=
jdbc.password=WnplV/ietfQ=
他们是 DESUtil 加密   root WnplV/ietfQ=
可以在DESUtil.main方法中，输入你想改的密码（root）输出密钥（WnplV/ietfQ=）来修改username和password

配置  application-cloud.yml
redis


# 2
p1.sql 
完成增值服务所需的数据表


# 3
p2.sql

plant_condition 植物情况表
plant_zone      灌溉区表



# 4
plcaring-client 中的HelloClientController
plcaring-client 中的HelloCloudController
用来测试分模块能否直接调用

# 5
p3.sql
t_user 用户登录注册表

密码和账号一样

