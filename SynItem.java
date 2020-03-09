package Dictoniary1.dictoniary;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("com.asif.gsonpojogenerator")
public class SynItem implements Serializable {

	@SerializedName("pos")
	private String pos;

	@SerializedName("text")
	private String text;

	public void setPos(String pos){
		this.pos = pos;
	}

	public String getPos(){
		return pos;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	@Override
 	public String toString(){
		return 
			"SynItem{" + 
			"pos = '" + pos + '\'' + 
			",text = '" + text + '\'' + 
			"}";
		}
}