package me.devyonghee.racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("레이싱 경기장")
class RacingStadiumTest {

    private static final CarPreparer ZERO_DISTANCE_PREPARER = CarPreparer.of(CarFactory.of(3, new MovementPolicy.Fake(true)), Distance.ZERO);

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> RacingStadium.of(ZERO_DISTANCE_PREPARER, 1));
    }

    @Test
    @DisplayName("자동차 준비자는 필수")
    void instance_nullPreparer_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> RacingStadium.of(null, 1));
    }

    @Test
    @DisplayName("바퀴수는 반드시 0이상")
    void instance_zeroCycleCount_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> RacingStadium.of(ZERO_DISTANCE_PREPARER, -1));
    }

    @Test
    @DisplayName("주어진 바퀴 수만큼 경주 기록")
    void history() {
        //given
        int tenCycleCount = 10;
        //when
        TracksHistory history = RacingStadium.of(ZERO_DISTANCE_PREPARER, tenCycleCount).history();
        //then
        assertThat(history.size()).isEqualTo(tenCycleCount);
    }
}