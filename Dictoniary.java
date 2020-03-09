package Dictoniary1.dictoniary;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;

import Dictoniary1.dictoniary.DefItem;
import Dictoniary1.dictoniary.Head;
import com.google.gson.annotations.SerializedName;

@Generated("com.asif.gsonpojogenerator")
public class Dictoniary implements Serializable {

	@SerializedName("head")
	private Head head;

	@SerializedName("def")
	private List<DefItem> def;

	public void setHead(Head head){
		this.head = head;
	}

	public Head getHead(){
		return head;
	}

	public void setDef(List<DefItem> def){
		this.def = def;
	}

	public List<DefItem> getDef(){
		return def;
	}

	@Override
 	public String toString(){
		return 
			"Dictoniary{" + 
			"head = '" + head + '\'' + 
			",def = '" + def + '\'' + 
			"}";
		}
}