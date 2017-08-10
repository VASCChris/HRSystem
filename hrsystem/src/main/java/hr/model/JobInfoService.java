package hr.model;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("jobInfoService")
public class JobInfoService implements Serializable{
	@Autowired
	private JobInfoDAO jobInfoDAO;
//	public JobInfoService(JobInfoDAO jobInfoDAO) {
//		this.jobInfoDAO = jobInfoDAO;
//	}
	
	public List<JobInfoBean> jobList(){
		return jobInfoDAO.select();
	}
	
	public Boolean insert(JobInfoBean bean){
		Boolean result = false;
		if(bean!=null){
			result = jobInfoDAO.insert(bean);
		}
		return result;
	}
	
	public JobInfoBean update(JobInfoBean bean){
		JobInfoBean result = null;
		if(bean!=null && bean.getNo()!=0){
			result = jobInfoDAO.update(bean);
		}
		return result;
	}
	
	public Boolean delete(Integer id){
		Boolean result = false;
		if(id!=0){
			result = jobInfoDAO.delete(id);
		}
		return result;
	}
	
	public static void main(String[] arg){
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory sessionFactory = (SessionFactory)context.getBean("sessionFactory");
		sessionFactory.getCurrentSession().beginTransaction();
		JobInfoService jobInfoService = (JobInfoService)context.getBean("jobInfoService");
		
		JobInfoBean bean = new JobInfoBean();
		bean.setNo(3);
		bean.setName("HEHEHE");
		
		List<JobInfoBean> xxx = jobInfoService.jobList();
		System.out.println(xxx);
		
		sessionFactory.getCurrentSession().getTransaction().commit();
		((ConfigurableApplicationContext)context).close();
		
	}

}
