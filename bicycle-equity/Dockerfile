# 使用轻量级的JRE镜像
FROM openjdk:17-jdk-slim
# 设置工作目录
WORKDIR /app

# 将宿主机的 jar包复制到镜像中，并命名为 app.jar (或者您也可以保留原名)
# ！！！重点：这里的源jar包名称必须和您打包出来的文件名一致 ！！！
COPY bicycle-equity-0.0.1-SNAPSHOT.jar app.jar

# 暴露端口 (根据您的application.properties或application.yml中的server.port配置修改)
EXPOSE 8080

# 启动命令
ENTRYPOINT ["java", "-jar", "app.jar"]

# 如果需要指定激活的生产环境配置文件，可以这样写：
# ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "app.jar"]