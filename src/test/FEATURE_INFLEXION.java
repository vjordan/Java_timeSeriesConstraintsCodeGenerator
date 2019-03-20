package test; 
import java.util.ArrayList; 
import java.util.HashMap; 
public class FEATURE_INFLEXION { 
	private int[] timeSerie; 
	private HashMap<String, ArrayList<Integer>> timeSerieResults; 
	private String  currentState; 
	private int currentSignIndex; 
	private int currentValueIndex; 
	private String[] timeSerieSigns; 
	private String[] timeSerieStates; 
	private String[] timeSerieLetters; 
	private int defaultVal; 
	private int after; 
	private HashMap<String, ArrayList<Integer>> timeSerieCounters; 
	private HashMap<String, Integer> currentCounters; 
	private HashMap<String, Integer> initCounters; 
	public static final String FEATURE_ONE = "FEATURE_ONE";
	public static final String FEATURE_WIDTH = "FEATURE_WIDTH";
	public static final String FEATURE_SURFACE = "FEATURE_SURFACE";
	public static final String FEATURE_MAX = "FEATURE_MAX";
	public static final String FEATURE_MIN = "FEATURE_MIN";
	public static final String FEATURE_RANGE = "FEATURE_RANGE";
	public void getResultForATimeSerie(int[] timeSerie, String feature, int defaultVal, int after) {
		this.timeSerieResults = new HashMap<String, ArrayList<Integer>>();
		this.timeSerie = timeSerie;
		this.defaultVal = defaultVal;
		this.after = after;
		System.out.println("TimeSerie Values : "+this.listToString(timeSerie));
		this.currentState = "s";
		int nbElements = timeSerie.length;
		currentSignIndex = 0;
		this.timeSerieStates = new String[nbElements];
		this.timeSerieStates[0] = "s";
		this.timeSerieLetters = new String[nbElements-1];
		this.timeSerieCounters = new HashMap<String, ArrayList<Integer>>();
		this.currentCounters = new HashMap<String, Integer>() ;
		this.initCounters = new HashMap<String, Integer>() ;
		ArrayList<Integer> resultListe = new ArrayList<Integer>();
		for(int i = 0; i < timeSerie.length-1; i++) {
			resultListe.add(new Integer(0));
		}
		resultListe.add(new Integer(0));
		this.timeSerieResults.put("e",resultListe);
		ArrayList<Integer> resultListf = new ArrayList<Integer>();
		for(int i = 0; i < timeSerie.length-1; i++) {
			resultListf.add(new Integer(0));
		}
		resultListf.add(new Integer(0));
		this.timeSerieResults.put("f",resultListf);
		ArrayList<Integer> counterListC = new ArrayList<Integer>();
		counterListC.add(new Integer(neutral(feature)));
		this.initCounters.put("C",new Integer(neutral(feature)));
		for(int i = 0; i < timeSerie.length-2; i++) {
			counterListC.add(new Integer(this.initCounters.get("C")));
		}
		this.timeSerieCounters.put("C",counterListC);
		this.currentCounters.put("C",this.initCounters.get("C"));
		ArrayList<Integer> counterListD = new ArrayList<Integer>();
		counterListD.add(new Integer(neutral(feature)));
		this.initCounters.put("D",new Integer(neutral(feature)));
		for(int i = 0; i < timeSerie.length-2; i++) {
			counterListD.add(new Integer(this.initCounters.get("D")));
		}
		this.timeSerieCounters.put("D",counterListD);
		this.currentCounters.put("D",this.initCounters.get("D"));
		//Code timeSerie signs 
		this.timeSerieSigns = new String[nbElements - 1];
		for (int i = 0; i < nbElements - 1; i++) {
			if (timeSerie[i] == timeSerie[i+1]) {
				timeSerieSigns[i] = "=";
			} else if (timeSerie[i] < timeSerie[i+1]) {
				timeSerieSigns[i] = "<";
			} else {
				timeSerieSigns[i] = ">";
			}
		}
		System.out.println("TimeSerie Signs : "+this.listToString(timeSerieSigns));
		this.currentValueIndex = 1;
		while(this.currentValueIndex < this.timeSerie.length){
		//Code timeSerie states 
			if (this.currentState.equals("s") && "=".contains(this.timeSerieSigns[currentSignIndex])){
				this.timeSerieStates[currentValueIndex] = "s";
				this.timeSerieLetters[currentSignIndex] = "out";
				this.currentState = this.timeSerieStates[currentValueIndex] ;
			}
			else if (this.currentState.equals("s") && ">".contains(this.timeSerieSigns[currentSignIndex])){
				this.timeSerieStates[currentValueIndex] = "t";
				this.timeSerieLetters[currentSignIndex] = "out";
				this.currentState = this.timeSerieStates[currentValueIndex] ;
			}
			else if (this.currentState.equals("s") && "<".contains(this.timeSerieSigns[currentSignIndex])){
				this.timeSerieStates[currentValueIndex] = "r";
				this.timeSerieLetters[currentSignIndex] = "out";
				this.currentState = this.timeSerieStates[currentValueIndex] ;
			}
			else if (this.currentState.equals("r") && ">".contains(this.timeSerieSigns[currentSignIndex])){
				this.timeSerieStates[currentValueIndex] = "t";
				this.timeSerieLetters[currentSignIndex] = "foundE";
				this.currentState = this.timeSerieStates[currentValueIndex] ;
			}
			else if (this.currentState.equals("r") && "<=".contains(this.timeSerieSigns[currentSignIndex])){
				this.timeSerieStates[currentValueIndex] = "r";
				this.timeSerieLetters[currentSignIndex] = "maybeB";
				this.currentState = this.timeSerieStates[currentValueIndex] ;
			}
			else if (this.currentState.equals("t") && ">=".contains(this.timeSerieSigns[currentSignIndex])){
				this.timeSerieStates[currentValueIndex] = "t";
				this.timeSerieLetters[currentSignIndex] = "maybeB";
				this.currentState = this.timeSerieStates[currentValueIndex] ;
			}
			else if (this.currentState.equals("t") && "<".contains(this.timeSerieSigns[currentSignIndex])){
				this.timeSerieStates[currentValueIndex] = "r";
				this.timeSerieLetters[currentSignIndex] = "foundE";
				this.currentState = this.timeSerieStates[currentValueIndex] ;
			}
			this.currentValueIndex ++;
			this.currentSignIndex ++;
		}
		this.currentValueIndex = 0;
		this.currentSignIndex = 0;
		this.currentState ="s";
		System.out.println("TimeSerie States : "+this.listToString(timeSerieStates));
		System.out.println("TimeSerie Letters : "+this.listToString(timeSerieLetters));
		while(this.currentSignIndex < this.timeSerie.length-1){
		//Code timeSerie counters 
			if(this.timeSerieLetters[currentSignIndex].equals( "out") && this.after ==0){ 
				this.timeSerieResults.get("f").set(this.currentValueIndex+0,defaultF(feature)); 
				this.timeSerieResults.get("e").set(this.currentValueIndex+0,defaultF(feature)); 
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "outR")){ 
				this.timeSerieResults.get("f").set(this.currentValueIndex+0,defaultF(feature)); 
				this.timeSerieResults.get("e").set(this.currentValueIndex+0,defaultF(feature)); 
				this.currentCounters.replace("D",neutral(feature)); 
				for(int i=this.currentSignIndex;i<this.timeSerie.length-1;i++){ 
					this.timeSerieCounters.get("D").set(i,this.currentCounters.get("D")); 
				} 
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "outA")){ 
				this.timeSerieResults.get("f").set(this.currentValueIndex+0,defaultF(feature)); 
				if(this.timeSerieResults.get("C") != null ){ 
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieResults.get("C").get(this.currentSignIndex+0)); 
				}else{ 
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieCounters.get("C").get(this.currentSignIndex+0)); 
				} 
				this.currentCounters.replace("C",defaultF(feature)); 
				for(int i=this.currentSignIndex;i<this.timeSerie.length-1;i++){ 
					this.timeSerieCounters.get("C").set(i,this.currentCounters.get("C")); 
				} 
				this.currentCounters.replace("D",neutral(feature)); 
				for(int i=this.currentSignIndex;i<this.timeSerie.length-1;i++){ 
					this.timeSerieCounters.get("D").set(i,this.currentCounters.get("D")); 
				} 
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "maybeB")){ 
				this.timeSerieResults.get("f").set(this.currentValueIndex+0,defaultF(feature)); 
				if(this.timeSerieResults.get("e") != null ){ 
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieResults.get("e").get(this.currentSignIndex+1)); 
				}else{ 
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieCounters.get("e").get(this.currentSignIndex+1)); 
				} 
				this.currentCounters.replace("D",phi(feature,this.currentCounters.get("D"),delta(feature))); 
				for(int i=this.currentSignIndex;i<this.timeSerie.length-1;i++){ 
					this.timeSerieCounters.get("D").set(i,this.currentCounters.get("D")); 
				} 
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "maybeA")&& this.after ==0){ 
				this.timeSerieResults.get("f").set(this.currentValueIndex+0,defaultF(feature)); 
				if(this.timeSerieResults.get("e") != null ){ 
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieResults.get("e").get(this.currentSignIndex+1)); 
				}else{ 
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieCounters.get("e").get(this.currentSignIndex+1)); 
				} 
				this.currentCounters.replace("D",phi(feature,this.currentCounters.get("D"),deltaPrime(feature))); 
				for(int i=this.currentSignIndex;i<this.timeSerie.length-1;i++){ 
					this.timeSerieCounters.get("D").set(i,this.currentCounters.get("D")); 
				} 
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "maybeA")&& this.after ==1){ 
				this.timeSerieResults.get("f").set(this.currentValueIndex+0,defaultF(feature)); 
				if(this.timeSerieResults.get("e") != null ){ 
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieResults.get("e").get(this.currentSignIndex+1)); 
				}else{ 
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieCounters.get("e").get(this.currentSignIndex+1)); 
				} 
				this.currentCounters.replace("D",phi(feature,this.currentCounters.get("D"),delta(feature))); 
				for(int i=this.currentSignIndex;i<this.timeSerie.length-1;i++){ 
					this.timeSerieCounters.get("D").set(i,this.currentCounters.get("D")); 
				} 
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "found")&& this.after ==0){ 
				if(this.timeSerieResults.get("e") != null ){ 
					this.timeSerieResults.get("f").set(this.currentValueIndex+0,this.timeSerieResults.get("e").get(this.currentSignIndex+0)); 
				}else{ 
					this.timeSerieResults.get("f").set(this.currentValueIndex+0,this.timeSerieCounters.get("e").get(this.currentSignIndex+0)); 
				} 
				if(this.timeSerieResults.get("e") != null ){ 
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieResults.get("e").get(this.currentSignIndex+1)); 
				}else{ 
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieCounters.get("e").get(this.currentSignIndex+1)); 
				} 
				this.currentCounters.replace("C",phi(feature,phi(feature,this.currentCounters.get("D"),delta(feature)),deltaPrime(feature))); 
				for(int i=this.currentSignIndex;i<this.timeSerie.length-1;i++){ 
					this.timeSerieCounters.get("C").set(i,this.currentCounters.get("C")); 
				} 
				this.currentCounters.replace("D",neutral(feature)); 
				for(int i=this.currentSignIndex;i<this.timeSerie.length-1;i++){ 
					this.timeSerieCounters.get("D").set(i,this.currentCounters.get("D")); 
				} 
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "found")&& this.after ==1){ 
				if(this.timeSerieResults.get("e") != null ){ 
					this.timeSerieResults.get("f").set(this.currentValueIndex+0,this.timeSerieResults.get("e").get(this.currentSignIndex+0)); 
				}else{ 
					this.timeSerieResults.get("f").set(this.currentValueIndex+0,this.timeSerieCounters.get("e").get(this.currentSignIndex+0)); 
				} 
				if(this.timeSerieResults.get("e") != null ){ 
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieResults.get("e").get(this.currentSignIndex+1)); 
				}else{ 
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieCounters.get("e").get(this.currentSignIndex+1)); 
				} 
				this.currentCounters.replace("C",phi(feature,this.currentCounters.get("D"),delta(feature))); 
				for(int i=this.currentSignIndex;i<this.timeSerie.length-1;i++){ 
					this.timeSerieCounters.get("C").set(i,this.currentCounters.get("C")); 
				} 
				this.currentCounters.replace("D",neutral(feature)); 
				for(int i=this.currentSignIndex;i<this.timeSerie.length-1;i++){ 
					this.timeSerieCounters.get("D").set(i,this.currentCounters.get("D")); 
				} 
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "in")&& this.after ==0){ 
				this.timeSerieResults.get("f").set(this.currentValueIndex+0,defaultF(feature)); 
				if(this.timeSerieResults.get("e") != null ){ 
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieResults.get("e").get(this.currentSignIndex+1)); 
				}else{ 
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieCounters.get("e").get(this.currentSignIndex+1)); 
				} 
				this.currentCounters.replace("C",phi(feature,this.currentCounters.get("C"),phi(feature,this.currentCounters.get("D"),deltaPrime(feature)))); 
				for(int i=this.currentSignIndex;i<this.timeSerie.length-1;i++){ 
					this.timeSerieCounters.get("C").set(i,this.currentCounters.get("C")); 
				} 
				this.currentCounters.replace("D",neutral(feature)); 
				for(int i=this.currentSignIndex;i<this.timeSerie.length-1;i++){ 
					this.timeSerieCounters.get("D").set(i,this.currentCounters.get("D")); 
				} 
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "in")&& this.after ==1){ 
				this.timeSerieResults.get("f").set(this.currentValueIndex+0,defaultF(feature)); 
				if(this.timeSerieResults.get("e") != null ){ 
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieResults.get("e").get(this.currentSignIndex+1)); 
				}else{ 
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieCounters.get("e").get(this.currentSignIndex+1)); 
				} 
				this.currentCounters.replace("C",phi(feature,this.currentCounters.get("C"),phi(feature,this.currentCounters.get("D"),delta(feature)))); 
				for(int i=this.currentSignIndex;i<this.timeSerie.length-1;i++){ 
					this.timeSerieCounters.get("C").set(i,this.currentCounters.get("C")); 
				} 
				this.currentCounters.replace("D",neutral(feature)); 
				for(int i=this.currentSignIndex;i<this.timeSerie.length-1;i++){ 
					this.timeSerieCounters.get("D").set(i,this.currentCounters.get("D")); 
				} 
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "foundE")&& this.after ==0){ 
				this.timeSerieResults.get("f").set(this.currentValueIndex+0,phi(feature,phi(feature,this.currentCounters.get("D"),delta(feature)),deltaPrime(feature))); 
				this.timeSerieResults.get("e").set(this.currentValueIndex+0,defaultF(feature)); 
				this.currentCounters.replace("D",neutral(feature)); 
				for(int i=this.currentSignIndex;i<this.timeSerie.length-1;i++){ 
					this.timeSerieCounters.get("D").set(i,this.currentCounters.get("D")); 
				} 
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "foundE")&& this.after ==1){ 
				this.timeSerieResults.get("f").set(this.currentValueIndex+0,phi(feature,this.currentCounters.get("D"),delta(feature))); 
				this.timeSerieResults.get("e").set(this.currentValueIndex+0,defaultF(feature)); 
				this.currentCounters.replace("D",neutral(feature)); 
				for(int i=this.currentSignIndex;i<this.timeSerie.length-1;i++){ 
					this.timeSerieCounters.get("D").set(i,this.currentCounters.get("D")); 
				} 
			} 
			this.currentValueIndex ++;
			this.currentSignIndex ++;
		}
		this.currentValueIndex = this.timeSerie.length-2;
		this.currentSignIndex = this.timeSerie.length-2;
		System.out.println("TimeSerie Counters : "+this.timeSerieCounters);
		while(this.currentSignIndex >=0){
		//Code timeSerie results 
			if(this.timeSerieLetters[currentSignIndex].equals( "out") && this.after ==0){ 
				this.timeSerieResults.get("f").set(this.currentValueIndex+0,defaultF(feature)); 
				this.timeSerieResults.get("e").set(this.currentValueIndex+0,defaultF(feature)); 
				this.timeSerieResults.get("e").set(this.currentValueIndex+0,defaultF(feature)); 
				this.timeSerieResults.get("f").set(this.currentValueIndex+0,defaultF(feature)); 
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "outR")){ 
				this.timeSerieResults.get("f").set(this.currentValueIndex+0,defaultF(feature)); 
				this.timeSerieResults.get("e").set(this.currentValueIndex+0,defaultF(feature)); 
				this.timeSerieResults.get("e").set(this.currentValueIndex+0,defaultF(feature)); 
				this.timeSerieResults.get("f").set(this.currentValueIndex+0,defaultF(feature)); 
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "outA")){ 
				this.timeSerieResults.get("f").set(this.currentValueIndex+0,defaultF(feature)); 
				if(this.timeSerieResults.get("C") != null ){ 
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieResults.get("C").get(this.currentValueIndex+0)); 
				} 
				if(this.timeSerieResults.get("C") != null ){ 
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieResults.get("C").get(this.currentValueIndex+0)); 
				} else { 
				if (this.currentValueIndex >0) {
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieCounters.get("C").get(this.currentValueIndex-1)); 
				} else {
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.initCounters.get("C")); 
				}
				}
				this.timeSerieResults.get("f").set(this.currentValueIndex+0,defaultF(feature)); 
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "maybeB")){ 
				this.timeSerieResults.get("f").set(this.currentValueIndex+0,defaultF(feature)); 
				if(this.timeSerieResults.get("e") != null ){ 
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieResults.get("e").get(this.currentValueIndex+1)); 
				} 
				if(this.timeSerieResults.get("e") != null ){ 
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieResults.get("e").get(this.currentValueIndex+1)); 
				} else { 
				if (this.currentValueIndex >0) {
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieCounters.get("e").get(this.currentValueIndex-1)); 
				} else {
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.initCounters.get("e")); 
				}
				}
				this.timeSerieResults.get("f").set(this.currentValueIndex+0,defaultF(feature)); 
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "maybeA")&& this.after ==0){ 
				this.timeSerieResults.get("f").set(this.currentValueIndex+0,defaultF(feature)); 
				if(this.timeSerieResults.get("e") != null ){ 
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieResults.get("e").get(this.currentValueIndex+1)); 
				} 
				if(this.timeSerieResults.get("e") != null ){ 
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieResults.get("e").get(this.currentValueIndex+1)); 
				} else { 
				if (this.currentValueIndex >0) {
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieCounters.get("e").get(this.currentValueIndex-1)); 
				} else {
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.initCounters.get("e")); 
				}
				}
				this.timeSerieResults.get("f").set(this.currentValueIndex+0,defaultF(feature)); 
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "maybeA")&& this.after ==1){ 
				this.timeSerieResults.get("f").set(this.currentValueIndex+0,defaultF(feature)); 
				if(this.timeSerieResults.get("e") != null ){ 
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieResults.get("e").get(this.currentValueIndex+1)); 
				} 
				if(this.timeSerieResults.get("e") != null ){ 
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieResults.get("e").get(this.currentValueIndex+1)); 
				} else { 
				if (this.currentValueIndex >0) {
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieCounters.get("e").get(this.currentValueIndex-1)); 
				} else {
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.initCounters.get("e")); 
				}
				}
				this.timeSerieResults.get("f").set(this.currentValueIndex+0,defaultF(feature)); 
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "found")&& this.after ==0){ 
				if(this.timeSerieResults.get("e") != null ){ 
					this.timeSerieResults.get("f").set(this.currentValueIndex+0,this.timeSerieResults.get("e").get(this.currentValueIndex+0)); 
				} 
				if(this.timeSerieResults.get("e") != null ){ 
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieResults.get("e").get(this.currentValueIndex+1)); 
				} 
				if(this.timeSerieResults.get("e") != null ){ 
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieResults.get("e").get(this.currentValueIndex+1)); 
				} else { 
				if (this.currentValueIndex >0) {
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieCounters.get("e").get(this.currentValueIndex-1)); 
				} else {
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.initCounters.get("e")); 
				}
				}
				if(this.timeSerieResults.get("e") != null ){ 
					this.timeSerieResults.get("f").set(this.currentValueIndex+0,this.timeSerieResults.get("e").get(this.currentValueIndex+0)); 
				} else { 
				if (this.currentValueIndex >0) {
					this.timeSerieResults.get("f").set(this.currentValueIndex+0,this.timeSerieCounters.get("e").get(this.currentValueIndex-1)); 
				} else {
					this.timeSerieResults.get("f").set(this.currentValueIndex+0,this.initCounters.get("e")); 
				}
				}
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "found")&& this.after ==1){ 
				if(this.timeSerieResults.get("e") != null ){ 
					this.timeSerieResults.get("f").set(this.currentValueIndex+0,this.timeSerieResults.get("e").get(this.currentValueIndex+0)); 
				} 
				if(this.timeSerieResults.get("e") != null ){ 
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieResults.get("e").get(this.currentValueIndex+1)); 
				} 
				if(this.timeSerieResults.get("e") != null ){ 
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieResults.get("e").get(this.currentValueIndex+1)); 
				} else { 
				if (this.currentValueIndex >0) {
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieCounters.get("e").get(this.currentValueIndex-1)); 
				} else {
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.initCounters.get("e")); 
				}
				}
				if(this.timeSerieResults.get("e") != null ){ 
					this.timeSerieResults.get("f").set(this.currentValueIndex+0,this.timeSerieResults.get("e").get(this.currentValueIndex+0)); 
				} else { 
				if (this.currentValueIndex >0) {
					this.timeSerieResults.get("f").set(this.currentValueIndex+0,this.timeSerieCounters.get("e").get(this.currentValueIndex-1)); 
				} else {
					this.timeSerieResults.get("f").set(this.currentValueIndex+0,this.initCounters.get("e")); 
				}
				}
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "in")&& this.after ==0){ 
				this.timeSerieResults.get("f").set(this.currentValueIndex+0,defaultF(feature)); 
				if(this.timeSerieResults.get("e") != null ){ 
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieResults.get("e").get(this.currentValueIndex+1)); 
				} 
				if(this.timeSerieResults.get("e") != null ){ 
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieResults.get("e").get(this.currentValueIndex+1)); 
				} else { 
				if (this.currentValueIndex >0) {
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieCounters.get("e").get(this.currentValueIndex-1)); 
				} else {
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.initCounters.get("e")); 
				}
				}
				this.timeSerieResults.get("f").set(this.currentValueIndex+0,defaultF(feature)); 
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "in")&& this.after ==1){ 
				this.timeSerieResults.get("f").set(this.currentValueIndex+0,defaultF(feature)); 
				if(this.timeSerieResults.get("e") != null ){ 
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieResults.get("e").get(this.currentValueIndex+1)); 
				} 
				if(this.timeSerieResults.get("e") != null ){ 
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieResults.get("e").get(this.currentValueIndex+1)); 
				} else { 
				if (this.currentValueIndex >0) {
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.timeSerieCounters.get("e").get(this.currentValueIndex-1)); 
				} else {
					this.timeSerieResults.get("e").set(this.currentValueIndex+0,this.initCounters.get("e")); 
				}
				}
				this.timeSerieResults.get("f").set(this.currentValueIndex+0,defaultF(feature)); 
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "foundE")&& this.after ==0){ 
					if (this.currentValueIndex >0) {
					this.timeSerieResults.get("f").set(this.currentValueIndex+0,phi(feature,phi(feature,this.timeSerieCounters.get("D").get(this.currentValueIndex-1),delta(feature)),deltaPrime(feature))); 
					} else {
					this.timeSerieResults.get("f").set(this.currentValueIndex+0,phi(feature,phi(feature,this.initCounters.get("D"),delta(feature)),deltaPrime(feature))); 
					}
				this.timeSerieResults.get("e").set(this.currentValueIndex+0,defaultF(feature)); 
				this.timeSerieResults.get("e").set(this.currentValueIndex+0,defaultF(feature)); 
					if (this.currentValueIndex >0) {
					this.timeSerieResults.get("f").set(this.currentValueIndex+0,phi(feature,phi(feature,this.timeSerieCounters.get("D").get(this.currentValueIndex-1),delta(feature)),deltaPrime(feature))); 
					} else {
					this.timeSerieResults.get("f").set(this.currentValueIndex+0,phi(feature,phi(feature,this.initCounters.get("D"),delta(feature)),deltaPrime(feature))); 
					}
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "foundE")&& this.after ==1){ 
					if (this.currentValueIndex >0) {
					this.timeSerieResults.get("f").set(this.currentValueIndex+0,phi(feature,this.timeSerieCounters.get("D").get(this.currentValueIndex-1),delta(feature))); 
					} else {
					this.timeSerieResults.get("f").set(this.currentValueIndex+0,phi(feature,this.initCounters.get("D"),delta(feature))); 
					}
				this.timeSerieResults.get("e").set(this.currentValueIndex+0,defaultF(feature)); 
				this.timeSerieResults.get("e").set(this.currentValueIndex+0,defaultF(feature)); 
					if (this.currentValueIndex >0) {
					this.timeSerieResults.get("f").set(this.currentValueIndex+0,phi(feature,this.timeSerieCounters.get("D").get(this.currentValueIndex-1),delta(feature))); 
					} else {
					this.timeSerieResults.get("f").set(this.currentValueIndex+0,phi(feature,this.initCounters.get("D"),delta(feature))); 
					}
			} 
			this.currentValueIndex --;
			this.currentSignIndex --;
		}
		System.out.println("TimeSerie Results : "+this.timeSerieResults);
	}
	//Code list to string 
	public String listToString(int[] list){
		String res="[";
		for(int i=0;i<list.length;i++){
			if (i < list.length-1) {
				res+=list[i]+", ";
			} else {
				res+=list[i];
			}
		}
		res+="]";
		return res;
	}
	//Code list to string 
	public String listToString(String[] list){
		String res="[";
		for(int i=0;i<list.length;i++){
			if (i < list.length-1) {
				res+=list[i]+", ";
			} else {
				res+=list[i];
			}
		}
		res+="]";
		return res;
	}

	private int neutral(String feature) {
		switch(feature) {
			case FEATURE_ONE:
				return 0;
			case FEATURE_WIDTH:
				return 0;
			case FEATURE_SURFACE:
				return 0;
			case FEATURE_MAX:
				return Integer.MIN_VALUE;
			case FEATURE_MIN:
				return Integer.MAX_VALUE;
			case FEATURE_RANGE:
				return 0;
			default:
				return 0;
		}
	}

	private int min(String feature) {
		switch(feature) {
			case FEATURE_ONE:
				return 0;
			case FEATURE_WIDTH:
				return 0;
			case FEATURE_SURFACE:
				return Integer.MIN_VALUE;
			case FEATURE_MAX:
				return Integer.MIN_VALUE;
			case FEATURE_MIN:
				return Integer.MIN_VALUE;
			case FEATURE_RANGE:
				return 0;
			default:
				return 0;
		}
	}

	private int max(String feature) {
		switch(feature) {
			case FEATURE_ONE:
				return 1;
			case FEATURE_WIDTH:
				return this.timeSerie.length + 1;
			case FEATURE_SURFACE:
				return Integer.MAX_VALUE;
			case FEATURE_MAX:
				return Integer.MAX_VALUE;
			case FEATURE_MIN:
				return Integer.MAX_VALUE;
			case FEATURE_RANGE:
				return Integer.MAX_VALUE;
			default:
				return 0; 
		}
	}

	private int phi(String feature, int param1, int param2) {
		switch(feature) {
			case FEATURE_ONE:
				return Math.max(param1, param2);
			case FEATURE_WIDTH:
				return param1 + param2;
			case FEATURE_SURFACE:
				return param1 + param2;
			case FEATURE_MAX:
				return Math.max(param1, param2);
			case FEATURE_MIN:
				return Math.min(param1, param2);
			case FEATURE_RANGE:
				return 0;
			default:
				return 0;
		}
	}

	private int delta(String feature) {
		switch(feature) {
			case FEATURE_ONE:
				return 1;
			case FEATURE_WIDTH:
				return 1;
			case FEATURE_SURFACE:
				return this.timeSerie[this.currentValueIndex];
			case FEATURE_MAX:
				return this.timeSerie[this.currentValueIndex];
			case FEATURE_MIN:
				return this.timeSerie[this.currentValueIndex];
			case FEATURE_RANGE:
				return this.timeSerie[this.currentValueIndex];
			default:
				return 0;
		}
	}

	private int deltaPrime(String feature) {
		switch(feature) {
			case FEATURE_ONE:
				return 1;
			case FEATURE_WIDTH:
				return 1;
			case FEATURE_SURFACE:
				if(this.timeSerie.length-1 >=this.currentValueIndex+1){
					return this.timeSerie[this.currentValueIndex+1];
				}
				return 0;
			case FEATURE_MAX:
				if(this.timeSerie.length-1 >=this.currentValueIndex+1){
					return this.timeSerie[this.currentValueIndex+1];
				}
				return 0;
			case FEATURE_MIN:
				if(this.timeSerie.length-1 >=this.currentValueIndex+1){
					return this.timeSerie[this.currentValueIndex+1];
				}
				return 0;
			case FEATURE_RANGE:
				if(this.timeSerie.length-1 >=this.currentValueIndex+1){
					return this.timeSerie[this.currentValueIndex+1];
				}
				return 0;
			default:
				if(this.timeSerie.length-1 >=this.currentValueIndex+1){
					return this.timeSerie[this.currentValueIndex+1];
				}
				return 0;
		}
	}

	private int defaultF(String feature) {
		return this.defaultVal;
	}
}