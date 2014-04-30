package br.cad.rest.pessoa;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.cad.model.pessoa.Aluno;

/**
 * 
 * @author WilliamRodrigues
 * 
 */
@Path("/aluno")
@RequestScoped
public class AlunoRESTService {
	@Inject
	private EntityManager em;

	@GET
	@SuppressWarnings("unchecked")
	@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
	public List<Aluno> listAll() {
		return em.createQuery("FROM Aluno").getResultList();
	}
}
