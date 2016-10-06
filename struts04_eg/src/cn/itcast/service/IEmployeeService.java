package cn.itcast.service;

import java.util.List;

import cn.itcast.entity.Employee;

/**
 * ҵ���߼���ӿ�
 * @author Jie.Yuan
 *
 */
public interface IEmployeeService {

	/**
	 * ��ѯȫ��Ա��
	 */
	List<Employee> getAll();
	
	/**
	 * ����������ѯ
	 */
	Employee findById(int id);
	
	/**
	 * ���Ա��
	 */
	void save(Employee emp);
	
	/**
	 * �޸�Ա��
	 */
	void update(Employee emp);
	
}
 