# message-dingtalk
## 说明
本项目是对钉钉API的一次封装    

其中部分API是自己封装，部分使用淘宝提供的JDK，只是对实体进行了再次封装  

[钉钉官方文档地址](https://open-doc.dingtalk.com/docs/doc.htm?spm=a219a.7629140.0.0.ouVZC1&treeId=172&articleId=104981&docType=1)
## 使用
项目是在SpringBoot之上进行建立的，所以使用起来还是比较简单。
SpringBoot项目仅仅需要，在项目中加入依赖。   

并在配置文件中加入  
```
  dingtalk.corpid=your_corpid
  dingtalk.corpsecret=your_corpsecret
  dingtalk.agentid=your_agentid  
```
同时使用注解在启动文件上加入本包的扫描
```
@ComponentScan(basePackages = { "com.yeehaw.message" })
```
## 调用
### 消息

```
DingTalkMessageUtils.sendCompanySynMessage(BaseMessageRequest request)
```
发送企业同步消息，request请求封装了除OA消息的所有消息类型，[具体消息类型可以查看钉钉官方文档](https://open-doc.dingtalk.com/docs/doc.htm?spm=a219a.7629140.0.0.3b0zrH&treeId=172&articleId=104972&docType=1)    

其中消息请求封装在``com.yeehaw.message.dingTalk.message.request``包下，回调在相应``response``包下  

### 部门    
具体参数封装在``com.yeehaw.message.dingTalk.department``包下
```
//获取部门列表，根部门ID为 1 
DingTalkDepartmentUtils.getDepartmentList(String departmentId)
//获取部门详细信息
DingTalkDepartmentUtils.getDepartmentDetail(String departmentId)
//创建部门
DingTalkDepartmentUtils.createDepartment(DepartmentDetail detail)
//更新部门
DingTalkDepartmentUtils.updateDepartment(DepartmentDetail detail)
//删除部门
DingTalkDepartmentUtils.delete(String departmentId)
```

### 员工
具体参数封装在``com.yeehaw.message.dingTalk.role``包下
```
//获取角色列表
DingTalkRoleUtils.getRoleList()
//获取员工列表，分页
DingTalkRoleUtils.getUserListByRoleIdByPage(Long id, Long off, Long size)
//获取员工列表，默认分页 第一页 20条
DingTalkRoleUtils.getUserListByRoleIdDefault(Long id)
```

### 示例 
```
//获取部门列表
List<Department> departments = DingTalkDepartmentUtils.getDepartmentList("1");
for(Department department:departments) {  
    MarkdownMessage markdownMessage = new MarkdownMessage("这是markdown测试信息", "###标题 \n **貌似是粗体**");  
    MarkdownMessageRequest request = new MarkdownMessageRequest(markdownMessage);  
    request.setToparty(department.getId().toString());  
    DingTalkMessageUtils.sendCompanySynMessage(request);  
}         
```