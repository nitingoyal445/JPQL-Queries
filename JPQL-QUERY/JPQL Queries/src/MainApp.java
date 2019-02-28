
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.beans.Employee;

public class MainApp {

	public static void main(String[] args) {
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("nitin");
		EntityManager entitymanager = emfactory.createEntityManager();
		
		//Find Out Max Sal of an employee
		System.out.println("QUERY 1");
		Query query1 = (Query) entitymanager.createQuery("Select MAX(e.sal) from Employee e");
		int result = (int) query1.getSingleResult();
		System.out.println("Max Employee Salary :" + result);
		
		//Display all employee record		
		System.out.println("QUERY 2");
		Query query2 = entitymanager.createQuery("Select e from Employee e");
		List<Employee> list = query2.getResultList();
		for(Employee e:list) {
			System.out.println(e.getEmpno()+" "+e.getEname()+" "+e.getSal()+" "+e.getDeptno());
		}
		
		//find out employee whose salary between 40000 and 60000 
		System.out.println("QUERY 3");
		Query query3 = entitymanager.createQuery("select e from Employee e where sal between 40000 and 60000");
		List<Employee> list1 = query3.getResultList();
		for(Employee e: list1) {
			System.out.println(e.getEmpno()+" "+e.getEname()+" "+e.getSal()+" "+e.getDeptno());
		}
		
		//show employee whose salary is max in their respective department
		System.out.println("QUERY 4");
		Query query4 = entitymanager.createQuery("select e from Employee e where sal in (select max(sal) from Employee e1 group by deptno)");
		List<Employee> list2 = query4.getResultList();
		for(Employee e:list2) {
			System.out.println(e.getEmpno()+" "+e.getEname()+" "+e.getSal()+" "+e.getDeptno());
		}
	}

}
