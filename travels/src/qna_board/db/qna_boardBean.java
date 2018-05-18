package qna_board.db;

import java.util.Date;

public class qna_boardBean {
	private int qna_no;
	private String qna_title;
	private String qna_content;
	public int getQna_no() {
		return qna_no;
	}
	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public String getQna_content() {
		return qna_content;
	}
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	public Date getQna_date() {
		return qna_date;
	}
	public void setQna_date(Date qna_date) {
		this.qna_date = qna_date;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	private Date qna_date;
	private int user_no;
	public String getQnA_FILE() {
		// TODO Auto-generated method stub
		return null;
	}
	public int getqna_RE_LEV() {
		// TODO Auto-generated method stub
		return 0;
	}
	public int getqna_RE_SEQ() {
		// TODO Auto-generated method stub
		return 0;
	}

}
