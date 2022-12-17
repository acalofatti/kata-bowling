package persistence

import model.Frame

interface LoadedScore {
    fun isStrike(frame : Frame) : Boolean
    fun isSpare(frame : Frame) : Boolean
    fun calculateScore(frames: ArrayList<Frame>) : Int
}