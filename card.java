import java.lang.Float;

public class card{

	private String entry;
	private String exit;
	private int func_code;
	private float hours;

	public void setCode(int code){
		this.func_code = code;
	}

	public String getEntry(){
		return this.entry;
	}

	public void setEntry(String entry){
		this.entry = entry;
	}

	public String getExit(){
		return this.exit;
	}

	public void setExit(String exit){
		this.exit = exit;
	}

	public float calcHours(String entry, String exit){
		String[] entryTime = entry.split(":");
		String[] exitTime = exit.split(":");

		float entH = Float.parseFloat(entryTime[0]); //Hora de entrada
		float entM = Float.parseFloat(entryTime[1]); //Minutos da entrada

		float exH = Float.parseFloat(exitTime[0]);
		float exM = Float.parseFloat(exitTime[1]);
		
		entH += (entM/100);
		exH += (exM/100);

		float workHours = entH - exH;

		return workHours;
	}

	public void setHours(float hours){
		this.hours = hours;
	}

	public card(String entry, String exit, int code){
		this.entry = entry;
		this.exit = exit;
		this.func_code = code;
		this.hours = this.calcHours(entry, exit);
	}


}
