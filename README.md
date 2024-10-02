# Atty

**[English](./README_EN.md)** | **中文**

一个普通的网络框架，基于Apache Mina。\
框架主要的组件：
 - [Atty-core](./atty-core/doc/README.md)（最重要的）
 - [Atty-buffer](./atty-buffer/doc/README.md)（和Atty-core一样重要，是数据传输的载体）
 - [Atty-ext](./atty-ext/doc/README.md)（可有可无，只是对一些API的后期补充）

## 优势
没什么优势，作者可能憋了半天，就憋了几个字。\
1, API易用
2, 有Apache Mina的性能（不知道算不算）

## 如何引用
##### (1) gradle(Groovy/Kotlin)
```kotlin
dependencies {
    implementation("io.atty:atty-all:1.0.0-SNAPSHOT")
}
```

##### Maven
```xml
<dependencies>
    <dependency>
        <groupId>io.atty</groupId>
        <artifactId>atty-all</artifactId>
        <version>1.0.0-SNAPSHOT</version>
    </dependency>
</dependencies>
```

## 创建服务器
```java
public class Main {
    public static void main(String[] args) {
        TCPServer server = Atty.ccreateServer();
        server.listen(12345);
    }
}
```
根据上面的代码就能创建一个简单的Atty服务器了。

## 构建
(1) 第一步，拉取代码
```bash
git clone https://gitee.com/Frish2021/atty.git
```

(2) 第二部，开始构建
```bash
.\gradlew publish
```

构建最终成品在`target`文件夹里面

## 请给我们一个 ⭐Star!
> 你们的每一个⭐Star是我们前进的动力!
