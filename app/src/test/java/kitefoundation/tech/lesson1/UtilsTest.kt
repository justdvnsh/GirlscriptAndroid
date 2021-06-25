package kitefoundation.tech.lesson1

import junit.framework.TestCase
import org.junit.Assert
import org.junit.Test

class UtilsTest {
    @Test
    fun trimStringTest() {
        Assert.assertEquals("Hello", Utils.trimString(" Hello "))
    }

    @Test
    fun convertToUppercaseTest() {
        Assert.assertEquals("HELLO", Utils.convertToUppercase("hello"))
    }
}