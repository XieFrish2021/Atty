# Atty

**English** | **[中文](./README.md)**

A common web framework, based on Apache Mina.\
The main components of the framework:
- [Atty-core](./atty-core/doc/README_EN.md)（The most important）
- [Atty-buffer](./atty-buffer/doc/README_EN.md)（As important as Atty-core is, it is the carrier of data transmission）
- [Atty-ext](./atty-ext/doc/README_EN.md)（Dispensable, just a later addition to some APIs）

## Advantages
There is no advantage, the author may have held back for a long time, just a few words.
1. The API is easy to use
2. Apache Mina performance (I don't know if it counts)

## How to use.
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

## Create a server
```java
public class Main {
    public static void main(String[] args) {
        TCPServer server = Atty.ccreateServer();
        server.listen(12345);
    }
}
```
Based on the above code, you can create a simple Atty server.

## Build
(1) The first step is to pull the code
```bash
git clone https://github.com/XieFrish2021/Atty.git
```

(2) The second part is to start building
```bash
.\gradlew publish
```

The final product is in the `target` folder

## Please give us a ⭐Star!
> Each ⭐of your stars is the driving force for us to move forward!
