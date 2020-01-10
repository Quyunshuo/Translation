# Translation
一个十分简单小巧的翻译软件

Kotlin+MVP+Retrofit+协程



![image](https://github.com/Quyunshuo/KoltinCoroutines/blob/master/img.png) 

翻译接口用的是百度翻译的API,项目中已经把接口的ID和Key去掉了,想体验的伙伴自行到https://api.fanyi.baidu.com/api/trans/product/index选择通用翻译API注册完全免费

[Constant.kt](https://github.com/Quyunshuo/Translation/blob/master/app/src/main/java/com/quyunshuo/translation/model/Constant.kt)

```kotlin
//百度翻译接口的AppId
const val APP_ID = ""
//百度翻译接口的密钥
const val SECURITY_KEY = ""
```

把这两个关键参数填好就可以正常使用了!😋