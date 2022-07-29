package br.upf.webAppJogos.resties;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.upf.webAppJogos.entities.ProdutoraEntity;
import br.upf.webAppJogos.jwt.TokenJwt;
import br.upf.webAppJogos.repositories.ProdutoraRepository;

@RestController
@RequestMapping(value = "/webAppJogos/produtora")
public class ProdutoraRest {

	@Autowired
	private ProdutoraRepository repository;

	@GetMapping(value = "/findAll")
	public List<ProdutoraEntity> findAll(@RequestHeader("token") String token) {
		TokenJwt.validarToken(token);
		List<ProdutoraEntity> result = repository.findAll();
		return result;
	}

	@GetMapping(value = "/findByCodigo")
	public ProdutoraEntity findByCodigo(@RequestHeader("token") String token,
			@RequestHeader(value = "codigo") Long codigo) {
		TokenJwt.validarToken(token);
		ProdutoraEntity result = repository.findById(codigo).get();
		return result;
	}

	@GetMapping(value = "/findByNome")
	public ProdutoraEntity findByNome(@RequestHeader("token") String token,
			@RequestHeader(value = "nome") String nome) {
		TokenJwt.validarToken(token);
		ProdutoraEntity result = repository.findByNome(nome);
		return result;
	}

	@GetMapping(value = "/findByPartNome")
	public List<ProdutoraEntity> findByPartNome(@RequestHeader("token") String token,
			@RequestHeader(value = "nome") String nome) {
		TokenJwt.validarToken(token);
		List<ProdutoraEntity> result = repository.findByPartNome("%" + nome + "%");
		return result;
	}

	@PostMapping(value = "/insert")
	public ProdutoraEntity insert(@RequestHeader("token") String token, @RequestBody ProdutoraEntity prod) {
		TokenJwt.validarToken(token);
		ProdutoraEntity result = repository.save(prod);
		return result;
	}

	@PutMapping(value = "/update")
	public ProdutoraEntity update(@RequestHeader("token") String token, @RequestBody ProdutoraEntity prod) {
		TokenJwt.validarToken(token);
		ProdutoraEntity result = repository.save(prod);
		return result;
	}

	@DeleteMapping(value = "/delete")
	public void update(@RequestHeader("token") String token, @RequestHeader(value = "codigo") Long codigo) {
		TokenJwt.validarToken(token);
		repository.deleteByCodigo(codigo);
	}

}
