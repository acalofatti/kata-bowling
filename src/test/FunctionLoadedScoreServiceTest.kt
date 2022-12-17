package test

import service.FunctionLoadedScoreService


import org.junit.Test
import kotlin.test.assertEquals

class FunctionLoadedScoreServiceTest {

    private val functionLoadedFrameService = FunctionLoadedScoreService()

    @Test
    fun `give a rolls when score is called then obtain three point`(){
        var rolls: ArrayList<Int> = ArrayList()
        rolls.add(1)
        rolls.add(2)

        var score = functionLoadedFrameService.score(rolls)

        assertEquals(3, score)
    }

    @Test
    fun `give a rolls with a strike when score is called then obtain ten point for strike more points for the next frame `(){
        var rolls: ArrayList<Int> = ArrayList()
        rolls.add(10)
        rolls.add(1)
        rolls.add(2)

        var score = functionLoadedFrameService.score(rolls)

        assertEquals(16, score)
    }

    @Test
    fun `give a frame with a spire when score is called then obtain ten point for strike more points for the next frame `(){
        var rolls: ArrayList<Int> = ArrayList()
        rolls.add(5)
        rolls.add(5)
        rolls.add(1)
        rolls.add(2)

        var score = functionLoadedFrameService.score(rolls)

        assertEquals(14, score)
    }
}