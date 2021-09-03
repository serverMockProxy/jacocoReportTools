# jacocoReportTools  
## 环境  
- windows | linux | macos  
- java8  
- mysql5.7  
## 源码打包
### 前端  
1.进入frontend目录运行npm install 安装依赖
2.运行npm run build:prod编译前端代码  
### 服务端  
1.数据库连接地址配置，修改application-dev.properties文件的数据库地址  
2.修改application.properties文件中 gitToken和gitHost,gitToken需要能访问自己公司要申请jacoco报告的gitlab权限,需要在对应账号中获得token，要开通api权限gitHost中的localhost改成自己公司的gitlab的host  
3.使用maven打包项目,成功后会在target目录中生成XXX-1.1.0.tar.gz文件  
## 运行项目  
### 启动平台服务  
1.将XXX-1.1.0.tar.gz文件解压后，运行java -jar main.jar就可以启动项目了。  
### jacocoagent配置  
1.将项目中的jacocoagent.jar推送到被测服务器目录下  
2.被测项目启动时添加以下参数  
 -javaagent:/服务器中的路径/jacocoagent.jar=serverhost=http://localhost:8080,projectname=skatoolsserver,uploadtime=1  
#### 参数说明  
1.serverhost：平台服务地址  
2.projectname：被测项目在gitlab中的路径，如：https://localhost/test/skatoolsserver  
3.uploadtime：上传exec文件间隔时间（分钟）
4.还可以添加其他的jacoco的参数，如include等，具体可以搜一下。     
![image](https://user-images.githubusercontent.com/31475053/131990729-8d12f6d7-c2c6-41bc-bed6-493ebdcb5f22.png)

     
