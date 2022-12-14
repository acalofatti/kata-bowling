package test

import exceptions.AmountPinsIsInvalidException
import exceptions.AmountRollsIsFull
import exceptions.SumOfPinesIsInvalidException
import model.Game
import org.junit.Assert
import org.junit.Test
import kotlin.test.assertEquals

class GameTest {

    @Test
    fun `give a game when roll is called then rolls size is one`(){
        val game = Game()

        game.roll(1)

        assertEquals(1, game.rolls.size)
    }

    @Test
    fun `give a game when score is called then frames size is one`(){
        val game = Game()

        game.roll(1)
        game.roll(2)
        game.score()

        val framesSize = game.frames.size

        assertEquals(1, framesSize)
    }

    @Test
    fun `give two when score is called then validating should throw AmountPinsIsInvalidException()`() {
        val game = Game()
        game.roll(14)
        game.roll(2)

        Assert.assertThrows(AmountPinsIsInvalidException()::class.java) {
            game.score()
        }
    }

    @Test
    fun `give two rolls when score is called then validating should throw SumOfPinesIsInvalidException()`(){
        var game = Game()
        game.roll(4)
        game.roll(10)
        Assert.assertThrows(SumOfPinesIsInvalidException()::class.java) {
            game.score()
        }
    }

    @Test
    fun `give a game with ten pointwhen score is called then obtains`(){
        val game = Game()

        game.roll(2)
        game.roll(5)
        game.roll(2)
        game.roll(5)

        val score = game.score()

        assertEquals(14, score)
    }

    @Test
    fun `give twenty two rolls when roll is called then validating should throw AmountPinsIsInvalidException()`(){
        var game = Game()

        Assert.assertThrows(AmountRollsIsFull()::class.java) {
            for(i in 1..23){
                game.roll(1)
            }
        }
    }
}