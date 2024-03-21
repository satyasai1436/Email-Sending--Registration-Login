package in.satya.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.satya.Entity.Person2;


public interface person2Repo extends JpaRepository<Person2, Integer> {
	public Optional<Person2> findByEmailAndPassword(String email, String password);
}
