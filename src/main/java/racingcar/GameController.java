package racingcar;

import racingcar.domain.Car;
import racingcar.domain.PlayResult;
import racingcar.domain.RacingCarGame;
import racingcar.domain.RacingCarGameFactory;
import racingcar.strategy.MovingStrategy;
import racingcar.strategy.MovingStrategyFactory;
import racingcar.view.ResultView;

import java.util.List;

import static racingcar.strategy.MovingStrategyType.RANDOM;

public class GameController {

    public static final MovingStrategy MOVING_STRATEGY = MovingStrategyFactory.getInstance(RANDOM);

    public static void main(String[] args) {
        RacingCarGame racingCarGame = RacingCarGameFactory.getInstance();

        ResultView.printTitle();

        while (!racingCarGame.isEnd()) {
            racingCarGame.play(MOVING_STRATEGY);
            ResultView.printPlayResults(racingCarGame.getPlayResults());
        }

        ResultView.printWinners(RacingCarGame.findWinners(racingCarGame.getPlayResults()));
    }

}
