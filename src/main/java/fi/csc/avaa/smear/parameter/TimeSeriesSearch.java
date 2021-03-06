package fi.csc.avaa.smear.parameter;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static fi.csc.avaa.smear.parameter.ParameterUtils.mapTablesToVariables;

@Getter
@Builder
@EqualsAndHashCode
public class TimeSeriesSearch {

    private Map<String, List<String>> tableToVariables;
    private LocalDateTime from;
    private LocalDateTime to;
    private Quality quality;
    private Aggregation aggregation;
    private int interval;
    private List<Integer> cuvNos;

    public static TimeSeriesSearch from(TimeSeriesQueryParameters params) {
        Aggregation aggregation = params.getAggregation() != null
                ? Aggregation.from(params.getAggregation().toUpperCase())
                : Aggregation.DEFAULT;
        int interval = params.getInterval() != null
                ? params.getInterval()
                : 30;
        Quality quality = params.getQuality() != null
                ? Quality.from(params.getQuality().toUpperCase())
                : Quality.DEFAULT;
        return TimeSeriesSearch.builder()
                .tableToVariables(mapTablesToVariables(params.getTablevariable()))
                .from(LocalDateTime.parse(params.getFrom()))
                .to(LocalDateTime.parse(params.getTo()))
                .quality(quality)
                .aggregation(aggregation)
                .interval(interval)
                .cuvNos(params.getCuv_no())
                .build();
    }
}
