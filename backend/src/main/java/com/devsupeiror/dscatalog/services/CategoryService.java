package com.devsupeiror.dscatalog.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsupeiror.dscatalog.dto.CategoryDTO;
import com.devsupeiror.dscatalog.entities.Category;
import com.devsupeiror.dscatalog.repositories.CategoryRepository;
import com.devsupeiror.dscatalog.services.exceptions.EntityNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
    @Transactional(readOnly = true)
	public List<CategoryDTO>findAll(){
		List<Category> list= repository.findAll();
		
		return  list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
		
		
		 
	}

    @Transactional(readOnly = true)
	public CategoryDTO findByID(Long id) {
		Optional<Category> obj = repository.findById(id);
		Category entity = obj.orElseThrow(()-> new EntityNotFoundException("Entity not found"));
		return new CategoryDTO(entity);
	}
}