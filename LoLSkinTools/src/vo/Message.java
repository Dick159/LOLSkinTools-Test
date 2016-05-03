package vo;


public class Message {
    private int operateType;

	private Object data;
	
	public int getOperateType() {
		return operateType;
	}
	
	public void setOperateType( int operateType ) {
		this.operateType = operateType;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData( Object data ) {
		this.data = data;
	}
}
