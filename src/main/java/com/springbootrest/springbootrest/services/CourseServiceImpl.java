package com.springbootrest.springbootrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootrest.springbootrest.dao.CourseDao;
import com.springbootrest.springbootrest.entities.Course;



@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;
	
	// private List<Course> list;
	
	public CourseServiceImpl() {
		/*
		 * list = new ArrayList<>(); list.add(new Course(1, "Java Core Course",
		 * "This course contains basics of Java")); list.add(new Course(2,
		 * "Spring Boot Course", "Creating REST API with Spring Boot"));
		 */
	}
	
	@Override
	public List<Course> getCourses() {
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
		/*
		 * Course c = null; for (Course course : list) { if (course.getId() == courseId)
		 * { c = course; break; } } 
		 * return c;
		 */
		return courseDao.getOne(courseId);
	}

	@Override
	public Course addCourse(Course course) {
		/* list.add(course); */
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		
		/*
		 * list.forEach(e -> { if (e.getId() == course.getId()) {
		 * e.setTitle(course.getTitle()); e.setDescription(course.getDescription()); }
		 * 
		 * });
		 */
		
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
		/*
		 * list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.
		 * toList());
		 */	
		Course entity = courseDao.getOne(parseLong);
		courseDao.delete(entity);
	}
}