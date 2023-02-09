# SharedUserId
- sharedUserId在Android13已经弃用。
```android:sharedUserId="com.example.cj"```
- 如果项目需要删除此功能，不能直接删除，会导致升级安装失败。

## 解决方案
添加`android:sharedUserMaxSdkVersion="32"`告诉系统不再使用，只有android13系统认识哦！
所以项目中设置的编译版本必须大于等于33才能编译通过，否则报aapt错误。

## 验证问题1：
1、Android13升级之后，相同sharedUserId的应用是否还能访问未对外导出的Provider。

## 验证问题2：
2、Android13升级之后，通过PackageInfo是否还能获取到sharedUserId。
```
   try {
       String shareId = getPackageManager().getPackageInfo(getPackageName(), 0).sharedUserId;
       Toast.makeText(this, "sharedUserId为："+shareId, Toast.LENGTH_SHORT).show();
   } catch (PackageManager.NameNotFoundException e) {
       throw new RuntimeException(e);
   }
```

## 验证问题3：
3、添加`android:sharedUserMaxSdkVersion="32"`后能否正常升级？
验证结果：可以正常升级。


