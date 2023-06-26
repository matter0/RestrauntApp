package com.restraunt.restrauntApp.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.restraunt.restrauntApp.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>  {

	Optional<User> findByUsername(String username);
	
	
	
//	@Autowired
//	EntityManagerFactory emf;
//			
//		    public Optional<User> findByUsername(String username) {
//		    	EntityManager man=emf.createEntityManager();
//		    	System.out.println("fu");
//		    	User u=man.find(User.class, username);
//		    	
//		    	Optional<User> opt= Optional.of(u);
//		    	return opt;
//		    }
//
//		    public Optional<User> findById(Long Id) {
//		    	EntityManager man=emf.createEntityManager();
//		    	User u=man.find(User.class, Id);
//		    	Optional<User> opt= Optional.of(u);
//		    	return opt;
//		    }	
//			
//	

//	@Query("select e from user e where e.email= :email")
 //  public List<User> findByEmail(@Param("email") String email);


    
}