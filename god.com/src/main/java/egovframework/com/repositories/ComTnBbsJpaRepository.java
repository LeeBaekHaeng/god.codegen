package egovframework.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import egovframework.com.entites.ComTnBbs;
import egovframework.com.entites.ComTnBbsId;

/**
 * 
 * @author 이백행
 * @since 2024-02-10
 *
 */
public interface ComTnBbsJpaRepository extends JpaRepository<ComTnBbs, ComTnBbsId> {

}
