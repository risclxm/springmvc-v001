package  com.bbsstep.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface TUserMapper {
    int selectDayUser();
    int selectMonthUser();
    int selectAllUser();

    
}