# message-dingtalk
## 说明
本项目是对钉钉API的一次封装  
其中部分API是自己封装，部分使用淘宝提供的JDK，只是对实体进行了再次封装
## 使用
项目是在SpringBoot之上进行建立的，所以使用起来还是比较简单，仅仅需要，在项目中加入依赖。  
并在配置文件中加入  
```
  dingtalk.corpid=your_corpid
  dingtalk.corpsecret=your_corpsecret
  dingtalk.agentid=your_agentid  
```
项目应该就能正常使用了