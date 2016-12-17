##多环境配置文件设置方式
java -jar xxx.jar  --spring.profiles.active=prod
##置顶外部的配置文件
java -jar demo.jar --spring.config.location=/opt/config/application.properties

##start.sh
#!/bin/sh 
rm -f tpid #删除tpid文件
nohup java -jar /mnt/iccspace/icc-wechat-mgmt-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod > /dev/null 2>&1 & #这里可以配置使用的配置文件  把控制台输出流输出到cmd.out文件
echo $! > tpid #记录进程id 以便杀死进程
echo Start Success! #输出成功的信息

##stop.sh
tpid=`cat tpid | awk '{print $1}'` tpid=`ps -aef | grep $tpid | awk '{print $2}' |grep $tpid`
if [ ${tpid} ]; then
 kill -9 $tpid
fi

##check.sh
#!/bin/sh 
tpid=`cat tpid | awk '{print $1}'`
tpid=`ps -aef | grep $tpid | awk '{print $2}' |grep $tpid`
if [ ${tpid} ]; then
        echo App is running.
else
        echo App is NOT running.
fi

##kill.sh
#!/bin/sh
# kill -9 `ps -ef|grep 项目名称|awk '{print $2}'`
kill -9 `ps -ef|grep demo|awk '{print $2}'`


查看进程PID所属的应用
ps -ef | grep java
查看PID对应的应用
ps -aux | grep 21512
端口监听
netstat -apn | grep 8896
sudo权限查看所有PID
sudo netstat -antup

[root@iZuf6ayj54m6qqykp29r2bZ ~]# netstat -ntlp
Active Internet connections (only servers)
Proto Recv-Q Send-Q Local Address               Foreign Address             State       PID/Program name   
tcp        0      0 0.0.0.0:8895                0.0.0.0:*                   LISTEN      19904/java          
tcp        0      0 0.0.0.0:8896                0.0.0.0:*                   LISTEN      21512/java          
tcp        0      0 127.0.0.1:8005              0.0.0.0:*                   LISTEN      19904/java          
tcp        0      0 0.0.0.0:8009                0.0.0.0:*                   LISTEN      19904/java          
tcp        0      0 0.0.0.0:3306                0.0.0.0:*                   LISTEN      31408/mysqld        
tcp        0      0 0.0.0.0:3690                0.0.0.0:*                   LISTEN      4398/svnserve       
tcp        0      0 0.0.0.0:80                  0.0.0.0:*                   LISTEN      31781/nginx         
tcp        0      0 0.0.0.0:22                  0.0.0.0:*                   LISTEN      1206/sshd 