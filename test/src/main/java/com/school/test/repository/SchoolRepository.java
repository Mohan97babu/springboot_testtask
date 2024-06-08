	package com.school.test.repository;
	
	import org.springframework.data.domain.Page;
	import org.springframework.data.domain.PageRequest;
	import org.springframework.data.domain.Pageable;
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;
	import org.springframework.data.repository.query.Param;
	import org.springframework.stereotype.Repository;
	
	import com.school.test.dto.PaginatedRequestDTO;
	import com.school.test.entity.School;
	
	@Repository
	public interface SchoolRepository extends JpaRepository<School,Long>{
	
	//	Page<School> findByNameContainingIgnoreCase(String name, PageRequest of);
		 @Query("SELECT s FROM School s WHERE " +
		           "(:name IS NULL OR LOWER(s.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
		           "(:address IS NULL OR LOWER(s.address) LIKE LOWER(CONCAT('%', :address, '%'))) AND " +
		           "(:id IS NULL OR s.id = :id)")
		    Page<School> searchSchools(@Param("name") String name, 
		                               @Param("address") String address, 
		                               @Param("id") Long id, 
		                               Pageable pageable);
		
	}
