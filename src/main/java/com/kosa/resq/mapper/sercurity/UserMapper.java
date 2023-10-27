package com.kosa.resq.mapper.sercurity;

import com.kosa.resq.domain.dto.common.MemDTO;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserMapper {
    Optional<MemDTO> login(MemDTO mem);
}
