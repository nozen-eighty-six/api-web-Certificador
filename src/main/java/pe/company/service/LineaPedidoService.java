package pe.company.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import net.sf.jasperreports.engine.JRException;
import pe.company.model.LineaPedido;

public interface LineaPedidoService {

	abstract void save(LineaPedido lineaPedido);
    public abstract byte[] exportPdf(String id) throws JRException, FileNotFoundException, IOException;
    public Boolean enviarCorreoConPDF(String destino) ;

}
