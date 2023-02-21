package com.present.webdrawer.webdrawer.jpa;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.jdbc.core.JdbcTemplate;

import com.present.webdrawer.repositories.AziendaRepository;
import com.present.webdrawer.repositories.CaricoRepository;
import com.present.webdrawer.repositories.DocRepository;
import com.present.webdrawer.repositories.PermessiRepository;
import com.present.webdrawer.repositories.ProfiloPermessiRepository;
import com.present.webdrawer.repositories.TipoCaricoRepository;
import com.present.webdrawer.repositories.TipoDocRepository;
import com.present.webdrawer.repositories.UtenteAziendaProfiloRepository;
import com.present.webdrawer.repositories.UtenteAziendaRepository;
import com.present.webdrawer.repositories.UtenteRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class JpaTests {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private EntityManager entityManager;
	@Autowired
	private AziendaRepository aziendaRepository;
	@Autowired
	private CaricoRepository caricoRepository;
	@Autowired
	private DocRepository docRepository;
	@Autowired
	private PermessiRepository permessiRepository;
	@Autowired
	private ProfiloPermessiRepository profiloPermessiRepository;
	@Autowired
	private TipoCaricoRepository tipoCaricoRepository;
	@Autowired
	private TipoDocRepository tipoDocRepository;
	@Autowired
	private UtenteAziendaProfiloRepository utenteAziendaProfiloRepository;
	@Autowired
	private UtenteAziendaRepository utenteAziendaRepository;
	@Autowired
	private UtenteRepository utenteRepository;

	@Test
	void injectedComponentsAreNotNull() {
		assertNotNull(dataSource);
		assertNotNull(jdbcTemplate);
		assertNotNull(entityManager);
	}

	@Test
	void injectedRepositoriesAreNotNull() {
		assertNotNull(aziendaRepository);
		assertNotNull(caricoRepository);
		assertNotNull(docRepository);
		assertNotNull(permessiRepository);
		assertNotNull(profiloPermessiRepository);
		assertNotNull(tipoCaricoRepository);
		assertNotNull(tipoDocRepository);
		assertNotNull(utenteAziendaProfiloRepository);
		assertNotNull(utenteAziendaRepository);
		assertNotNull(utenteRepository);
	}
}
