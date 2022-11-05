package br.inatel.labs.labjpa;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.inatel.labs.labjpa.entity.NotaCompra;
import br.inatel.labs.labjpa.entity.NotaCompraItem;
import br.inatel.labs.labjpa.service.NotaCompraService;

@SpringBootTest
public class LoadingDemo {
	@Autowired
	private NotaCompraService service;

	@Test
	public void demoEagerLoading() {
		try {
			NotaCompraItem item = service.buscarNotaCompraItemPeloId(1L);

			LocalDate dataEmissao = item.getNotaCompra().getDataEmissao();

			System.out.println(dataEmissao);

			System.out.println("Carregamento EAGER");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void demoLazyLoading() {
		try {
			NotaCompra nota = service.buscarNotaCompraPeloId(1L);

			int tamanho = nota.getListaNotaCompraItem().size();

			System.out.println(tamanho);

		} catch (Exception e) {
			System.out.println("Carregamento LAZY => lanca exception");
			e.printStackTrace();
		}
	}
	
	@Test
	public void demoPlanejandoConsulta() {
		try {
			NotaCompra nota = service.buscarNotaCompraPeloIdComLista(1L);

			int tamanho = nota.getListaNotaCompraItem().size();

			System.out.println(tamanho);

		} catch (Exception e) {
			System.out.println("Carregamento LAZY => lanca exception");
			e.printStackTrace();
		}
	}
	
	

}
