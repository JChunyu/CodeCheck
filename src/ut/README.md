# 使用Mockk进行单元测试

## 单元测试步骤

### 1. 添加依赖

首先，需要在项目中添加Mockk和JUnit依赖。在Gradle项目中，可以在`build.gradle`文件中添加：

```kotlin
dependencies {
    testImplementation("io.mockk:mockk:1.13.5")
    testImplementation("junit:junit:4.13.2")
}
```

如果是Maven项目，在`pom.xml`中添加：

```xml
<dependencies>
    <dependency>
        <groupId>io.mockk</groupId>
        <artifactId>mockk</artifactId>
        <version>1.13.5</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

### 2. 创建测试类

创建与被测试类对应的测试类，通常命名为`[类名]Test`：

```kotlin
package ut

import io.mockk.*
import org.junit.Test

class ManagerTest {
    // 测试方法将在这里编写
}
```

### 3. 编写测试方法

每个测试方法都应该使用`@Test`注解标记：

```kotlin
@Test
fun testManage() {
    // 测试代码
}
```

### 4. 创建Mock对象

使用Mockk创建被测试类的模拟对象：

```kotlin
// 创建完全模拟的对象
val manager = mockk<Manager>()

// 创建放松模拟的对象（未模拟的方法不会抛出异常）
val relaxedManager = mockk<Manager>(relaxed = true)

// 创建部分模拟的对象（只模拟部分方法，其他方法保持原始行为）
val spyManager = spyk(Manager())
```

### 5. 设置Mock行为

定义模拟对象的方法调用行为：

```kotlin
// 当调用manage方法时，不执行任何操作
every { manager.manage() } just Runs

// 当调用返回值的方法时，指定返回值
every { manager.someMethodWithReturn() } returns "预期返回值"

// 当调用方法时，执行原始方法
every { spyManager.manage() } answers { callOriginal() }

// 当调用方法时，抛出异常
every { manager.manage() } throws Exception("测试异常")
```

### 6. 调用被测试方法

执行要测试的方法：

```kotlin
manager.manage()
```

### 7. 验证方法调用

验证方法是否按预期被调用：

```kotlin
// 验证方法被调用了一次
verify(exactly = 1) { manager.manage() }

// 验证方法从未被调用
verify(exactly = 0) { manager.someOtherMethod() }

// 验证方法被调用了至少一次
verify(atLeast = 1) { manager.manage() }

// 验证方法被调用的顺序
verifyOrder {
    manager.methodA()
    manager.methodB()
}
```

### 8. 捕获和验证参数

捕获方法调用的参数并进行验证：

```kotlin
// 创建参数捕获槽
val slot = slot<String>()

// 设置方法行为并捕获参数
every { manager.methodWithParam(capture(slot)) } just Runs

// 调用方法
manager.methodWithParam("测试参数")

// 验证捕获的参数
assert(slot.captured == "测试参数")
```

### 9. 测试输出

如果需要测试标准输出，可以重定向System.out：

```kotlin
private val outContent = ByteArrayOutputStream()
private val originalOut = System.out

@Before
fun setUp() {
    System.setOut(PrintStream(outContent))
}

@After
fun tearDown() {
    System.setOut(originalOut)
}

@Test
fun testOutput() {
    manager.manage() // 假设这个方法会输出内容
    assert(outContent.toString().trim() == "预期输出")
}
```

### 10. 清除Mock

在测试方法结束后清除所有Mock：

```kotlin
@After
fun tearDown() {
    clearAllMocks()
}
```

## 示例

完整的测试类示例可以参考`ManagerTest.kt`文件，其中包含了多种测试场景：

1. 使用完全模拟对象测试方法调用
2. 测试真实对象的标准输出
3. 使用部分模拟对象测试方法行为和输出

## 最佳实践

1. 每个测试方法只测试一个功能点
2. 测试方法名称应清晰描述测试内容
3. 使用`@Before`和`@After`设置和清理测试环境
4. 适当使用断言验证测试结果
5. 模拟外部依赖，专注于测试单元功能
6. 考虑边界条件和异常情况