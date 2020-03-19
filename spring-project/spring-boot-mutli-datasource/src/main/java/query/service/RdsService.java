package query.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import query.dao.RdsDao;
import query.entity.Rds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@DS("rds")
public class RdsService {
	
	@Autowired
	private RdsDao rdsDao;


	public List<Rds> queryRdsValue(Rds rds){
		return rdsDao.queryRdsValue(rds);
	}

}
