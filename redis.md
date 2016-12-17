安装redis
[root@iZuf6ayj54m6qqykp29r2bZ iccspace]# wget -q http://download.redis.io/releases/redis-3.2.1.tar.gz
[root@iZuf6ayj54m6qqykp29r2bZ iccspace]# ll redis-3.2.1.tar.gz
-rw-r--r-- 1 root root 1534696 Jun 17 21:16 redis-3.2.1.tar.gz
[root@iZuf6ayj54m6qqykp29r2bZ iccspace]# tar -xzf redis-3.2.1.tar.gz
[root@iZuf6ayj54m6qqykp29r2bZ iccspace]# cd ./redis-3.2.1
[root@iZuf6ayj54m6qqykp29r2bZ redis-3.2.1]# make

启动redis
[root@iZuf6ayj54m6qqykp29r2bZ redis-3.2.1]# src/redis-server redis.conf
                _._                                                  
           _.-``__ ''-._                                             
      _.-``    `.  `_.  ''-._           Redis 3.2.1 (00000000/0) 64 bit
  .-`` .-```.  ```\/    _.,_ ''-._                                   
 (    '      ,       .-`  | `,    )     Running in standalone mode
 |`-._`-...-` __...-.``-._|'` _.-'|     Port: 6379
 |    `-._   `._    /     _.-'    |     PID: 12102
  `-._    `-._  `-./  _.-'    _.-'                                   
 |`-._`-._    `-.__.-'    _.-'_.-'|                                  
 |    `-._`-._        _.-'_.-'    |           http://redis.io        
  `-._    `-._`-.__.-'_.-'    _.-'                                   
 |`-._`-._    `-.__.-'    _.-'_.-'|                                  
 |    `-._`-._        _.-'_.-'    |                                  
  `-._    `-._`-.__.-'_.-'    _.-'                                   
      `-._    `-.__.-'    _.-'                                       
          `-._        _.-'                                           
              `-.__.-'                                               

12102:M 06 Dec 11:39:41.931 # WARNING: The TCP backlog setting of 511 cannot be enforced because /proc/sys/net/core/somaxconn is set to the lower value of 128.

客户端连接--停止redis服务
[root@iZuf6ayj54m6qqykp29r2bZ redis-3.2.1]# src/redis-cli
127.0.0.1:6379> 
[root@iZuf6ayj54m6qqykp29r2bZ redis-3.2.1]# src/redis-cli shutdown

#关闭防火墙
[root@iZuf6ayj54m6qqykp29r2bZ redis-3.2.1]# service iptables stop
[root@iZuf6ayj54m6qqykp29r2bZ redis-3.2.1]# service iptables start
#bind 设置0.0.0.0

#requirepass root
1. server端，redis.conf设置：

requirepass yourpassword

2. client端用auth AUTH – Redis

$ redis-cli -h xx.xx.xx.xx
> keys *
(error) NOAUTH Authentication required.
> auth yourpassword
OK
> keys *
1) "xx"
2) "etc..."

#redis安装及系统服务

[root@iZuf6ayj54m6qqykp29r2bZ iccspace]# cd redis-3.2.1
[root@iZuf6ayj54m6qqykp29r2bZ redis-3.2.1]# make PREFIX=/opt/redis install

[root@iZuf6ayj54m6qqykp29r2bZ redis-3.2.1]# cp redis.conf /opt/redis/conf/6379.conf
[root@iZuf6ayj54m6qqykp29r2bZ redis-3.2.1]# cp utils/redis_init_script /etc/init.d/redisd

[root@iZuf6ayj54m6qqykp29r2bZ redis-3.2.1]# vim /etc/init.d/redisd
注册服务
[root@iZuf6ayj54m6qqykp29r2bZ redis-3.2.1]# chkconfig --add redis
开机自启动
[root@iZuf6ayj54m6qqykp29r2bZ redis-3.2.1]# chkconfig redisd on
打开
[root@iZuf6ayj54m6qqykp29r2bZ redis-3.2.1]# service redisd start
关闭
[root@iZuf6ayj54m6qqykp29r2bZ redis-3.2.1]# service redisd stop
查看后台进程是否存在
[root@iZuf6ayj54m6qqykp29r2bZ redis-3.2.1]# ps -ef| grep redisd
root     13704 29466  0 14:50 pts/1    00:00:00 grep redisd
检测6379端口是否在监听
[root@iZuf6ayj54m6qqykp29r2bZ redis-3.2.1]# netstat -lntp |grep 6379
tcp        0      0 0.0.0.0:6379                0.0.0.0:*                   LISTEN      13642/redis-server  

#!/bin/sh
# chkconfig:2345 80 90
# Simple Redis init.d script conceived to work on Linux systems
# as it does use of the /proc filesystem.

REDISPORT=6379
EXEC=/opt/redis/bin/redis-server
CLIEXEC=/opt/redis/bin/redis-cli

PIDFILE=/var/run/redis_${REDISPORT}.pid
CONF="/opt/redis/conf/${REDISPORT}.conf"

修改daemonize yes 默认以后台程序方式运行
修改生产日志文件位置logfile "/opt/redis/logs/redis.log"
配置持久化文件位置 dir /
[root@iZuf6ayj54m6qqykp29r2bZ redis-3.2.1]# service redisd start
Starting Redis server...

#将redis的命令目录添加到系统参数path中(# source /etc/profile)
[root@iZuf6ayj54m6qqykp29r2bZ redis-3.2.1]# vi /etc/profile
export PATH="$PATH:/opt/redis/bin"
[root@iZuf6ayj54m6qqykp29r2bZ redis-3.2.1]# . /etc/profile
[root@iZuf6ayj54m6qqykp29r2bZ redis-3.2.1]# redis-cli 
127.0.0.1:6379> auth root
OK
127.0.0.1:6379> 

