# 打包配置
>@author marz
>@date   2018-02-07:14:28:10

## 目的
1. 通过maven实现命令式打包

-------------------------------------
## 文件目录
package文件夹下，每个应用对应一个xml,列表如下:
1. api          ----  pom-api.xml
2. hall         ----  pom-hall.xml
3. manager      ----  pom-manager.xml
4. mdcenter     ----  pom-mdcenter.xml
5. mobile       ----  pom-mobile.xml
6. schedule     ----  pom-schedule.xml
7. server       ----  pom-server.xml
8. cache-service----  pom-cache-service.xml

-------------------------------------
## 环境配置
1.maven
2.jdk

## 使用方法:
1.使用终端进入配置文件目录:
```
  cd package-pom
```
2.执行命令:
```
  mvn clean package -DskipTests -f pom-api.xml
```

>其中: pom-api.xml 请自行填写相应需打包的应用配置

-------------------------------------
## 相关注意事项
1.项目结构如有调整，应该及时调整对应服务的配置
2.rcenter的打包只需直接执行对应pom文件即可
