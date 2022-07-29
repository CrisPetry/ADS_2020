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

import br.upf.webAppJogos.entities.LoginEntity;
import br.upf.webAppJogos.jwt.TokenJwt;
import br.upf.webAppJogos.repositories.LoginRepository;
import br.upf.webAppJogos.utils.Util;

@RestController
@RequestMapping(value = "/webAppJogos/login")
public class LoginRest {

	@Autowired
	private LoginRepository repository;

	@GetMapping(value = "/findAll")
	public List<LoginEntity> findAll(@RequestHeader("token") String token) {
		TokenJwt.validarToken(token);
		List<LoginEntity> result = repository.findAll();
		return result;
	}

	@GetMapping(value = "/findByPartNome")
	public List<LoginEntity> findByPartNome(@RequestHeader("token") String token,
			@RequestHeader(value = "nome") String nome) {
		TokenJwt.validarToken(token);
		List<LoginEntity> result = repository.findByPartNome("%" + nome + "%");
		return result;
	}

	@GetMapping(value = "/findByUsuario")
	public LoginEntity findByUsuario(@RequestHeader("token") String token,
			@RequestHeader(value = "usuario") String usuario) {
		TokenJwt.validarToken(token);
		LoginEntity result = repository.findByUsuario(usuario);
		return result;
	}

	@PostMapping(value = "/insert")
	public LoginEntity insert(@RequestHeader("token") String token, @RequestBody LoginEntity usuario) {
		TokenJwt.validarToken(token);
		LoginEntity result = repository.save(usuario);
		return result;
	}

	@PutMapping(value = "/update")
	public LoginEntity update(@RequestHeader("token") String token, @RequestBody LoginEntity usuario) {
		TokenJwt.validarToken(token);
		LoginEntity result = repository.save(usuario);
		return result;
	}

	@DeleteMapping(value = "/delete")
	public void update(@RequestHeader("token") String token, @RequestHeader(value = "id") Long id) {
		TokenJwt.validarToken(token);
		repository.deleteById(id);
	}

	@GetMapping(value = "/authorize")
	public LoginEntity authorize(@RequestHeader("usuario") String usuario, @RequestHeader("senha") String senha) {
		LoginEntity entidade;

		if (usuario != null && !usuario.isEmpty() && senha != null && !senha.isEmpty()) {
			entidade = repository.findByUsuario(usuario);

			if (entidade.getId() != null) {
				if (entidade.getSenha().equals(senha)) {
					entidade.setToken(Util.processarTokenJWT(usuario));
					return entidade;
				} else {
					return null;
				}
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
}
