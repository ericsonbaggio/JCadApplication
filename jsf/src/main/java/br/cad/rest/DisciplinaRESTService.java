package br.cad.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.cad.model.academico.Disciplina;

@RequestScoped
@Path("/disciplina")
public class DisciplinaRESTService {

	@Inject
	private EntityManager em;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Disciplina> listAllMembers() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Disciplina> criteria = cb.createQuery(Disciplina.class);
		Root<Disciplina> disciplina = criteria.from(Disciplina.class);

		criteria.select(disciplina).orderBy(cb.asc(disciplina.get("nome")));
		return em.createQuery(criteria).getResultList();
	}
}
