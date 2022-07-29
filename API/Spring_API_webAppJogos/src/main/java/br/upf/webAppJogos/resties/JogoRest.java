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

import br.upf.webAppJogos.entities.JogoEntity;
import br.upf.webAppJogos.jwt.TokenJwt;
import br.upf.webAppJogos.repositories.JogoRepository;

@RestController
@RequestMapping(value = "/webAppJogos/jogo")
public class JogoRest {

	@Autowired
	private JogoRepository repository;

	@GetMapping(value = "/findAll")
	public List<JogoEntity> findAll(@RequestHeader("token") String token) {
		TokenJwt.validarToken(token);
		List<JogoEntity> result = repository.findAll();
		return result;
	}

	@GetMapping(value = "/findById")
	public JogoEntity findById(@RequestHeader("token") String token, @RequestHeader(value = "id") Long id) {
		TokenJwt.validarToken(token);
		JogoEntity result = repository.findById(id).get();
		return result;
	}

	@GetMapping(value = "/findByProdCodigo")
	public List<JogoEntity> findByProdCodigo(@RequestHeader("token") String token,
			@RequestHeader(value = "produtoraCod") Long produtoraCod) {
		TokenJwt.validarToken(token);
		List<JogoEntity> entidadeList = repository.findByProdCodigo(produtoraCod);
		return entidadeList;
	}

	@GetMapping(value = "/findByTitulo")
	public List<JogoEntity> findByTitulo(@RequestHeader("token") String token,
			@RequestHeader(value = "titulo") String titulo) {
		TokenJwt.validarToken(token);
		List<JogoEntity> result = repository.findByTitulo(titulo);
		return result;
	}

	@GetMapping(value = "/findByPartTitulo")
	public List<JogoEntity> findByPartTitulo(@RequestHeader("token") String token,
			@RequestHeader(value = "titulo") String titulo) {
		TokenJwt.validarToken(token);
		List<JogoEntity> result = repository.findByPartTitulo("%" + titulo + "%");
		return result;
	}

	@PostMapping(value = "/insert")
	public JogoEntity insert(@RequestHeader("token") String token, @RequestBody JogoEntity jogo) {
		TokenJwt.validarToken(token);
		JogoEntity result = repository.save(jogo);
		return result;
	}

	@PutMapping(value = "/update")
	public JogoEntity update(@RequestHeader("token") String token, @RequestBody JogoEntity jogo) {
		TokenJwt.validarToken(token);
		JogoEntity result = repository.save(jogo);
		return result;
	}

	@DeleteMapping(value = "/delete")
	public void update(@RequestHeader("token") String token, @RequestHeader(value = "id") Long id) {
		TokenJwt.validarToken(token);
		repository.deleteById(id);
	}
}
