package ut

import io.mockk.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class ManagerTest {
    // 用于捕获标准输出
    private val outContent = ByteArrayOutputStream()
    private val originalOut = System.out
    
    @Before
    fun setUp() {
        // 重定向标准输出到我们的ByteArrayOutputStream
        System.setOut(PrintStream(outContent))
    }
    
    @After
    fun tearDown() {
        // 恢复标准输出
        System.setOut(originalOut)
    }
    
    @Test
    fun testManage() {
        // 创建Manager类的mock对象
        val manager = mockk<Manager>(relaxed = true)
        
        // 设置当调用manage方法时的行为
        every { manager.manage() } just Runs
        
        // 调用被测试的方法
        manager.manage()
        
        // 验证方法被调用了一次
        verify(exactly = 1) { manager.manage() }
    }
    
    @Test
    fun testManageOutput() {
        // 使用真实对象测试输出
        val manager = Manager()
        
        // 调用被测试的方法
        manager.manage()
        
        // 验证输出内容
        assert(outContent.toString().trim() == "manage")
    }
    
    @Test
    fun testManageWithMockOutput() {
        // 创建部分mock对象，只mock某些方法
        val manager = spyk(Manager())
        
        // 设置当调用manage方法时的行为
        every { manager.manage() } answers {
            // 调用原始方法
            callOriginal()
        }
        
        // 调用被测试的方法
        manager.manage()
        
        // 验证方法被调用
        verify { manager.manage() }
        
        // 验证输出内容
        assert(outContent.toString().trim() == "manage")
    }
}