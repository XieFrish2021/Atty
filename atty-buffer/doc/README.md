# atty-buffer

这是Atty框架的数据载体，\
起作用差不多和Netty的ByteBuf差不多

## 如何引用
##### (1) gradle(Groovy/Kotlin)
```kotlin
dependencies {
    implementation("io.atty:atty-buffer:1.0.0-SNAPSHOT")
}
```

##### Maven
```xml
<dependencies>
    <dependency>
        <groupId>io.atty</groupId>
        <artifactId>atty-buffer</artifactId>
        <version>1.0.0-SNAPSHOT</version>
    </dependency>
</dependencies>
```

## 创建一个缓冲区

```java
import io.atty.buffer.ByteBuffer;

public class Main {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.writeInt(10086); /* 写入Int类型的数据 */

        System.out.println(buffer.readInt()); /* 读取Int类型的数据 */
    }
}
```
具体怎么用，剩下的就靠你自己摸索了。

## 补充
该源码其实还有另一个开源的地方\
传送门：[Gist](https://gist.github.com/XieFrish2021/79643e6bd721763d3f5160c93431f8c7)
