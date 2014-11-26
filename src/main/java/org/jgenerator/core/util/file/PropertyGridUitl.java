/**
 * 
 */
package org.jgenerator.core.util.file;

import java.util.ArrayList;
import java.util.List;

import org.jgenerator.core.model.JDBCProperty;
import org.jgenerator.core.model.PropertyGrid;
import org.jgenerator.core.model.PropertyGridEditor;

/**
 * @author LIZHITAO
 * 
 */
public class PropertyGridUitl {
	public static List<PropertyGrid> getJDBCPropertyGrid() {
		PropertyUtil util = new PropertyUtil();
		JDBCProperty p = util.getJDBCProperty();
		List<PropertyGrid> list = new ArrayList<PropertyGrid>();
		PropertyGrid g = new PropertyGrid();
		g.setName(JDBCProperty.DRIVER);
		g.setValue(p.getDriver());
		g.setGroup("数据库链接配置");
		g.setEditor(PropertyGridEditor.TEXT);

		PropertyGrid g1 = new PropertyGrid();
		g1.setName(JDBCProperty.URL);
		g1.setValue(p.getUrl());
		g1.setGroup("数据库链接配置");
		g1.setEditor(PropertyGridEditor.TEXT);

		PropertyGrid g2 = new PropertyGrid();
		g2.setName(JDBCProperty.USERNAME);
		g2.setValue(p.getUsername());
		g2.setGroup("数据库链接配置");
		g2.setEditor(PropertyGridEditor.TEXT);

		PropertyGrid g3 = new PropertyGrid();
		g3.setName(JDBCProperty.PASSWORD);
		g3.setValue(p.getPassword());
		g3.setGroup("数据库链接配置");
		g3.setEditor(PropertyGridEditor.TEXT);

		PropertyGrid g4 = new PropertyGrid();
		g4.setName(JDBCProperty.MAXACTIVE);
		g4.setValue(p.getMaxActive());
		g4.setGroup("连接数配置");
		g4.setEditor(PropertyGridEditor.NUMBERBOX);

		PropertyGrid g5 = new PropertyGrid();
		g5.setName(JDBCProperty.MAXIDLE);
		g5.setValue(p.getMaxIdle());
		g5.setGroup("连接数配置");
		g5.setEditor(PropertyGridEditor.NUMBERBOX);

		PropertyGrid g6 = new PropertyGrid();
		g6.setName(JDBCProperty.MINIDLE);
		g6.setValue(p.getMaxIdle());
		g6.setGroup("连接数配置");
		g6.setEditor(PropertyGridEditor.NUMBERBOX);

		PropertyGrid g7 = new PropertyGrid();
		g7.setName(JDBCProperty.MAXWAIT);
		g7.setValue(p.getMaxWait());
		g7.setGroup("连接数配置");
		g7.setEditor(PropertyGridEditor.NUMBERBOX);

		PropertyGrid g8 = new PropertyGrid();
		g8.setName(JDBCProperty.INITIALSIZE);
		g8.setValue(p.getInitialSize());
		g8.setGroup("连接数配置");
		g8.setEditor(PropertyGridEditor.NUMBERBOX);

		list.add(g);
		list.add(g1);
		list.add(g2);
		list.add(g3);
		list.add(g8);
		list.add(g4);
		list.add(g5);
		list.add(g6);
		list.add(g7);
		return list;
	}
}
