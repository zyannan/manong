# manong

## 联系方式

- 邮箱 zyannan01@qq.com 

## IDE
```
IntelliJ IDEA 2020.2 (Ultimate Edition)
Build #IU-202.6397.94, built on July 27, 2020
Licensed to https://zhile.io
You have a perpetual fallback license for this version
Subscription is active until July 8, 2089
Runtime version: 11.0.7+10-b944.20 amd64
VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.
Windows 10 10.0
GC: ParNew, ConcurrentMarkSweep
Memory: 1967M
Cores: 8
Non-Bundled Plugins: GsonFormat
```

## 缺少jar包，无法通过pom自动下载
```
mvn install:install-file -Dfile=D:\ueditor-1.1.2.jar 							-DgroupId=com.baidu 	-DartifactId=ueditor 				-Dversion=1.1.2 			-Dpackaging=jar
mvn install:install-file -Dfile=D:\json.jar 		 							-DgroupId=com.json  	-DartifactId=json    				-Dversion=1.1   			-Dpackaging=jar
mvn install:install-file -Dfile=D:\fastdfs-client-java-1.29-SNAPSHOT.jar 		-DgroupId=org.csource   -DartifactId=fastdfs-client-java    -Dversion=1.29-SNAPSHOT   	-Dpackaging=jar
```

## Run/Debug Configurations
```
Name:manager
Working directory:D:/WorkspacesIdea/manong/manong_manager
Command line:clean tomcat7:run
```
```
Name:portal
Working directory:D:/WorkspacesIdea/manong/manong_portal
Command line:clean tomcat7:run
```
```
Name:rest
Working directory:D:/WorkspacesIdea/manong/manong_rest
Command line:clean tomcat7:run
```

## 本地maven配置文件修改

1. 配置镜像:
```
<mirror>
	<id>alimaven</id>
	<mirrorOf>central</mirrorOf>
	<name>aliyun maven mirror</name>
	<url>http://maven.aliyun.com/nexus/content/groups/public/</url>
</mirror>
```
2. 配置本地仓库
```
<localRepository>E:/mavenrepository</localRepository>
```

## 引用其他的仓库组件

1. [fastdfs](https://github.com/happyfish100/fastdfs)  [操作说明](https://github.com/happyfish100/fastdfs/wiki)
2. [fastdfs-client-java](https://github.com/happyfish100/fastdfs-client-java) 下载下来，用idea打开，install，生成fastdfs-client-java-1.29-SNAPSHOT.jar
3. [Tmall-pages](https://github.com/Catsugar/Tmall-pages)
4. [Mybatis-PageHelper](https://github.com/pagehelper/Mybatis-PageHelper) [操作说明](https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/zh/HowToUse.md)
5. [ueditor](https://github.com/fex-team/ueditor)



