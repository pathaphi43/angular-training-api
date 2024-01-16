package com.me.angular.training.api.dto.res;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.chrono.ThaiBuddhistChronology;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

@Data
@Builder
public class ExceptionResponse {
    @Builder.Default
    private String timestamp = LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.of("Asia/Bangkok"))
            .atOffset(ZoneOffset.ofHours(7))
            .format(DateTimeFormatter.ISO_ZONED_DATE_TIME
                    .withLocale(new Locale("th"))
                    .withZone(ZoneId.of("Asia/Bangkok"))
                    .withChronology(ThaiBuddhistChronology.INSTANCE));
    private String path;
    private Integer status;
    private String error;
    private String message;
}
