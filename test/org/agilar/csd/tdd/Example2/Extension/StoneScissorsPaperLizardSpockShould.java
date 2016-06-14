package org.agilar.csd.tdd.Example2.Extension;

import org.agilar.csd.tdd.Example2.RoundChoice;
import org.agilar.csd.tdd.Example2.RoundResult;
import org.agilar.csd.tdd.Example2.StoneScissorsPaperShould;
import org.junit.Assert;
import org.junit.Test;


public class StoneScissorsPaperLizardSpockShould
    extends StoneScissorsPaperShould{

    private RoundChoice _player1;
    private RoundChoice _player2;

    public StoneScissorsPaperLizardSpockShould() {

        _game = new StoneScissorPaperLizardSpock();
    }


    //Lizard eats paper
    @Test
    public void GivenAGameWhenPlayer1ChoicesLizardAndPlayer2ChoicesPaperThenPlayers1Wins(){
        _player1 = RoundChoice.Lizard;
        _player2 = RoundChoice.Paper;
        RoundResult result = _game.PlayRound(_player1,_player2);
        Assert.assertSame(result, RoundResult.Player1Wins);
    }

    @Test
    public void GivenAGameWhenPlayer1ChoicesPaperAndPlayer2ChoicesLizardThenPlayers2Wins(){
        _player1 = RoundChoice.Paper;
        _player2 = RoundChoice.Lizard;
        RoundResult result = _game.PlayRound(_player1,_player2);
        Assert.assertSame(result, RoundResult.Player2Wins);
    }

    //Lizard poison Spock
    @Test
    public void GivenAGameWhenPlayer1ChoicesLizardAndPlayer2ChoicesSpockThenPlayers1Wins(){
        _player1 = RoundChoice.Lizard;
        _player2 = RoundChoice.Spock;
        RoundResult result = _game.PlayRound(_player1,_player2);
        Assert.assertSame(result, RoundResult.Player1Wins);
    }

    @Test
    public void GivenAGameWhenPlayer1ChoicesSpockAndPlayer2ChoicesLizardThenPlayers2Wins(){
        _player1 = RoundChoice.Spock;
        _player2 = RoundChoice.Lizard;
        RoundResult result = _game.PlayRound(_player1,_player2);
        Assert.assertSame(result, RoundResult.Player2Wins);
    }


    //Scissors decapitates Lizard
    @Test
    public void GivenAGameWhenPlayer1ChoicesScissorsAndPlayer2ChoicesLizardThenPlayers1Wins(){
        _player1 = RoundChoice.Scissors;
        _player2 = RoundChoice.Lizard;
        RoundResult result = _game.PlayRound(_player1,_player2);
        Assert.assertSame(result, RoundResult.Player1Wins);
    }

    @Test
    public void GivenAGameWhenPlayer1ChoicesLizardAndPlayer2ChoicesScissorsThenPlayers2Wins(){
        _player1 = RoundChoice.Lizard;
        _player2 = RoundChoice.Scissors;
        RoundResult result = _game.PlayRound(_player1,_player2);
        Assert.assertSame(result, RoundResult.Player2Wins);
    }

    //Stone crushes lizard
    @Test
    public void GivenAGameWhenPlayer1ChoicesStoneAndPlayer2ChoicesLizardThenPlayers1Wins(){
        _player1 = RoundChoice.Stone;
        _player2 = RoundChoice.Lizard;
        RoundResult result = _game.PlayRound(_player1,_player2);
        Assert.assertSame(result, RoundResult.Player1Wins);
    }

    @Test
    public void GivenAGameWhenPlayer1ChoicesLizardAndPlayer2ChoicesStoneThenPlayers2Wins(){
        _player1 = RoundChoice.Lizard;
        _player2 = RoundChoice.Stone;
        RoundResult result = _game.PlayRound(_player1,_player2);
        Assert.assertSame(result, RoundResult.Player2Wins);
    }

    //Spock smashes Scissors
    @Test
    public void GivenAGameWhenPlayer1ChoicesSpockAndPlayer2ChoicesScissorsThenPlayers1Wins(){
        _player1 = RoundChoice.Spock;
        _player2 = RoundChoice.Scissors;
        RoundResult result = _game.PlayRound(_player1,_player2);
        Assert.assertSame(result, RoundResult.Player1Wins);
    }

    @Test
    public void GivenAGameWhenPlayer1ChoicesScissorsAndPlayer2ChoicesSpockThenPlayers2Wins(){
        _player1 = RoundChoice.Scissors;
        _player2 = RoundChoice.Spock;
        RoundResult result = _game.PlayRound(_player1,_player2);
        Assert.assertSame(result, RoundResult.Player2Wins);
    }

    //Paper disapprove Spock
    @Test
    public void GivenAGameWhenPlayer1ChoicesPapersAndPlayer2ChoicesSpockThenPlayers1Wins(){
        _player1 = RoundChoice.Paper;
        _player2 = RoundChoice.Spock;
        RoundResult result = _game.PlayRound(_player1,_player2);
        Assert.assertSame(result, RoundResult.Player1Wins);
    }

    @Test
    public void GivenAGameWhenPlayer1ChoicesSpockAndPlayer2ChoicesPaperThenPlayers2Wins(){
        _player1 = RoundChoice.Spock;
        _player2 = RoundChoice.Paper;
        RoundResult result = _game.PlayRound(_player1,_player2);
        Assert.assertSame(result, RoundResult.Player2Wins);
    }

    //Spock vaporizes Stone
    @Test
    public void GivenAGameWhenPlayer1ChoicesSpockAndPlayer2ChoicesStoneThenPlayers1Wins(){
        _player1 = RoundChoice.Spock;
        _player2 = RoundChoice.Stone;
        RoundResult result = _game.PlayRound(_player1,_player2);
        Assert.assertSame(result, RoundResult.Player1Wins);
    }

    @Test
    public void GivenAGameWhenPlayer1ChoicesStoneAndPlayer2ChoicesSpockThenPlayers2Wins(){
        _player1 = RoundChoice.Stone;
        _player2 = RoundChoice.Spock;
        RoundResult result = _game.PlayRound(_player1,_player2);
        Assert.assertSame(result, RoundResult.Player2Wins);
    }

}
