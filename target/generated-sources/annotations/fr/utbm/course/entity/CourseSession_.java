package fr.utbm.course.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CourseSession.class)
public abstract class CourseSession_ {

	public static volatile SingularAttribute<CourseSession, Date> endDate;
	public static volatile SingularAttribute<CourseSession, Integer> max;
	public static volatile SingularAttribute<CourseSession, Course> course;
	public static volatile SingularAttribute<CourseSession, Location> location;
	public static volatile SingularAttribute<CourseSession, Integer> id;
	public static volatile SingularAttribute<CourseSession, Date> startDate;

}

