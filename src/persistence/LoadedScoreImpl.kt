package persistence

import model.Frame

class LoadedScoreImpl : LoadedScore {

    override fun isStrike(frame: Frame): Boolean {
        return (frame.roll1 == 10)
    }

    override fun isSpare(frame: Frame): Boolean {
        var totalScore= frame.roll1 + frame.roll2
        return (totalScore == 10)
    }

    override fun calculateScore(frames: ArrayList<Frame>): Int {
        var score = 0
        var indexFrame = 0

        for(frame in frames) {
            if (isStrike(frames[indexFrame])) {
                score += 10 + frames[indexFrame + 1].roll1 + frames[indexFrame + 1].roll2
                indexFrame +=1
            } else if (isSpare(frames[indexFrame])) {
                score += 10 + frames[indexFrame + 1].roll1
                indexFrame +=1
            } else {
                score += frames[indexFrame].roll1 + frames[indexFrame].roll2
                indexFrame +=1
            }
        }
        return score
    }
}