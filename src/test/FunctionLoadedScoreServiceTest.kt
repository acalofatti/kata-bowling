package test

import service.FunctionLoadedScoreService
import model.Frame
import org.junit.Test
import kotlin.test.assertEquals

class FunctionLoadedScoreServiceTest {

    private val functionLoadedFrameService = FunctionLoadedScoreService()

    @Test
    fun `give a frame when score is called then obtain three point`(){
        var frames: ArrayList<Frame> = ArrayList()
        var frame = Frame()
        frame.roll1 = 1
        frame.roll2 = 2
        frames.add(frame)


        var score = functionLoadedFrameService.score(frames, 0)

        assertEquals(3, score)
    }

    @Test
    fun `give a frame with a strike when score is called then obtain ten point for strike more points for the next frame `(){
        var frames: ArrayList<Frame> = ArrayList()
        var frameWithStrike = Frame()
        frameWithStrike.roll1 = 10
        frameWithStrike.roll2 = 0
        frames.add(frameWithStrike)
        var frame = Frame()
        frame.roll1 = 1
        frame.roll2 = 2
        frames.add(frame)


        var score = functionLoadedFrameService.score(frames, 0)

        assertEquals(13, score)
    }

    @Test
    fun `give a frame with a spire when score is called then obtain ten point for strike more points for the next frame `(){
        var frames: ArrayList<Frame> = ArrayList()
        var frameWithSpire = Frame()
        frameWithSpire.roll1 = 5
        frameWithSpire.roll2 = 5
        frames.add(frameWithSpire)
        var frame = Frame()
        frame.roll1 = 1
        frame.roll2 = 2
        frames.add(frame)


        var score = functionLoadedFrameService.score(frames, 0)

        assertEquals(11, score)
    }
}