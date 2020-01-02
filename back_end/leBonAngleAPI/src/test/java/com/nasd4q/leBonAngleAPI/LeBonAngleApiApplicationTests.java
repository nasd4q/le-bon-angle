package com.nasd4q.leBonAngleAPI;

import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.List;

import com.nasd4q.leBonAngleAPI.model.Annonce;
import com.nasd4q.leBonAngleAPI.model.Categorie;
import com.nasd4q.leBonAngleAPI.model.Photo;
import com.nasd4q.leBonAngleAPI.model.Utilisateur;
import com.nasd4q.leBonAngleAPI.repository.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LeBonAngleApiApplicationTests {

	@Autowired
	AnnonceRepository annonceRepository;
	@Autowired
	UtilisateurRepository utilisateurRepository;
	@Autowired
	CategorieRepository categorieRepository;
	@Autowired
	PhotoRepository photoRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testAnnonceRepositoryFindByX() {
		Utilisateur u1 = new Utilisateur("jack", "0765234610", "jack@ctu.com");
		Utilisateur u2 = new Utilisateur("chloe", "0765234623", "chloe@ctu.com");

		u1 = utilisateurRepository.save(u1);
		u2 = utilisateurRepository.save(u2);

		Categorie c1 = new Categorie("armes");
		Categorie c2 = new Categorie("comms units");

		c1 = categorieRepository.save(c1);
		c2 = categorieRepository.save(c2);

		Annonce a1 = new Annonce("Vend ak47", "AK 47, bon etat, tres peu servi", new BigDecimal(99.99), "LA, CA", u1,
				c1);
		Annonce a2 = new Annonce("Vend telephone", "Samsung S10, bon etat, tres peu servi", new BigDecimal(199.99),
				"LA, CA", u2, c2);

		a1 = annonceRepository.save(a1);
		a2 = annonceRepository.save(a2);

		List<Annonce> l = annonceRepository.findByAuteur_Id(u1.getId());

		for (Annonce a : l) {
			System.out.println(a.getDescription());
		}

		utilisateurRepository.delete(u1);
		utilisateurRepository.delete(u2);

		categorieRepository.delete(c1);
		categorieRepository.delete(c2);

		annonceRepository.delete(a1);
		annonceRepository.delete(a2);

	}

	@Test
	public void populateDatabase() throws Exception {
		Utilisateur u1 = new Utilisateur("jack", "0765234610", "jack@ctu.com");
		Utilisateur u2 = new Utilisateur("chloe", "0765234623", "chloe@ctu.com");

		u1 = utilisateurRepository.save(u1);
		u2 = utilisateurRepository.save(u2);

		Categorie c1 = new Categorie("armes");
		Categorie c2 = new Categorie("comms units");

		c1 = categorieRepository.save(c1);
		c2 = categorieRepository.save(c2);

		Annonce a1 = new Annonce("Vend ak47", "AK 47, bon etat, tres peu servi", new BigDecimal(99.99), "LA, CA", u1,
				c1);
		Annonce a2 = new Annonce("Vend telephone", "Samsung S10, bon etat, tres peu servi", new BigDecimal(199.99),
				"LA, CA", u2, c2);
		Annonce a3 = new Annonce("Vend GPS", "GPS, bon etat, tres peu servi", new BigDecimal(199.99),
				"LA, CA", u2, c2);

		a1 = annonceRepository.save(a1);
		a2 = annonceRepository.save(a2);
		a3 = annonceRepository.save(a3);

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("photos/ak47.jpg").getFile());
		Photo p1 = new Photo("ak47.jpg", Files.readAllBytes(file.toPath()) , a1);
		p1 = photoRepository.save(p1);
	}

}
