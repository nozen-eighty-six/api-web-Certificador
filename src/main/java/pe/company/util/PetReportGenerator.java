package pe.company .util;

import pe.company.model.LineaPedido;
import pe.company.model.Pedido;
import pe.company.model.Producto;
import pe.company.repository.LineaPedidoRepository;
import pe.company.repository.PedidoRepository;
import pe.company.repository.ProductoRepository;
import pe.company.service.LineaPedidoService;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PetReportGenerator {
	
	@Autowired
	private LineaPedidoRepository ps;
	
	@Autowired
	private ProductoRepository prs;
	
	@Autowired
	private PedidoRepository pds;

    public byte[] exportToPdf(String id) throws JRException, FileNotFoundException, IOException {
        JasperPrint jasperPrint = getReport(id);

        // Guardar el informe en un archivo PDF en una carpeta específica
      String filePath = "doc/pedidosReport.pdf";
       savePdfToFile(jasperPrint, filePath);

        // También puedes devolver el archivo en forma de byte array si es necesario
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }

    private JasperPrint getReport(String id) throws FileNotFoundException, JRException {
       
    	List<LineaPedido> listP = ps.obtenerLineaPedidoByPedidoId(id);
	    Optional<Pedido> pedido =  pds.findById(listP.get(0).getPedido().getId());

    	Map<String, Object> params = new HashMap<>();
        params.put("lpedidoData", new JRBeanCollectionDataSource(listP));
        Double totales = listP.stream()
                .mapToDouble(pe -> 
                {
                	Optional<Producto>productoSelect = prs.findById(pe.getProductos().getId());
                	return pe.getCantidad() * productoSelect.get().getPrecio();
                	
                })
                .sum();
        params.put("total", totales);
        params.put("numeroPedido", pedido.get().getId());



        return JasperFillManager.fillReport(JasperCompileManager.compileReport(
                ResourceUtils.getFile("classpath:ped.jrxml").getAbsolutePath()), params, new JREmptyDataSource());
    }

    private void savePdfToFile(JasperPrint jasperPrint, String filePath) throws JRException, IOException {
        File file = new File(filePath);
        try (OutputStream outputStream = new FileOutputStream(file)) {
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
        }
    }
}