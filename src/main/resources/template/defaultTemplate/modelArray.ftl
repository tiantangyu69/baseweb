package ${package};
import org.jgenerator.model.${entityName};
import java.util.List;

public class ${entityName}Array {
	private List<${entityName}> ${entityName ? uncap_first}Array;

	public List<${entityName}> get${entityName}Array() {
		return this.${entityName ? uncap_first}Array;
	}

	public void set${entityName}Array(List<${entityName}> ${entityName ? uncap_first}Array) {
		this.${entityName ? uncap_first}Array = ${entityName ? uncap_first}Array;
	}
}