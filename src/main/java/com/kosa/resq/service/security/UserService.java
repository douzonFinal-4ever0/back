package com.kosa.resq.service.security;

import com.kosa.resq.domain.dto.common.MemDTO;

import java.util.Optional;

public interface UserService {
    Optional<MemDTO> login(MemDTO mem);
}
