package persistence

import exceptions.AmountPinsIsInvalidException
import exceptions.SumOfPinesIsInvalidException

class ValidateIntegrityFrameImpl : ValidateIntegrityFrame {
    override fun validateAmountPins(roll: Int) {
        if(roll > 10 || roll < 0){
            throw AmountPinsIsInvalidException()
        }
    }

    override fun validateSumOfPins(rollOne: Int, rollTwo: Int) {
        var sumOfPines = rollOne + rollTwo
        if(sumOfPines > 10){
            throw SumOfPinesIsInvalidException()
        }
    }
}