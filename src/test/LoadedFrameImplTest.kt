package test

import org.junit.Test
import persistence.LoadedFrameImpl
import kotlin.test.assertEquals

class LoadedFrameImplTest {

    private val loadedFrameImpl : LoadedFrameImpl = LoadedFrameImpl()

    @Test
    fun `give two rolls when create frame is called then obtain a frame`(){
        val frameExpected = loadedFrameImpl.createFrame(1,2)
        val expectedRoll1 = 1
        val expectedRoll2 = 2

        assertEquals(expectedRoll1, frameExpected.roll1)
        assertEquals(expectedRoll2, frameExpected.roll2)
    }

}