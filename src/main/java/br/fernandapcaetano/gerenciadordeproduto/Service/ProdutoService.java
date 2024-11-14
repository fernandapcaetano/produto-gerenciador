package br.fernandapcaetano.gerenciadordeproduto.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fernandapcaetano.gerenciadordeproduto.Model.Produto;
import br.fernandapcaetano.gerenciadordeproduto.Repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired ProdutoRepository repository;

    public List<Produto> findAll() {
        return repository.findAll();
    }

    public void save(Produto produto) {
        repository.save(produto);
    }

    public Produto findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Produto produto) {
        repository.delete();
    }


    
}
