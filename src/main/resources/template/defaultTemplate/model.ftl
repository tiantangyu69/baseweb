package ${package};
import org.jgenerator.core.model.Entity;
<#list columnList as f>
	<#if f.type == "Date">
import java.util.Date;<#break>	
	</#if> 
</#list>
import java.util.HashMap;

public class ${entityName} extends Entity{
	/**
	 * @type long
	 * @field serialVersionUID
	 * @state 
	 */
	private static final long serialVersionUID = 1L;
	
<#list columnList as f>
	private ${f.type} ${f.name};
	private ${f.type} andLike${f.name? cap_first};
	private ${f.type} startLike${f.name? cap_first}; 
</#list>

<#list columnList as f>
	public void set${f.name ? cap_first}(${f.type} ${f.name}) {
		this.${f.name} = ${f.name};
	}
	
	public ${f.type} get${f.name ? cap_first}() {
		return this.${f.name};
	}
	
	public void setAndLike${f.name ? cap_first}(${f.type} andLike${f.name ? cap_first}) {
		this.andLike${f.name ? cap_first} = andLike${f.name ? cap_first};
	}
	
	public ${f.type} getAndLike${f.name ? cap_first}() {
		return this.andLike${f.name ? cap_first};
	}
	
	public void setStartLike${f.name ? cap_first}(${f.type} startLike${f.name ? cap_first}) {
		this.startLike${f.name ? cap_first} = startLike${f.name ? cap_first};
	}
	
	public ${f.type} getStartLike${f.name ? cap_first}() {
		return this.startLike${f.name ? cap_first};
	}
	 
</#list>

	@Override
	public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> params = new HashMap<String, Object>();
		
		<#list columnList as f>
		if(get${f.name ? cap_first}() != null){
			params.put("${f.name}", get${f.name ? cap_first}());
		}
		
		if(getAndLike${f.name ? cap_first}() != null){
			params.put("andLike${f.name ? cap_first}", getAndLike${f.name ? cap_first}());
		}
		
		if(getStartLike${f.name ? cap_first}() != null){
			params.put("startLike${f.name ? cap_first}", getStartLike${f.name ? cap_first}());
		}
		
		</#list>
		
		return params;
	}
}