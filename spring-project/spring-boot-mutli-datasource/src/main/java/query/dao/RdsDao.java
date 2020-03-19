package query.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import query.entity.Rds;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface RdsDao extends BaseMapper<Rds> {

    List<Rds> queryRdsValue(Rds rds);

    List<Map<String, Object>> queryRdsXtyyMbew(Rds dmdatauptime);
}
