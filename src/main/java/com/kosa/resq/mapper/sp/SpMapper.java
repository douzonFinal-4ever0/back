package com.kosa.resq.mapper.sp;

import com.kosa.resq.domain.dto.mr.SuppliesDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SpMapper {
    public List<SuppliesDTO> suppliesGetAll();
}
