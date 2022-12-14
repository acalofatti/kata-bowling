package persistence

interface ValidateIntegrityFrame {
   fun validateAmountPins(roll : Int)
   fun validateSumOfPins(rollOne : Int, rollTwo : Int)
}