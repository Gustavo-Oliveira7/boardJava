package br.com.dio.persistence.dao;

import br.com.dio.dto.BlockDetailsDTO;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static br.com.dio.persistence.converter.OffsetDateTimeConverter.toOffsetDateTime;
import static br.com.dio.persistence.converter.OffsetDateTimeConverter.toTimestamp;

@AllArgsConstructor
public class BlockDAO {

    private final Connection connection;

    public void block(final String reason, final Long cardId) throws SQLException {
        var sql = "INSERT INTO BLOCKS (blocked_at, block_reason, card_id) VALUES (?, ?, ?);";
        try(var statement = connection.prepareStatement(sql)){
            var i = 1;
            statement.setTimestamp(i ++, toTimestamp(OffsetDateTime.now()));
            statement.setString(i ++, reason);
            statement.setLong(i, cardId);
            statement.executeUpdate();
        }
    }

    public void unblock(final String reason, final Long cardId) throws SQLException{
        var sql = "UPDATE BLOCKS SET unblocked_at = ?, unblock_reason = ? WHERE card_id = ? AND unblock_reason IS NULL;";
        try(var statement = connection.prepareStatement(sql)){
            var i = 1;
            statement.setTimestamp(i ++, toTimestamp(OffsetDateTime.now()));
            statement.setString(i ++, reason);
            statement.setLong(i, cardId);
            statement.executeUpdate();
        }
    }

    public List<BlockDetailsDTO> findByCardId(final Long cardId) throws SQLException {
        var sql = """
            SELECT id, blocked_at, block_reason, unblocked_at, unblock_reason
              FROM BLOCKS
             WHERE card_id = ?
             ORDER BY blocked_at ASC;
            """;
        var blocks = new ArrayList<BlockDetailsDTO>();
        try (var statement = connection.prepareStatement(sql)) {
            statement.setLong(1, cardId);
            statement.executeQuery();
            var rs = statement.getResultSet();
            while (rs.next()) {
                blocks.add(new BlockDetailsDTO(
                        rs.getLong("id"),
                        toOffsetDateTime(rs.getTimestamp("blocked_at")),
                        rs.getString("block_reason"),
                        toOffsetDateTime(rs.getTimestamp("unblocked_at")),
                        rs.getString("unblock_reason")
                ));
            }
        }
        return blocks;
    }

}
