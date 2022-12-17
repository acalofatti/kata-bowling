package test

import model.Frame
import org.junit.Test
import persistence.LoadedScoreImpl
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class LoadedScoreImplTest {

    private val loadedScoreImpl : LoadedScoreImpl = LoadedScoreImpl()

    @Test
    fun `give a frame with strike when is strike is called then obtain true`(){
        var frame = model.Frame()
        frame.roll1 = 10
        frame.roll2 = 0

        val strike = loadedScoreImpl.isStrike(frame)

        assertTrue(strike)
    }

    @Test
    fun `give a frame with spare when is strike is called then obtain true`(){
        var frame = model.Frame()
        frame.roll1 = 6
        frame.roll2 = 4

        val spare = loadedScoreImpl.isSpare(frame)

        assertTrue(spare)
    }

    @Test
    fun `give a frame with a strike when calculate score is called then obtain ten point for strike more points for the next frame `(){
        var frames: ArrayList<Frame> = ArrayList()
        var frameWithSpire = Frame()
        frameWithSpire.roll1 = 10
        frameWithSpire.roll2 = 0
        frames.add(frameWithSpire)
        var frame = Frame()
        frame.roll1 = 1
        frame.roll2 = 2
        frames.add(frame)


        var score = loadedScoreImpl.calculateScore(frames, 0)

        assertEquals(13, score)
    }

    @Test
    fun `give a frame with a spare when calculate score is called then obtain ten point for spare more points for the next frame `(){
        var frames: ArrayList<Frame> = ArrayList()
        var frameWithSpire = Frame()
        frameWithSpire.roll1 = 4
        frameWithSpire.roll2 = 6
        frames.add(frameWithSpire)
        var frame = Frame()
        frame.roll1 = 1
        frame.roll2 = 2
        frames.add(frame)


        var score = loadedScoreImpl.calculateScore(frames, 0)

        assertEquals(11, score)
    }

    @Test
    fun `give a frame when calculate score is called then obtain point for frame `(){
        var frames: ArrayList<Frame> = ArrayList()

        var frame = Frame()
        frame.roll1 = 1
        frame.roll2 = 2
        frames.add(frame)


        var score = loadedScoreImpl.calculateScore(frames, 0)

        assertEquals(3, score)
    }
}