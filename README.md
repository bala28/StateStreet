#Technologies

  Spring boot, Jpa, Flyway , java8 ,H2 database(in memory)
  
# Run
  gradle run test
  

ORM(hibernate,ibatis) has various advantage and there are best pratices for Hibernate.


* Don't use joins unless really needed. They won't allow you to use neither lazy loading, nor using 2nd level cache for associations
* Use lazy="extra" for large collections, it won't retrieve all the elements until you ask it, you can also use size() method for instance without getting elements from DB
* Use named queries (in your hbm files or in @NamedQuery) so that they are not parsed during each query. Don't use Criteria API until it's required (it makes impossible to use PreparedStatement cache in this case)
* Use read-only modes for selects-only,This will make Hibernate not to keep an original snapshot of the selected entity in the persistent context for further dirty checks.
* User 2nd level cache and Query Cache for read-mostly and read-only data.

* Do queries like 'select new Entity(id, someField) from Entity' in order to retrieve only required fields. Take a look at result transformers.
Use batch operations (like delete) if needed
* If you use native queries, specify explicitly what cache regions should be invalidated (by default - all).
* Use StatelessSession if it's possible, it overcomes dirty checks, cascading, interceptors, etc.
* Do not use pagination (setMaxResults(), setFirstResult()) along with queries that contain joins to collections, this will result in all the records pulled from database and pagination will happen in memory by Hibernate. If you want pagination, ideally you shouldn't use joins. If you can't escape it, again - use batch fetching.



## What if we want to record course scores?  What possible changes need to be made?  Explain briefly.

We can create another table where the columns will be (course_student_id and score) if you want to de-normalize more. we can also add score column to student_courses table.