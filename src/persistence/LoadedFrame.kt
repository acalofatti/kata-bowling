package persistence

import model.Frame

interface LoadedFrame {
    fun createFrame(rolls: Int, indexRolls: Int): Frame
}