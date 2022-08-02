package demo;

import entities.Pessoa;
import entities.Produto;
import models.PessoaModel;
import models.ProdutoModel;

import java.util.List;

public class AdministrativoApp {
    public static void main(String[] args) {
        ProdutoModel produtoModel = new ProdutoModel();

        PessoaModel pessoaModel = new PessoaModel();

        Produto p1 = new Produto();
        p1.setNome("TV");
        p1.setPreco(300.0);
        p1.setQuantidade(100);
        p1.setStatus(true);

        Produto p2 = new Produto();
        p1.setNome("DVD");
        p1.setPreco(300.0);
        p1.setQuantidade(10);
        p1.setStatus(true);

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setCpf("00000000021");
        pessoa1.setDataNascimento(12121990);
        pessoa1.setEmail("abdce@.com");
        pessoa1.setNome("Abcde");

        Pessoa pessoa2 = new Pessoa();
        pessoa1.setCpf("22222222222");
        pessoa1.setDataNascimento(10041992);
        pessoa1.setEmail("bbbbbb@.com");
        pessoa1.setNome("bbbbbb");


        // 1) Criando um produto e pessoa
        produtoModel.create(p1);
        pessoaModel.create(pessoa1);

        //2) Buscando todos os produtos e pessoas na base de dados
        List<Produto> produtos = produtoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + produtos.size());

        List<Pessoa> pessoas = pessoaModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + pessoas.size());

        //3) Listar por id
        produtoModel.findById(p1);
        pessoaModel.findById(pessoa1);

        //4) update
        p1.setNome("DVD");
        p1.setPreco(200.0);
        p1.setQuantidade(20);
        p1.setStatus(true);
        produtoModel.update(p1);

        pessoa1.setCpf("11111111121");
        pessoa1.setDataNascimento(10101995);
        pessoa1.setEmail("aaaaa@.com");
        pessoa1.setNome("aaaaaa");

        pessoaModel.update(pessoa1);

        //5) Delete
        produtoModel.delete(p2);
        pessoaModel.delete(pessoa2);
    }
}
