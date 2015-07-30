package br.com.diariodebordo.model.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author joao.oliveira
 */
public class Conexao {

    public static Connection getConexao() throws SQLException, ClassNotFoundException {

        String arquivo = "";
        String caminho = System.getProperty("user.dir") + "\\" + "diariodebordo2.db";
        //   String caminho = "c:\\diariodebordoLOCAL.db";

        Path path = Paths.get(caminho);

        if (Files.exists(path)) {

            arquivo = caminho;

        }

        Class.forName("org.sqlite.JDBC");
        return DriverManager.getConnection("jdbc:sqlite:" + arquivo);

    }

    public static void copiarBanco() {

        File[] roots = File.listRoots();
        Path source = null;

        for (File file : roots) {

            Path path = Paths.get(file + "\\CONTROLE LOCAL DIR_CE\\APPS\\App_Data\\Data\\diariodebordo2.db");

            if (Files.exists(path)) {

                source = path;

            }

        }

        if (source == null) {

            JOptionPane.showMessageDialog(null, "Erro: Banco de dados não encontrado! Certifique se o computador está com rede e tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;

        } else {

            Path target = Paths.get(System.getProperty("user.dir") + "\\" + "diariodebordo2.db");
            try {
                Files.copy(source, target, REPLACE_EXISTING);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro: " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }

}
