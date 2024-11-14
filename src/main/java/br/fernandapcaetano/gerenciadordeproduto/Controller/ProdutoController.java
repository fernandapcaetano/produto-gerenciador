package br.fernandapcaetano.gerenciadordeproduto.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.fernandapcaetano.gerenciadordeproduto.Model.Produto;
import br.fernandapcaetano.gerenciadordeproduto.Service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    @GetMapping
    public String listarProdutos(Model model) {
        List<Produto> produtos = service.findAll();
        model.addAttribute("produtos", produtos);
        return "produtos/listar";
    }

    @GetMapping("/novo")
    public String novoProdutoForm(Model model) {
        model.addAttribute("produto", new Produto());
        return "produtos/criar";
    }

    @PostMapping("/novo")
    public String criarProduto(@ModelAttribute Produto produto) {
        service.save(produto);
        return "redirect:/produtos";
    }

    @GetMapping("/editar/{id}")
    public String editarProdutoForm(@PathVariable("id") Long id, Model model) {
        Produto produto = service.findById(id);
        model.addAttribute("produto", produto);
        return "produtos/editar";
    }

    @PostMapping("/editar/{id}")
    public String editarProduto(@PathVariable("id") Long id, @ModelAttribute Produto produto) {
        produto.setId(id);
        service.save(produto);
        return "redirect:/produtos";
    }

    @GetMapping("/excluir/{id}")
    public String excluirProduto(@PathVariable("id") Long id) {
        Produto produto = service.findById(id).orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
        service.delete(produto);
        return "redirect:/produtos";
    }
}
