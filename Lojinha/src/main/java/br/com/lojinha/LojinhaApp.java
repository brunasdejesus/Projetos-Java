package br.com.lojinha;

import br.com.lojinha.enums.Tamanho;
import br.com.lojinha.pojo.ItemIncluso;
import br.com.lojinha.pojo.Produto;
import br.com.lojinha.pojo.ProdutoInternacional;
import br.com.lojinha.pojo.ProdutoNacional;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.List;

public class LojinhaApp {
    public static void main(String[] args) {
        Produto meuProduto = new Produto("Nestlé", Tamanho.Médio);

        System.out.println(meuProduto.getMarca());

        meuProduto.setNome("Garrafa");
        meuProduto.setValor(70);

        List<ItemIncluso> itensInclusos = new ArrayList<>();

        ItemIncluso primeiroItemIncluso = new ItemIncluso("Controle", 2);
        itensInclusos.add(primeiroItemIncluso);// 0

        ItemIncluso segundoItemIncluso = new ItemIncluso("Jogos", 3);
        itensInclusos.add(segundoItemIncluso); // 1

        ItemIncluso terceiroItemIncluso = new ItemIncluso("Cabos de Energia", 2);
        itensInclusos.add(terceiroItemIncluso); // 2
        meuProduto.setItensInclusos(itensInclusos);

        System.out.println(meuProduto.getMarca());
        System.out.println(meuProduto.getItensInclusos().get(1));

        System.out.println(meuProduto.getTamanho());

        System.out.println(meuProduto.getValor());

        System.out.println("Começando a mostrar a lista");

        for (ItemIncluso itemAtual : meuProduto.getItensInclusos()){
            System.out.println(itemAtual.getNome());
            System.out.println(itemAtual.getQuantidade());
        }

        System.out.println("Toda lista foi exibida");

        ProdutoNacional meuProdutoNacional = new ProdutoNacional("Sony", Tamanho.Médio);
        meuProdutoNacional.setImpostoNacional(0.55567);
        System.out.println(meuProdutoNacional.getImpostoNacional());

        ProdutoInternacional meuProdutoInternacional = new ProdutoInternacional("Apple", Tamanho.Pequeno);
        meuProdutoInternacional.setTaxaDeImportacao(0.256);
        System.out.println(meuProdutoInternacional.getTaxaDeImportacao());

        meuProdutoInternacional.setValor(-99.99);

    }





}
