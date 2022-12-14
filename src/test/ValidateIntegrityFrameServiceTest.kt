package test

import exceptions.AmountPinsIsInvalidException
import exceptions.SumOfPinesIsInvalidException
import service.ValidateIntegrityFrameService
import org.junit.Assert
import org.junit.Test

class ValidateIntegrityFrameServiceTest {

    private val validateIntegrityFrameService = ValidateIntegrityFrameService()

    @Test
    fun `give a roll with points less than zero when validate amount pins is called then validating should throw AmountPinsIsInvalidException()`(){
        val roll = -1

        Assert.assertThrows(AmountPinsIsInvalidException()::class.java) {
            validateIntegrityFrameService.validateAmountPins(roll)
        }
    }

    @Test
    fun `give a roll with points greater than ten when validate amount pins is called then validating should throw AmountPinsIsInvalidException()`(){
        val roll = 14

        Assert.assertThrows(AmountPinsIsInvalidException()::class.java) {
            validateIntegrityFrameService.validateAmountPins(roll)
        }
    }

    @Test
    fun `give two roll with points greater than ten when validate sum of pines is called then validating should throw SumOfPinesIsInvalidException()`(){
        val rollOne = 8
        val rollTwo = 5

        Assert.assertThrows(SumOfPinesIsInvalidException()::class.java) {
            validateIntegrityFrameService.validateSumOfPins(rollOne, rollTwo)
        }
    }
}