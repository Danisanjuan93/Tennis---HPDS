package is.katas.tennis;

import java.util.Objects;

public class BasicTennisGame implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;

    public BasicTennisGame() {
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, "player1"))
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        if (m_score1==m_score2) return equalScore();
        if (m_score1>=4 || m_score2>=4) return checkAdvantage(m_score1-m_score2);
        return checkScore();
    }

    private String checkScore() {
        return checkPlayerScore(m_score1) + "-" + checkPlayerScore(m_score2);
    }


    private String checkPlayerScore(int score) {
        switch(score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }

    private String checkAdvantage(int minusResult) {
        switch (minusResult) {
            case 1:
                return "Advantage player1";
            case -1:
                return "Advantage player2";
            default:
                return checkWinner(minusResult);
        }
    }

    private String checkWinner(int minusResult) {
        if (minusResult >= 2) {
            return "Win for player1";
        }else{
            return "Win for player2";
        }
    }

    private String equalScore() {
        switch (m_score1) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }
}
