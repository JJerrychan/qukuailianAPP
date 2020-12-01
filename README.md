# qukuailianAPP

### 项目环境

- Android SDK - aip29
- Gradle 6.1.1
- JDK 1.8


### 目录架构

    / app / src / main / java / com / cq / xinyupintai / data / model   ##存放数据对象模型

    / app / src / main / java / com / cq / xinyupintai / Presenter    ##存放视图操作

    / app / src / main / res    ##存放所有资源文件包括界面布局

### 客户端往服务器发送数据的JSON格式：

    （1）功能码ReqCode：界面号+序号，如“B001001”，B001为界面号，001为序号
         如："ReqCode":"B001001"

    （2）数据Data：JSON格式
	        如："Data":{
        		"LoginName": "Zhangsan",
        		"Password": "123456"
        		}
### 服务器给客户端反馈信息的JSON格式：

    （1）状态码RespId: (三位整数)
                如："RespId": 111
        服务器反馈的状态码：000成功，001-110不同的错误码，111未知错误，200-999推送不同类别信息。

    （2）对应请求码ReqCode: 功能码ReqCode：界面号（4位）+序号（3位）
                           如："ReqCode":"B001001"

    （3）说明信息Message: 字符串
                        如："Message": "用户注册成功！"

    （4）数据Data: JSON格式
	       如："Data":{
        	        "LoginName": "Zhangsan",
                    "Password": "123456"
            	}
### 新websocket说明

    1. /Presenter/WebSocketTest.java 存放了所有WebSocket的操作方法，WebSocket连接服务器已经在Application的onCreate（）进行了初始化，会在Logcat里输出是否连接成功，如果不成功请联系后台。
    
    2. 如何在Activity里调用ws传输？
    
        a)	private WebSocketTest wstest;//创建一个WebSocketTest对象
    
        b)	wstest = WebSocketTest.getInstance();
    //将WebSocketTest.getInstance()赋值给这个对象
    
        c)	RequestPackage LoginRequest = new RequestPackage();
    //定义一个请求包
    
        d)	在请求包里setReqCod功能码，和setData
    
        e)	wstest.sendData(LoginRequest);
    //调用sendData()方法，参数是请求包，即可向后台发送请求数据	
    
        f)	** 调用wstest.setServerListener设置监听者，实现ServerListener接口**
    
        g)	** 通过实现接口中的方法，来获取RespondPackage **
    
    3. Map和Object的互相转换？
    
        a)	调用Object2Map. Obj2Map (Object)，返回Map<String,Object>
    
        b)	调用Object2Map.map2Obj(Map<String,Object>,Class)，返回对应Class的对象


