package service

import persistence.ValidateIntegrityFrame
import persistence.ValidateIntegrityFrameImpl

class ValidateIntegrityFrameService {

    private var validateIntegrityFrame : ValidateIntegrityFrame = ValidateIntegrityFrameImpl()

    fun validateAmountPins(roll: Int) {
        validateIntegrityFrame.validateAmountPins(roll)
    }

    fun validateSumOfPins(rollOne: Int, rollTwo: Int) {
        validateIntegrityFrame.validateSumOfPins(rollOne, rollTwo)
    }
}