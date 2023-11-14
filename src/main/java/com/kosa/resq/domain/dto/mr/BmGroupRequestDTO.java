package com.kosa.resq.domain.dto.mr;

import com.kosa.resq.domain.dto.common.UserDetailsDto;
import com.kosa.resq.domain.vo.common.MemResponseVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BmGroupRequestDTO {
    private String groupName;
    private String master;
    private List<String> members;
}
