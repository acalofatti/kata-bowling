package service

import persistence.LoadedFrame
import persistence.LoadedFrameImpl
import model.Frame

class FunctionLoadedFrameService {

    private val loadedFrame : LoadedFrame = LoadedFrameImpl()
    private val validateIntegrityFrameService = ValidateIntegrityFrameService()

    fun createFrames(rolls : ArrayList<Int>): ArrayList<Frame> {
        return framesReload(rolls)
    }

    private fun framesReload(rolls : ArrayList<Int>) : ArrayList<Frame> {
        var frames = arrayListOf<Frame>()
        var indexRolls = 0
        while(indexRolls < rolls.size -1){
            if(rolls[indexRolls] == 10){
                var frame = loadedFrame.createFrame(rolls[indexRolls], 0)
                frames.add(frame)
                indexRolls += 1
            } else {
                validateIntegrityFrame(rolls[indexRolls], rolls[indexRolls + 1])
                var frame = loadedFrame.createFrame(rolls[indexRolls], rolls[indexRolls + 1])
                frames.add(frame)
                indexRolls += 2
            }
        }
        return frames
    }

    private fun validateIntegrityFrame(rollOne : Int, rollTwo : Int){
        validateIntegrityFrameService.validateAmountPins(rollOne)
        validateIntegrityFrameService.validateAmountPins(rollTwo)
        validateIntegrityFrameService.validateSumOfPins(rollOne, rollTwo)
    }
}