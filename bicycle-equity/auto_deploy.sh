# 构建 Docker 镜像
#    -t 参数给镜像起个名字，这里使用了您的项目名,指定代理
docker build -t bicycle-equity-app:1.0 .

# 运行容器
#    -d: 后台运行
#    -p 8080:8080: 将容器的8080端口映射到虚拟机的8080端口
#    --name: 给容器起个名字，方便管理
docker run -d \
  --name equity-container \
  -v /data/logs/bicycle-equity:/app/logs \
  bicycle-equity-app:1.0