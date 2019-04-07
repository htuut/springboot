# springboot
springboot 常用方法

# 校验相关
#### 1、注册用户
- ##### 请求地址 post：http://localhost:8080/user/register
- ##### 请求示例

```
{
	"name":"张三",
	"password":"123",
	"age":"15",
	"email":"273@qq.com"
}
```
- ##### 返回结果
```
{
    "timestamp": "2019-04-07T09:46:06.253+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "年龄不能小于18岁",
    "path": "/user/register"
}
```
