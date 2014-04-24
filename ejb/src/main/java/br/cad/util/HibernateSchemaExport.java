package br.cad.util;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.SQLServerDialect;
import org.hibernate.tool.hbm2ddl.DatabaseMetadata;
import org.hibernate.tool.hbm2ddl.SchemaUpdateScript;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class HibernateSchemaExport {
	private XmlWebApplicationContext ctx;
	private Configuration configuration;
	private DataSource dataSource;
	
	public HibernateSchemaExport() {
		initSpring();
	}
	
	private void initSpring() {
		String[] paths = {
				"br/cad/util/applicationContext.xml"
		};
		ctx = new XmlWebApplicationContext();
		ctx.setConfigLocations(paths);
		ctx.setServletContext(new MockServletContext(""));
		ctx.refresh();
		
		configuration = (Configuration) ctx.getBean("hibernateConfiguration");
		dataSource = (DataSource) ctx.getBean("dataSource");
	}	
	
	public void export() {
		try{
			Dialect dialect = new SQLServerDialect();
			DatabaseMetadata database = new DatabaseMetadata(dataSource.getConnection(), dialect, configuration);
			System.out.println("Gerando script da base de dados...");
			List<SchemaUpdateScript> sqls = configuration.generateSchemaUpdateScriptList(dialect, database);

			//String sqls[] = configuration.generateDropSchemaScript(dialect);
			
			System.out.println("---------------------------Script------------------------------\r\n\r\n\r\n");
			for(SchemaUpdateScript sql: sqls) {
				System.out.println(sql.getScript() + ";");
			}
			System.out.println("\r\n\r\n\r\n---------------------------------------------------------------");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		new HibernateSchemaExport().export();
	}
}
