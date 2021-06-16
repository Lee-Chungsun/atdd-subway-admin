package nextstep.subway.lineStation.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LineStationRepository extends JpaRepository<LineStation, Long> {
    Optional<List<LineStation>> findByStationId(Long id);

    Optional<List<LineStation>> findByLineId(Long id);

    Optional<LineStation> findByLineIdAndStationId(Long id, Long id1);
}
