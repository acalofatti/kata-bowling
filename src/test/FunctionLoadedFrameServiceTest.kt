package test

import exceptions.AmountPinsIsInvalidException
import exceptions.SumOfPinesIsInvalidException
import service.FunctionLoadedFrameService
import org.junit.Assert
import org.junit.Test
import kotlin.test.assertEquals


class FunctionLoadedFrameServiceTest {

    private val functionLoadedFrameService = FunctionLoadedFrameService()

    @Test
    fun `give a two rolls when create fame is called then obtain frames list`(){
        val rolls = arrayListOf<Int>()
        rolls.add(1)
        rolls.add(2)

        var frames = functionLoadedFrameService.createFrames(rolls)

        assertEquals(1, frames.size)
    }

    @Test
    fun `give a strike when create fame called then obtain a frame with roll is ten and roll two 0`(){
        val rolls = arrayListOf<Int>()
        rolls.add(10)
        rolls.add(3)

        var frames = functionLoadedFrameService.createFrames(rolls)

        assertEquals(1, frames.size)
        assertEquals(10, frames[0].roll1)
        assertEquals(0, frames[0].roll2)
    }

    @Test
    fun `give a rolls list wiht a invalid amount roll when create fame called then validating should throw AmountPinsIsInvalidException()`(){
        val rolls = arrayListOf<Int>()
        rolls.add(14)
        rolls.add(3)

        Assert.assertThrows(AmountPinsIsInvalidException()::class.java) {
            functionLoadedFrameService.createFrames(rolls)
        }
    }

    @Test
    fun `give a frame and is invalid sum of pines when create fame called then validating should throw SumOfPinesIsInvalidException()`(){
        val rolls = arrayListOf<Int>()
        rolls.add(9)
        rolls.add(3)

        Assert.assertThrows(SumOfPinesIsInvalidException()::class.java) {
            functionLoadedFrameService.createFrames(rolls)
        }
    }
}