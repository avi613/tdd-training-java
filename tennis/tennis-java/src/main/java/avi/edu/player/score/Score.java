package avi.edu.player.score;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
public class Score {
    private int trackPoints;
    private int numberOfGamesWon;
}
