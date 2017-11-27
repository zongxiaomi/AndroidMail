# Android Mail 

### 前言
Android前端一般都使用埋点或者听云第其他的云平台作为分析日志的工具，但是一些小量的日志或者数据可以用邮件去分析，因为Python、JAVA、PHP都有封装的类库去发送邮件，所以一般做法是调用网络接口让后台去发送邮件，其实Android中也可以发送邮件，其实整合的JAVA的类库。

- QQ
 1. host : smtp.qq.com VIP 邮箱另试
 2. port : 25 
 3. 一定要去网页版邮箱--设置--账户 打开POP3/SMTP服务 、IMAP/SMTP服务，然后用下边的生成授权码作为密码
 
 

![1](png/b.png)
- 163 
1. host : smtp.163.com
2. port : 25 有很多说是其他端口的，但是我试了都不对

- 公司邮箱
1. 还是仔细问下公司的It同事，一定确定好Host 和端口号，区分是否有VIP 邮箱


> 如果是认证失败，首先检查一下` Mail.setUserName() 是否用邮箱地址，一般不要用邮箱地址，用@ 前面的用户名 `

如果打开调试模式，请设置 `Mail.setDebug(true)`,如果要添加Properties ，value 的值一定要是 字符串的"true" 或"false"


ps:
> 第一次弄git 依赖库，出了很多问题，比如不能依赖