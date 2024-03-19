package pe.company.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.mail.MessagingException;
import net.sf.jasperreports.engine.JRException;
import pe.company.model.LineaPedido;
import pe.company.repository.LineaPedidoRepository;
import pe.company.util.PetReportGenerator;

@Service
public class LineaPedidoImpl  implements LineaPedidoService{

	@Autowired
	private LineaPedidoRepository repository;
	
	@Autowired
    private PetReportGenerator petReportGenerator;
    @Autowired
    private EmailService emailService;
	@Override
	public void save(LineaPedido lineaPedido) {
		
		repository.save(lineaPedido);
		
	}

	@Override
	public byte[] exportPdf(String id) throws JRException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return petReportGenerator.exportToPdf(id);
	}

	@Override
	public Boolean enviarCorreoConPDF(String destino) {
		 // Ruta al archivo PDF que quieres enviar
        String pdfPath = "doc/pedidosReport.pdf";

        try {
            byte[] pdfBytes = Files.readAllBytes(Paths.get(pdfPath));
            emailService.sendEmail(destino, "Pedido de comprar - Top Moda", "Enviamos los detalles del pedido", pdfBytes, "pedidos.pdf");
            return true;
        } catch (IOException | MessagingException e) {
            e.printStackTrace();
            return false;
        }
	}

}
