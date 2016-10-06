package cn.itcast.action;

import java.util.List;

import cn.itcast.entity.Employee;
import cn.itcast.service.IEmployeeService;
import cn.itcast.service.impl.EmployeeService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * Ա������Action
 * @author Jie.Yuan
 *
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	
	/****��װ����****/
	private Employee employee = new Employee();
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	// ��дģ����������
	@Override
	public Employee getModel() {
		return employee;
	}
	

	
	/****���õ�Service****/
	private IEmployeeService employeeService = new EmployeeService();
	
	/**
	 * 1. ���Ա��
	 */
	public String save() {
		try {
			// ����service����
			employeeService.save(employee);
			// ��ӳɹ���ȥ���б�ҳ��
			return list();
			//return "addsuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 2. �б���ʾ
	 */
	public String list() {
		try {
			// ��ѯȫ��
			List<Employee> listEmp = employeeService.getAll();
			// ���浽request��
			ActionContext.getContext().getContextMap().put("listEmp", listEmp);
			return "list";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 3. �����޸�ҳ��
	 */
	public String viewUpdate() {
		try {
			// 3.1 ��ȡ��ǰ�޸ĵļ�¼������ֵ
			int id = employee.getId();
			// 3.2 service��ѯ
			Employee emp = employeeService.findById(id);
			// 3.3 ���ݻ���
			// a. �ȵõ�ֵջ
			ValueStack vs = ActionContext.getContext().getValueStack();
			vs.pop();	//�Ƴ�ջ��Ԫ��
			vs.push(emp);	// emp�������ջ��
			
			return "update";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 4. �޸�Ա��
	 */
	public String update() {
		try {
			// ����service�޸�
			employeeService.update(employee);
			return list();
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
}
