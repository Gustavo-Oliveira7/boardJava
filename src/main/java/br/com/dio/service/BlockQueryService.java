package br.com.dio.service;

import br.com.dio.dto.BlockDetailsDTO;
import br.com.dio.persistence.dao.BlockDAO;
import lombok.AllArgsConstructor;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class BlockQueryService {
    private final Connection connection;
    public List<BlockDetailsDTO> findByCardId(final Long cardId) throws SQLException {
        return new BlockDAO(connection).findByCardId(cardId);
    }
}
