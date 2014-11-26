package ${package};
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import org.jgenerator.core.service.impl.BaseServiceImpl;
import org.jgenerator.service.${entityName}Service;
import org.jgenerator.dao.${entityName}Dao;
import org.jgenerator.model.${entityName};

@Service
public class ${entityName}ServiceImpl extends BaseServiceImpl<${entityName}, ${entityName}Dao> implements ${entityName}Service{
	@Resource
	private ${entityName}Dao daoImpl;
	
	@Override
	public ${entityName}Dao getDaoImpl() {
		return daoImpl;
	}

	@Override
	public void setDaoImpl(${entityName}Dao daoImpl) {
		this.daoImpl = daoImpl;
	}
}