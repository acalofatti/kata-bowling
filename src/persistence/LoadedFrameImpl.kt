package persistence

import model.Frame

class LoadedFrameImpl : LoadedFrame {

    override fun createFrame(rollOne: Int, rollTwo: Int): Frame {
    var frame = Frame()
        frame.roll1 = rollOne
        frame.roll2 = rollTwo
        return frame
    }
}