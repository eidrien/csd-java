package org.agilar.csd.tdd.Example2;

import org.agilar.csd.tdd.Example2.Simple.StoneScissorPaper;
import org.junit.Assert;
import org.junit.Test;

public class StoneScissorsPaperShould {

    protected IGame _game;
    private RoundChoice _player1;
    private RoundChoice _player2;

    public StoneScissorsPaperShould() {
        _game = new StoneScissorPaper();
    }

    @Test
    public void GivenAGameWhenPlayer1ChoicesStoneAndPlayer2ChoicesPaperThenPlayers2Wins(){
        _player1 = RoundChoice.Stone;
        _player2 = RoundChoice.Paper;
        RoundResult result = _game.PlayRound(_player1,_player2);
        Assert.assertSame(result, RoundResult.Player2Wins);
    }

    @Test
    public void GivenAGameWhenPlayer1ChoicesPaperAndPlayer2ChoicesStoneThenPlayers1Wins(){
        _player1 = RoundChoice.Paper;
        _player2 = RoundChoice.Stone;
        RoundResult result = _game.PlayRound(_player1,_player2);
        Assert.assertSame(result, RoundResult.Player1Wins);
    }

    @Test
    public void GivenAGameWhenPlayer1ChoicesPaperAndPlayer2ChoicesScissorsThenPlayers2Wins(){
        _player1 = RoundChoice.Paper;
        _player2 = RoundChoice.Scissors;
        RoundResult result = _game.PlayRound(_player1,_player2);
        Assert.assertSame(result, RoundResult.Player2Wins);
    }

    @Test
    public void GivenAGameWhenPlayer1ChoicesScissorsAndPlayer2ChoicesPaperThenPlayers1Wins(){
        _player1 = RoundChoice.Scissors;
        _player2 = RoundChoice.Paper;
        RoundResult result = _game.PlayRound(_player1,_player2);
        Assert.assertSame(result, RoundResult.Player1Wins);
    }

    @Test
    public void GivenAGameWhenPlayer1ChoicesScissorsAndPlayer2ChoicesStoneThenPlayers2Wins(){
        _player1 = RoundChoice.Scissors;
        _player2 = RoundChoice.Stone;
        RoundResult result = _game.PlayRound(_player1,_player2);
        Assert.assertSame(result, RoundResult.Player2Wins);
    }

    @Test
    public void GivenAGameWhenPlayer1ChoicesStoneAndPlayer2ChoicesScissorsThenPlayers1Wins(){
        _player1 = RoundChoice.Stone    ;
        _player2 = RoundChoice.Scissors;
        RoundResult result = _game.PlayRound(_player1,_player2);
        Assert.assertSame(result, RoundResult.Player1Wins);
    }

    @Test
    public void GivenAGameWhenPlayer1ChoicesStoneAndPlayer2ChoicesStoneThenPlayersDraw(){
        _player1 = RoundChoice.Stone    ;
        _player2 = RoundChoice.Stone;
        RoundResult result = _game.PlayRound(_player1,_player2);
        Assert.assertSame(result, RoundResult.Draw);
    }

    @Test
    public void GivenAGameWhenPlayer1ChoicesScissorsAndPlayer2ChoicesScissorsThenPlayersDraw(){
        _player1 = RoundChoice.Scissors    ;
        _player2 = RoundChoice.Scissors;
        RoundResult result = _game.PlayRound(_player1,_player2);
        Assert.assertSame(result, RoundResult.Draw);
    }

    @Test
    public void GivenAGameWhenPlayer1ChoicesPaperAndPlayer2ChoicesPaperThenPlayersDraw(){
        _player1 = RoundChoice.Paper    ;
        _player2 = RoundChoice.Paper;
        RoundResult result = _game.PlayRound(_player1,_player2);
        Assert.assertSame(result, RoundResult.Draw);
    }

}