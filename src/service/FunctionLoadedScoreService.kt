package service

import persistence.LoadedScore
import persistence.LoadedScoreImpl

class FunctionLoadedScoreService {

    private var loadedScore : LoadedScore = LoadedScoreImpl()
    private val functionLoadedFrameService = FunctionLoadedFrameService()

    fun score(rolls : ArrayList<Int>) : Int{
        var frames = functionLoadedFrameService.createFrames(rolls)
        return loadedScore.calculateScore(frames)
    }
}

