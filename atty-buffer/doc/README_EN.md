# atty-buffer

This is the data carrier of the Atty framework,\
Works pretty much the same as Netty's ByteBuf

## How to use.
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

## Create a buffer.

```java
import io.atty.buffer.ByteBuffer;

public class Main {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.writeInt(10086); /* Write data of type Int type */

        System.out.println(buffer.readInt()); /* Read data of type Int */
    }
}
```
How to use it, the rest is up to you to figure it out.

## Supplements
There is actually another open source place for this source code
Portal: [Gist](https://gist.github.com/XieFrish2021/79643e6bd721763d3f5160c93431f8c7)
