package service

import persistence.LoadedScore
import persistence.LoadedScoreImpl
import model.Frame

class FunctionLoadedScoreService {

    private var loadedScore : LoadedScore = LoadedScoreImpl()

    fun score(frames: ArrayList<Frame>, indexFrame: Int) : Int{
        return loadedScore.calculateScore(frames, indexFrame)
    }
}

