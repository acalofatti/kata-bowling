package model

import exceptions.AmountRollsIsFull
import service.FunctionLoadedFrameService
import service.FunctionLoadedScoreService

class Game {

    private val functionLoadedFrameService = FunctionLoadedFrameService()
    private val functionLoadedScoreService = FunctionLoadedScoreService()

    var frames: ArrayList<Frame> = ArrayList()
    var rolls : ArrayList<Int> = ArrayList()

    fun roll(pins : Int){
        if(rolls.size <= 21){
            rolls.add(pins)
        } else {
            throw AmountRollsIsFull ()
        }
    }
    fun score() : Int {
        var index = 0
        var score = 0
        frames = functionLoadedFrameService.createFrames(rolls)

        for(frame in frames){
            score +=functionLoadedScoreService.score(frames, index)
            index += 1
        }
        return score
    }
}