package diario.de.bordo.relatorio;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.*;

import jxl.*;
import jxl.write.*;

/**
 *
 * @author joao.oliveira
 */
public class ExcelExporter {

    public void fillData(JTable table, File file) {

        try {

            WritableWorkbook workbook1 = Workbook.createWorkbook(file);
            WritableSheet sheet1 = workbook1.createSheet("First Sheet", 0);
            TableModel model = table.getModel();

            for (int i = 0; i < model.getColumnCount(); i++) {
                Label column = new Label(i, 0, model.getColumnName(i));
                sheet1.addCell(column);
            }
            int j = 0;
            for (int i = 0; i < model.getRowCount(); i++) {
                for (j = 0; j < model.getColumnCount(); j++) {

                    Object objValue = model.getValueAt(i, j);
                    String value = model.getValueAt(i, j) != null ? objValue.toString() : "";

                    Label row = new Label(j, i + 1, value);
                    sheet1.addCell(row);

                }
            }
            workbook1.write();
            workbook1.close();
        } catch (IOException | WriteException ex) {
            ex.printStackTrace();
        }

    }

    public void saveFile(Component componente, JTable tabela) {

        if (tabela.getRowCount() == 0) {

            return;

        }

        JFileChooser dialogo = new JFileChooser();
        dialogo.showSaveDialog(componente);

        if (dialogo.getSelectedFile() != null) {

            ExcelExporter Exporter = new ExcelExporter();
            File arquivo = new File(dialogo.getSelectedFile().toString() + ".xls");
            Exporter.fillData(tabela, arquivo);

        }

    }
}
