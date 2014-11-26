package ${package};
import org.jgenerator.core.dao.impl.BaseDaoImpl;
import org.jgenerator.dao.${entityName}Dao;
import org.jgenerator.model.${entityName};
import org.springframework.stereotype.Repository;

@Repository
public class ${entityName}DaoImpl extends BaseDaoImpl<${entityName}, Integer> implements ${entityName}Dao{
}