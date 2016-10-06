package cn.itcast.dao;

import java.util.List;

import cn.itcast.entity.Employee;

/**
 * ���ݷ��ʲ�ӿ�
 * @author Jie.Yuan
 *
 */
public interface IEmployeeDao {

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
 