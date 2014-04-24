package br.cad.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.faces.context.FacesContext;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class VelocityParser {

	private VelocityParser() {
	}

	static {
		try {
			Velocity.init();
		} catch (Exception e) {

		}
	}
	
	
	public static String loadTemplate(String templateName, Map<String, Object> params) {
		try {
			String path = getRealServerPath(templateName);
			StringBuffer velocityText = new StringBuffer();
			BufferedReader bin = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
			String line = null;
			while ((line = bin.readLine()) != null) {
				velocityText.append(line);
				velocityText.append("\r\n");
			}
			bin.close();
			return parser(velocityText.toString(), params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("rawtypes")
	private static String parser(String velocityText, Map mapParameters) {

		String result = null;

		if (velocityText != null) {
			VelocityContext context = new VelocityContext();

			// fill velocity context
			Iterator keys = mapParameters.entrySet().iterator();
			while (keys.hasNext()) {
				Map.Entry entry = (Entry) keys.next();
				context.put((String) entry.getKey(), entry.getValue());
			}

			StringWriter sw = new StringWriter();

			try {
				Velocity.evaluate(context, sw, "Parser Error!", velocityText);

				result = sw.toString();

				sw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	
	/**
	 * Retorna o caminho no servidor onde se encontra o projeto
	 * @return
	 */
	private static String getRealServerPath(String caminhoRelativo) {
		return FacesContext.getCurrentInstance().getExternalContext().getRealPath(caminhoRelativo);
	}
}