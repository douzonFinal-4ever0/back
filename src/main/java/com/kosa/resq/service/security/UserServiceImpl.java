package com.kosa.resq.service.security;

import com.kosa.resq.domain.dto.common.MemDTO;
import com.kosa.resq.mapper.sercurity.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final SqlSession sqlSession;

    public UserServiceImpl(SqlSession ss) {
        this.sqlSession = ss;
    }
    @Override
    public Optional<MemDTO> login(MemDTO mem) {
        UserMapper um = sqlSession.getMapper(UserMapper.class);
        return um.login(mem);
    }
}
