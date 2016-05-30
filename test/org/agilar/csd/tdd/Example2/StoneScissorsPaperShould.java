package org.agilar.csd.tdd.Example2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by juanbacarditbarrera on 24/5/16.
 */
public class StoneScissorsPaperShould {

    private StoneScissorPaper _game;
    private RoundChoice _player1;
    private RoundChoice _player2;

    @Before
    public void BeforeAll(){

        _game = new StoneScissorPaper();
    }

    @Test
    public void WhenPlayer1ChoicesStoneAndPlayer2ChoicesPaperThenPlayers2Wins(){
        _player1 = RoundChoice.Stone;
        _player2 = RoundChoice.Paper;
        RoundResult result = _game.PlayRound(_player1,_player2);
        Assert.assertSame(result, RoundResult.Player2Wins);
    }

    @Test
    public void WhenPlayer1ChoicesPaperAndPlayer2ChoicesStoneThenPlayers1Wins(){
        _player1 = RoundChoice.Paper;
        _player2 = RoundChoice.Stone;
        RoundResult result = _game.PlayRound(_player1,_player2);
        Assert.assertSame(result, RoundResult.Player1Wins);
    }

    @Test
    public void WhenPlayer1ChoicesPaperAndPlayer2ChoicesScissorsThenPlayers2Wins(){
        _player1 = RoundChoice.Paper;
        _player2 = RoundChoice.Scissors;
        RoundResult result = _game.PlayRound(_player1,_player2);
        Assert.assertSame(result, RoundResult.Player2Wins);
    }

    @Test
    public void WhenPlayer1ChoicesScissorsAndPlayer2ChoicesPaperThenPlayers1Wins(){
        _player1 = RoundChoice.Scissors;
        _player2 = RoundChoice.Paper;
        RoundResult result = _game.PlayRound(_player1,_player2);
        Assert.assertSame(result, RoundResult.Player1Wins);
    }

    @Test
    public void WhenPlayer1ChoicesScissorsAndPlayer2ChoicesStoneThenPlayers2Wins(){
        _player1 = RoundChoice.Scissors;
        _player2 = RoundChoice.Stone;
        RoundResult result = _game.PlayRound(_player1,_player2);
        Assert.assertSame(result, RoundResult.Player2Wins);
    }

    @Test
    public void WhenPlayer1ChoicesStoneAndPlayer2ChoicesScissorsThenPlayers1Wins(){
        _player1 = RoundChoice.Stone    ;
        _player2 = RoundChoice.Scissors;
        RoundResult result = _game.PlayRound(_player1,_player2);
        Assert.assertSame(result, RoundResult.Player1Wins);
    }

    @Test
    public void WhenPlayer1ChoicesStoneAndPlayer2ChoicesStoneThenPlayersDraw(){
        _player1 = RoundChoice.Stone    ;
        _player2 = RoundChoice.Stone;
        RoundResult result = _game.PlayRound(_player1,_player2);
        Assert.assertSame(result, RoundResult.Draw);
    }

    @Test
    public void WhenPlayer1ChoicesScissorsAndPlayer2ChoicesScissorsThenPlayersDraw(){
        _player1 = RoundChoice.Scissors    ;
        _player2 = RoundChoice.Scissors;
        RoundResult result = _game.PlayRound(_player1,_player2);
        Assert.assertSame(result, RoundResult.Draw);
    }

    @Test
    public void WhenPlayer1ChoicesPaperAndPlayer2ChoicesPaperThenPlayersDraw(){
        _player1 = RoundChoice.Paper    ;
        _player2 = RoundChoice.Paper;
        RoundResult result = _game.PlayRound(_player1,_player2);
        Assert.assertSame(result, RoundResult.Draw);
    }


    //TODO: Create whole testing suite before coding

}
