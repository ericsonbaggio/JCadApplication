package br.cad.util;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExportExcelSQL {
	public static void main(String[] args) throws IOException, BiffException {

		Workbook workbook = Workbook.getWorkbook(new File("D:\\fg02_10_2012.xls"));
		Sheet sheet = workbook.getSheet(0);
		int linhas = sheet.getRows();

		System.out.println("Iniciando a leitura da planilha XLS:");
		for (int i = 0; i < linhas; i++) {
			Cell a1 = sheet.getCell(0, i);
			Cell b1 = sheet.getCell(1, i);
			Cell c1 = sheet.getCell(2, i);
			Cell d1 = sheet.getCell(3, i);
			Cell e1 = sheet.getCell(4, i);
			String as1 = a1.getContents();
			String as2 = b1.getContents();
			String as3 = c1.getContents();
			String as4 = d1.getContents();
			String as5 = e1.getContents();
			System.out.println("Cadastro: " + as1 + " Nome: " + as2 + " Data: " + as3 + " HORA: " + as4 + " Tipo do Acesso: " + as5);
		}
		workbook.close();
	}
}
