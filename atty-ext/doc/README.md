# Atty-ext

这是该框架的拓展部分，该部分拓展了框架没有的一些东西。\
比如：
 - 把Encoder和Decoder整合在一起的SimpleMessageCodec
 - 经过改进的改进版IEncoder也就是SimpleMessageEncoder
 - 改进过的IHandler - SimpleMessageHandler
 - 内置了String通信解码器（没什么用.）

## 如何引用
##### (1) gradle(Groovy/Kotlin)
```kotlin
dependencies {
    implementation("io.atty:atty-ext:1.0.0-SNAPSHOT")
}
```

##### Maven
```xml
<dependencies>
    <dependency>
        <groupId>io.atty</groupId>
        <artifactId>atty-ext</artifactId>
        <version>1.0.0-SNAPSHOT</version>
    </dependency>
</dependencies>
```
