package bus.action;

import javax.servlet.http.*;
//Ư�� ����Ͻ� ��û���� �����ϰ� ��� ���� ActionForward Ÿ������ ��ȯ�ϴ� �޼��尡 ���ǵǾ� �ֽ��ϴ�.
//Action : �������̽���
//ActionForward : ��ȯ��
//aaaaa
public interface Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
