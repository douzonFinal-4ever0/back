package com.kosa.resq.mapper.mr;

import com.kosa.resq.domain.vo.mr.MrRezRequestVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MrUserMapper {
    public void mrRezSave(MrRezRequestVO mrRezRequestVO);
}
