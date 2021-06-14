package nextstep.subway.lineStation.ui;

import nextstep.subway.lineStation.application.LineStationService;
import nextstep.subway.lineStation.dto.LineStationResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LineStationController {
    private final LineStationService lineStationService;

    public LineStationController(final LineStationService lineStationService) {
        this.lineStationService = lineStationService;
    }

    @GetMapping(value = "/lineStations", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LineStationResponse>> showLineStations() {
        return ResponseEntity.ok().body(lineStationService.findAllLineStations());
    }

    @GetMapping(value = "/lineStations/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LineStationResponse>> showLineStation(@PathVariable Long id) {
        return ResponseEntity.ok().body(lineStationService.findByStationId(id));
    }

    @GetMapping(value = "/lines/{id}/lineStations", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LineStationResponse>> showLineStations(@PathVariable Long id) {
        return ResponseEntity.ok().body(lineStationService.findByLineId(id));
    }
}
