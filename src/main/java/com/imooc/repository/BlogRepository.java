package com.imooc.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.imooc.domain.Blog;
import com.imooc.domain.Catalog;
import com.imooc.domain.User;

public interface BlogRepository extends JpaRepository<Blog, Long> {

	//根据用户名,博客标题分页查询博客列表
	public Page<Blog> findByUserAndTitleLike(User user,String title,Pageable pageable);
	
	//根据用户名,博客查询博客列表(时间逆序)
	public Page<Blog> findByTitleLikeAndUserOrTagsLikeAndUserOrderByCreateTimeDesc(String title,User user,Pageable pageable);
	
	//根据分类查询博客列表
	public Page<Blog> findByCatalog(Catalog  catalog,Pageable pageable);
	
}
