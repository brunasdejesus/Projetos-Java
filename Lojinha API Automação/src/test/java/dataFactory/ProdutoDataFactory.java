package dataFactory;

import pojo.ComponentePojo;
import pojo.ProdutoPojo;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDataFactory {
    public static ProdutoPojo criarProdutoComumComOValorIgualA(double valor) {
        ProdutoPojo produto = new ProdutoPojo();
        produto.setProdutoNome("Caneta");
        produto.setProdutoValor(valor);

        List<String > cores = new ArrayList<>();
        cores.add("Preta");
        cores.add("Azul");

        produto.setProdutoCores(cores);
        produto.setProdutoUrlMock(" ");

        List<ComponentePojo> componentes = new ArrayList<>();

        ComponentePojo componente = new ComponentePojo();
        componente.setComponenteNome("Bocal");
        componente.setComponenteQuantidade(1);
        componentes.add(componente);

        ComponentePojo segundocomponente = new ComponentePojo();
        segundocomponente.setComponenteNome("Recarga de tinta");
        segundocomponente.setComponenteQuantidade(2);
        componentes.add(componente);

        produto.setComponentes(componentes);

        return produto;
    }
}
