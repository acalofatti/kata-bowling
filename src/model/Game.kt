package model

import exceptions.AmountRollsIsFull
import service.FunctionLoadedScoreService

class Game {

    private val functionLoadedScoreService = FunctionLoadedScoreService()

    var rolls : ArrayList<Int> = ArrayList()

    fun roll(pins : Int){
        if(rolls.size <= 21){
            rolls.add(pins)
        } else {
            throw AmountRollsIsFull ()
        }
    }
    fun score() : Int {
        return functionLoadedScoreService.score(rolls)
    }
}