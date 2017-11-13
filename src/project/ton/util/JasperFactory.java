/*package project.ton.util;

import java.io.IOException;
import java.io.InputStream;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;

public class JasperFactory
{
    private static JasperReport sRelacaoAlunos;
    private static JasperReport sRelacaoAlunosPesquisados;

    public static JasperReport getRelacaoAlunos() throws JRException
    {
        if (sRelacaoAlunos == null)
            sRelacaoAlunos = compilarRelatorio("RelacaoAlunos.jrxml");

        // Retornando o relat�rio compilado
        return sRelacaoAlunos;
    }

    public static JasperReport getRelacaoAlunosPesquisados() throws JRException
    {
        if (sRelacaoAlunos == null)
            sRelacaoAlunos = compilarRelatorio("RelacaoAlunosPesquisados.jrxml");

        // Retornando o relat�rio compilado
        return sRelacaoAlunos;
    }

    private static JasperReport compilarRelatorio(String pArquivoRelatorio) throws JRException
    {
        JasperReport tRelatorio = null;
        try
        {
            // Abrindo o arquivo JRXML
            InputStream tArqEntrada = JasperFactory.class.getResourceAsStream(pArquivoRelatorio);

            // Compilando o arquivo JRXML
            tRelatorio = JasperCompileManager.compileReport(tArqEntrada);

            // Fechando o arquivo JRXML
            tArqEntrada.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return tRelatorio;
    }
}
*/