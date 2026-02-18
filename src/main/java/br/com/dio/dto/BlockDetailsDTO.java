package br.com.dio.dto;

import java.time.OffsetDateTime;

public record BlockDetailsDTO(
        Long id,
        OffsetDateTime blockedAt,
        String blockReason,
        OffsetDateTime unblockedAt,
        String unblockReason
) {
}
