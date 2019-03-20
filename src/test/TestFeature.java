package test;

public class TestFeature {
	
	public static void demarcation_pattern() {
		
		System.out.println();
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println();
	}
	
	public static void demarcation_feature() {
		
		System.out.println();
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println();
	}

	public static void main(String[] args) {
		
		//Width_DecreasingSequence
		System.out.println("Test : Width DecreasingSequence / Résultat attendu = [0,2,0,0,0,0,5,0,0,0,0,0,0,2,0,0]");
		System.out.println();
		FEATURE_DECREASING_SEQUENCE width_decreasingSequence = new FEATURE_DECREASING_SEQUENCE();
		width_decreasingSequence.getResultForATimeSerie(new int[] {3,4,2,2,5,6,6,4,4,3,1,1,4,6,4,4},"FEATURE_WIDTH",0,0);
		
		demarcation_pattern();
		
		//Width_DecreasingTerrace	
		System.out.println("Test : Width DecreasingTerrace / Résultat attendu = [0,0,0,0,0,0,2,0,0,0,0,0,2,0,0,0]");
		System.out.println();
		FEATURE_DECREASING_TERRACE width_decreasingTerrace = new FEATURE_DECREASING_TERRACE();
		width_decreasingTerrace.getResultForATimeSerie(new int[] {6,4,4,4,5,2,2,1,3,3,5,4,4,3,3,3},"FEATURE_WIDTH",0,1);
		
		demarcation_pattern();
		
		//Width_Gorge
		System.out.println("Test : Width Gorge / Résultat attendu = [0,0,3,0,0,0,0,0,0,0,0,0,2,0,1,0]");
		System.out.println();
		FEATURE_GORGE width_gorge = new FEATURE_GORGE();
		width_gorge.getResultForATimeSerie(new int[] {1,7,3,4,4,5,5,4,2,2,6,5,4,6,5,7},"FEATURE_WIDTH",0,1);
		
		demarcation_pattern();
		
		//Width_IncreasingSequence
		System.out.println("Test : Width IncreasingSequence / Résultat attendu = [0,2,0,0,0,0,5,0,0,0,0,0,0,2,0,0]");
		System.out.println();
		FEATURE_INCREASING_SEQUENCE width_increasingSequence = new FEATURE_INCREASING_SEQUENCE();
		width_increasingSequence.getResultForATimeSerie(new int[] {4,3,5,5,2,1,1,3,3,4,6,6,3,1,3,3},"FEATURE_WIDTH",0,0);
		
		demarcation_pattern();
		
		//Width_IncreasingTerrace
		System.out.println("Test : Width IncreasingTerrace / Résultat attendu = [0,0,0,0,0,0,2,0,0,0,0,0,0,3,0,0]");
		System.out.println();
		FEATURE_INCREASING_TERRACE width_increasingTerrace = new FEATURE_INCREASING_TERRACE();
		width_increasingTerrace.getResultForATimeSerie(new int[] {1,3,3,3,2,5,5,6,4,4,2,3,3,3,4,4},"FEATURE_WIDTH",0,1);
		
		demarcation_pattern();
		
		//Width_Inflexion
		System.out.println("Test : Width Inflexion / Résultat attendu = [0,0,0,3,0,0,3,1,1,1,1,1,0,2,0,0]");
		System.out.println();
		FEATURE_INFLEXION width_inflexion = new FEATURE_INFLEXION();
		width_inflexion.getResultForATimeSerie(new int[] {1,2,6,6,4,4,3,5,2,5,1,5,3,3,4,4},"FEATURE_WIDTH",0,1);
		
		demarcation_pattern();
		
		//Width_Peak
		System.out.println("Test : Width Peak / Résultat attendu = [0,0,0,0,0,2,0,0,0,0,3,0,0,0,3,0]");
		System.out.println();
		FEATURE_PEAK width_peak = new FEATURE_PEAK();
		width_peak.getResultForATimeSerie(new int[] {7,5,5,1,4,5,2,2,3,5,6,2,3,3,3,1},"FEATURE_WIDTH",0,1);
		
		demarcation_pattern();
		
		//Width_Plain
		System.out.println("Test : Width Plain / Résultat attendu = [0,0,0,1,0,0,0,1,0,0,0,0,2,0,0,0]");
		System.out.println();
		FEATURE_PLAIN width_plain = new FEATURE_PLAIN();
		width_plain.getResultForATimeSerie(new int[] {2,3,6,5,7,6,6,4,5,5,4,3,3,6,6,3},"FEATURE_WIDTH",0,1);
		
		demarcation_pattern();
		
		//Width_Plateau
		System.out.println("Test : Width Plateau / Résultat attendu = [0,0,0,0,0,0,4,0,0,0,3,0,0,0,0,0]");
		System.out.println();
		FEATURE_PLATEAU width_plateau = new FEATURE_PLATEAU();
		width_plateau.getResultForATimeSerie(new int[] {1,3,3,5,5,5,5,2,4,4,4,3,3,1,5,5},"FEATURE_WIDTH",0,1);
		
		demarcation_pattern();
		
		//Width_ProperPlain
		System.out.println("Test : Width ProperPlain / Résultat attendu = [0,0,0,2,0,0,0,0,2,0,0,0,0,0,3,0]");
		System.out.println();
		FEATURE_PROPER_PLAIN width_properPlain = new FEATURE_PROPER_PLAIN();
		width_properPlain.getResultForATimeSerie(new int[] {2,7,5,5,6,3,7,4,4,5,6,5,3,3,3,5},"FEATURE_WIDTH",0,1);
		
		demarcation_pattern();
		
		//Width_ProperPlateau
		System.out.println("Test : Width ProperPlateau / Résultat attendu = [0,0,0,2,0,0,0,0,2,0,0,0,0,0,3,0]");
		System.out.println();
		FEATURE_PROPER_PLATEAU width_properPlateau = new FEATURE_PROPER_PLATEAU();
		width_properPlateau.getResultForATimeSerie(new int[] {7,1,3,3,2,5,1,4,4,3,2,3,5,5,5,3},"FEATURE_WIDTH",0,1);
		
		demarcation_pattern();
		
		//Width_SteadySequence
		System.out.println("Test : Width SteadySequence / Résultat attendu = [0,2,0,0,3,0,0,0,2,0,2,0,0,0,2,0]");
		System.out.println();
		FEATURE_STEADY_SEQUENCE width_steadySequence = new FEATURE_STEADY_SEQUENCE();
		width_steadySequence.getResultForATimeSerie(new int[] {3,1,1,4,5,5,5,6,2,2,4,4,3,2,1,1},"FEATURE_WIDTH",0,0);
		
		demarcation_pattern();
		
		//Width_StrictlyDecreasingSequence
		System.out.println("Test : Width StrictlyDecreasingSequence / Résultat attendu = [0,0,3,0,0,0,0,0,0,0,3,0,0,0,2,0]");
		System.out.println();
		FEATURE_STRICTLY_DECREASING_SEQUENCE width_strictlyDecreasingSequence = new FEATURE_STRICTLY_DECREASING_SEQUENCE();
		width_strictlyDecreasingSequence.getResultForATimeSerie(new int[] {4,4,6,4,1,1,3,4,4,6,6,5,2,2,4,3},"FEATURE_WIDTH",0,0);
		
		demarcation_pattern();
		
		//Width_StrictlyIncreasingSequence
		System.out.println("Test : Width StrictlyIncreasingSequence / Résultat attendu = [0,2,0,0,0,0,5,0,0,0,0,0,0,3,0,0]");
		System.out.println();
		FEATURE_STRICTLY_INCREASING_SEQUENCE width_strictlyIncreasingSequence = new FEATURE_STRICTLY_INCREASING_SEQUENCE();
		width_strictlyIncreasingSequence.getResultForATimeSerie(new int[] {4,3,5,5,2,1,1,2,3,4,6,6,3,1,2,3},"FEATURE_WIDTH",0,0);
		
		demarcation_pattern();
		
		//Width_Summit
		System.out.println("Test : Width Summit / Résultat attendu = [0,0,3,0,0,0,0,0,0,0,0,0,2,0,1,0]");
		System.out.println();
		FEATURE_SUMMIT width_summit = new FEATURE_SUMMIT();
		width_summit.getResultForATimeSerie(new int[] {7,1,5,4,4,3,3,4,6,6,2,3,4,2,3,1},"FEATURE_WIDTH",0,1);
		
		demarcation_pattern();
		
		//Width_Valley
		System.out.println("Test : Width Valley / Résultat attendu = [0,0,0,0,2,0,0,0,0,0,4,0,0,0,3,0]");
		System.out.println();
		FEATURE_VALLEY width_valley = new FEATURE_VALLEY();
		width_valley.getResultForATimeSerie(new int[] {1,3,7,4,3,6,6,5,3,3,2,6,5,5,5,7},"FEATURE_WIDTH",0,1);
		
		demarcation_pattern();
		
		//Width_Zigzag
		System.out.println("Test : Width Zigzag / Résultat attendu = [0,0,3,0,0,0,2,0,0,0,6,0,0,0,0,0]");
		System.out.println();
		FEATURE_ZIGZAG width_zigzag = new FEATURE_ZIGZAG();
		width_zigzag.getResultForATimeSerie(new int[] {4,1,3,1,4,6,1,5,5,2,7,2,3,1,6,1},"FEATURE_WIDTH",0,1);
		
		demarcation_feature();
		
		//Surf_BumpOnDecreasingSequence
		System.out.println("Test : Surf BumpOnDecreasingSequence / Résultat attendu = [0,0,0,0,16,0,0,0,0,0,0,0,0,11,0,0]");
		System.out.println();
		FEATURE_BUMP_ON_DECREASING_SEQUENCE surf_bumpOnDecreasingSequence = new FEATURE_BUMP_ON_DECREASING_SEQUENCE();
		surf_bumpOnDecreasingSequence.getResultForATimeSerie(new int[] {7,6,5,6,5,4,1,4,7,5,4,2,5,4,3,3},"FEATURE_SURFACE",0,0);
		
		demarcation_pattern();
		
		//Surf_Decreasing
		System.out.println("Test : Surf Decreasing / Résultat attendu = [0,6,0,0,0,0,10,0,7,4,0,0,0,10,0,0]");
		System.out.println();
		FEATURE_DECREASING surf_decreasing = new FEATURE_DECREASING();
		surf_decreasing.getResultForATimeSerie(new int[] {3,4,2,2,5,6,6,4,4,3,1,1,4,6,4,4},"FEATURE_SURFACE",0,0);
		
		demarcation_pattern();
		
		//Surf_DecreasingSequence
		System.out.println("Test : Surf DecreasingSequence / Résultat attendu = [0,6,0,0,0,0,18,0,0,0,0,0,0,10,0,0]");
		System.out.println();
		FEATURE_DECREASING_SEQUENCE surf_decreasingSequence = new FEATURE_DECREASING_SEQUENCE();
		surf_decreasingSequence.getResultForATimeSerie(new int[] {3,4,2,2,5,6,6,4,4,3,1,1,4,6,4,4},"FEATURE_SURFACE",0,0);

		demarcation_pattern();
		
		//Surf_DecreasingTerrace
		System.out.println("Test : Surf DecreasingTerrace / Résultat attendu = [0,0,0,0,0,0,4,0,0,0,0,0,8,0,0,0]");
		System.out.println();
		FEATURE_DECREASING_TERRACE surf_decreasingTerrace = new FEATURE_DECREASING_TERRACE();
		surf_decreasingTerrace.getResultForATimeSerie(new int[] {6,4,4,4,5,2,2,1,3,3,5,4,4,3,3,3},"FEATURE_SURFACE",0,0);
		
		demarcation_pattern();
		
		//Surf_DipOnIncreasingSequence
		System.out.println("Test : Surf DipOnIncreasingSequence / Résultat attendu = [0,0,0,0,10,0,0,0,0,0,0,0,0,9,0,0]");
		System.out.println();
		FEATURE_DIP_ON_INCREASING_SEQUENCE surf_dipOnIncreasingSequence = new FEATURE_DIP_ON_INCREASING_SEQUENCE();
		surf_dipOnIncreasingSequence.getResultForATimeSerie(new int[] {1,2,3,2,5,6,7,4,1,3,4,6,1,2,4,4},"FEATURE_SURFACE",0,0);
		
		demarcation_pattern();
		
		//Surf_Gorge
		System.out.println("Test : Surf Gorge / Résultat attendu = [0,0,11,0,0,0,0,0,0,0,0,0,9,0,5,0]");
		System.out.println();
		FEATURE_GORGE surf_gorge = new FEATURE_GORGE();
		surf_gorge.getResultForATimeSerie(new int[] {1,7,3,4,4,5,5,4,2,2,6,5,4,6,5,7},"FEATURE_SURFACE",0,0);
		
		demarcation_pattern();
		
		//Surf_Increasing
		System.out.println("Test : Surf Increasing / Résultat attendu = [0,8,0,0,0,0,4,0,7,10,0,0,0,4,0,0]");
		System.out.println();
		FEATURE_INCREASING surf_increasing = new FEATURE_INCREASING();
		surf_increasing.getResultForATimeSerie(new int[] {4,3,5,5,2,1,1,3,3,4,6,6,3,1,3,3},"FEATURE_SURFACE",0,0);
		
		demarcation_pattern();
		
		//Surf_IncreasingSequence
		System.out.println("Test : Surf IncreasingSequence / Résultat attendu = [0,8,0,0,0,0,17,0,0,0,0,0,0,4,0,0]");
		System.out.println();
		FEATURE_INCREASING_SEQUENCE surf_increasingSequence = new FEATURE_INCREASING_SEQUENCE();
		surf_increasingSequence.getResultForATimeSerie(new int[] {4,3,5,5,2,1,1,3,3,4,6,6,3,1,3,3},"FEATURE_SURFACE",0,0);
		
		demarcation_pattern();
		
		//Surf_IncreasingTerrace
		System.out.println("Test : Surf IncreasingTerrace / Résultat attendu = [0,0,0,0,0,0,10,0,0,0,0,0,0,9,0,0]");
		System.out.println();
		FEATURE_INCREASING_TERRACE surf_increasingTerrace = new FEATURE_INCREASING_TERRACE();
		surf_increasingTerrace.getResultForATimeSerie(new int[] {1,3,3,3,2,5,5,6,4,4,2,3,3,3,4,4},"FEATURE_SURFACE",0,0);
		
		demarcation_pattern();
		
		//Surf_Inflexion
		System.out.println("Test : Surf Inflexion / Résultat attendu = [0,0,0,14,0,0,11,5,2,5,1,5,0,6,0,0]");
		System.out.println();
		FEATURE_INFLEXION surf_inflexion = new FEATURE_INFLEXION();
		surf_inflexion.getResultForATimeSerie(new int[] {1,2,6,6,4,4,3,5,2,5,1,5,3,3,4,4},"FEATURE_SURFACE",0,0);
		
		demarcation_pattern();
		
		//Surf_Peak
		System.out.println("Test : Surf Peak / Résultat attendu = [0,0,0,0,0,9,0,0,0,0,14,0,0,0,9,0]");
		System.out.println();
		FEATURE_PEAK surf_peak = new FEATURE_PEAK();
		surf_peak.getResultForATimeSerie(new int[] {7,5,5,1,4,5,2,2,3,5,6,2,3,3,3,1},"FEATURE_SURFACE",0,0);
		
		demarcation_pattern();
		
		//Surf_Plain
		System.out.println("Test : Surf Plain / Résultat attendu = [0,0,0,5,0,0,0,4,0,0,0,0,6,0,0,0]");
		System.out.println();
		FEATURE_PLAIN surf_plain = new FEATURE_PLAIN();
		surf_plain.getResultForATimeSerie(new int[] {2,3,6,5,7,6,6,4,5,5,4,3,3,6,6,3},"FEATURE_SURFACE",0,0);
		
		demarcation_pattern();
		
		//Surf_Plateau
		System.out.println("Test : Surf Plateau / Résultat attendu = [0,0,0,3,0,0,0,4,0,0,0,0,10,0,0,0]");
		System.out.println();
		FEATURE_PLATEAU surf_plateau = new FEATURE_PLATEAU();
		surf_plateau.getResultForATimeSerie(new int[] {7,5,2,3,1,2,2,4,3,3,4,5,5,2,2,5},"FEATURE_SURFACE",0,0);
		
		demarcation_pattern();
		
		//Surf_ProperPlain
		System.out.println("Test : Surf ProperPlain / Résultat attendu = [0,0,0,10,0,0,0,0,8,0,0,0,0,0,9,0]");
		System.out.println();
		FEATURE_PROPER_PLAIN surf_properPlain = new FEATURE_PROPER_PLAIN();
		surf_properPlain.getResultForATimeSerie(new int[] {2,7,5,5,6,3,7,4,4,5,6,5,3,3,3,5},"FEATURE_SURFACE",0,0);
		
		demarcation_pattern();
		
		//Surf_ProperPlateau
		System.out.println("Test : Surf ProperPlateau / Résultat attendu = [0,0,0,6,0,0,0,0,8,0,0,0,0,0,15,0]");
		System.out.println();
		FEATURE_PROPER_PLATEAU surf_properPlateau = new FEATURE_PROPER_PLATEAU();
		surf_properPlateau.getResultForATimeSerie(new int[] {7,1,3,3,2,5,1,4,4,3,2,3,5,5,5,3},"FEATURE_SURFACE",0,0);
		
		demarcation_pattern();
		
		//Surf_Steady
		System.out.println("Test : Surf Steady / Résultat attendu = [2,0,0,6,0,10,10,0,0,10,10,0,0,0,12,0]");
		System.out.println();
		FEATURE_STEADY surf_steady = new FEATURE_STEADY();
		surf_steady.getResultForATimeSerie(new int[] {1,1,7,3,3,5,5,5,6,5,5,5,7,2,6,6},"FEATURE_SURFACE",0,0);
		
		demarcation_pattern();
		
		//Surf_SteadySequence
		System.out.println("Test : Surf SteadySequence / Résultat attendu = [0,2,0,0,15,0,0,0,4,0,8,0,0,0,2,0]");
		System.out.println();
		FEATURE_STEADY_SEQUENCE surf_steadySequence = new FEATURE_STEADY_SEQUENCE();
		surf_steadySequence.getResultForATimeSerie(new int[] {3,1,1,4,5,5,5,6,2,2,4,4,3,2,1,1},"FEATURE_SURFACE",0,0);
		
		demarcation_pattern();
		
		//Surf_StrictlyDecreasingSequence
		System.out.println("Test : Surf StrictlyDecreasingSequence / Résultat attendu = [0,0,11,0,0,0,0,0,0,0,13,0,0,0,7,0]");
		System.out.println();
		FEATURE_STRICTLY_DECREASING_SEQUENCE surf_strictlyDecreasingSequence = new FEATURE_STRICTLY_DECREASING_SEQUENCE();
		surf_strictlyDecreasingSequence.getResultForATimeSerie(new int[] {4,4,6,4,1,1,3,4,4,6,6,5,2,2,4,3},"FEATURE_SURFACE",0,0);
		
		demarcation_pattern();
		
		//Surf_StrictlyIncreasingSequence
		System.out.println("Test : Surf StrictlyIncreasingSequence / Résultat attendu = [0,8,0,0,0,0,16,0,0,0,0,0,0,6,0,0]");
		System.out.println();
		FEATURE_STRICTLY_INCREASING_SEQUENCE surf_strictlyIncreasingSequence = new FEATURE_STRICTLY_INCREASING_SEQUENCE();
		surf_strictlyIncreasingSequence.getResultForATimeSerie(new int[] {4,3,5,5,2,1,1,2,3,4,6,6,3,1,2,3},"FEATURE_SURFACE",0,0);
		
		demarcation_pattern();
		
		//Surf_Summit
		System.out.println("Test : Surf Summit / Résultat attendu = [0,0,13,0,0,0,0,0,0,0,0,0,7,0,3,0]");
		System.out.println();
		FEATURE_SUMMIT surf_summit = new FEATURE_SUMMIT();
		surf_summit.getResultForATimeSerie(new int[] {7,1,5,4,4,3,3,4,6,6,2,3,4,2,3,1},"FEATURE_SURFACE",0,0);
		
		demarcation_pattern();
		
		//Surf_Valley
		System.out.println("Test : Surf Valley / Résultat attendu = [0,0,0,0,7,0,0,0,0,0,13,0,0,0,15,0]");
		System.out.println();
		FEATURE_VALLEY surf_valley = new FEATURE_VALLEY();
		surf_valley.getResultForATimeSerie(new int[] {1,3,7,4,3,6,6,5,3,3,2,6,5,5,5,7},"FEATURE_SURFACE",0,0);
		
		demarcation_pattern();
		
		//Surf_Zigzag
		System.out.println("Test : Surf Zigzag / Résultat attendu = [0,0,5,0,0,0,7,0,0,0,21,0,0,0,0,0]");
		System.out.println();
		FEATURE_ZIGZAG surf_zigzag = new FEATURE_ZIGZAG();
		surf_zigzag.getResultForATimeSerie(new int[] {4,1,3,1,4,6,1,5,5,2,7,2,3,1,6,1},"FEATURE_SURFACE",0,0);
		
		demarcation_feature();
		
		//Max_BumpOnDecreasingSequence
		System.out.println("Test : Max BumpOnDecreasingSequence / Résultat attendu = [0,0,0,0,6,0,0,0,0,0,0,0,0,5,0,0]");
		System.out.println();
		FEATURE_BUMP_ON_DECREASING_SEQUENCE max_bumpOnDecreasingSequence = new FEATURE_BUMP_ON_DECREASING_SEQUENCE();
		max_bumpOnDecreasingSequence.getResultForATimeSerie(new int[] {7,6,5,6,5,4,1,4,7,5,4,2,5,4,3,3},"FEATURE_MAX",0,0);
		
		demarcation_pattern();
		
		//Max_Decreasing
		System.out.println("Test : Max Decreasing / Résultat attendu = [0,4,0,0,0,0,6,0,4,3,0,0,0,6,0,0]");
		System.out.println();
		FEATURE_DECREASING max_decreasing = new FEATURE_DECREASING();
		max_decreasing.getResultForATimeSerie(new int[] {3,4,2,2,5,6,6,4,4,3,1,1,4,6,4,4},"FEATURE_MAX",0,0);
		
		demarcation_pattern();
		
		//Max_DecreasingSequence
		System.out.println("Test : Max DecreasingSequence / Résultat attendu = [0,4,0,0,0,0,6,0,0,0,0,0,0,6,0,0]");
		System.out.println();
		FEATURE_DECREASING_SEQUENCE max_decreasingSequence = new FEATURE_DECREASING_SEQUENCE();
		max_decreasingSequence.getResultForATimeSerie(new int[] {3,4,2,2,5,6,6,4,4,3,1,1,4,6,4,4},"FEATURE_MAX",0,0);
		
		demarcation_pattern();
		
		//Max_DipOnIncreasingSequence
		System.out.println("Test : Max DipOnIncreasingSequence / Résultat attendu = [0,0,0,0,5,0,0,0,0,0,0,0,0,6,0,0]");
		System.out.println();
		FEATURE_DIP_ON_INCREASING_SEQUENCE max_dipOnIncreasingSequence = new FEATURE_DIP_ON_INCREASING_SEQUENCE();
		max_dipOnIncreasingSequence.getResultForATimeSerie(new int[] {1,2,3,2,5,6,7,4,1,3,4,6,1,2,4,4},"FEATURE_MAX",0,0);
		
		demarcation_pattern();
		
		//Max_Increasing
		System.out.println("Test : Max Increasing / Résultat attendu = [0,5,0,0,0,0,3,0,4,6,0,0,0,3,0,0]");
		System.out.println();
		FEATURE_INCREASING max_increasing = new FEATURE_INCREASING();
		max_increasing.getResultForATimeSerie(new int[] {4,3,5,5,2,1,1,3,3,4,6,6,3,1,3,3},"FEATURE_MAX",0,0);
		
		demarcation_pattern();
		
		//Max_IncreasingSequence
		System.out.println("Test : Max IncreasingSequence / Résultat attendu = [0,5,0,0,0,0,6,0,0,0,0,0,0,3,0,0]");
		System.out.println();
		FEATURE_INCREASING_SEQUENCE max_increasingSequence = new FEATURE_INCREASING_SEQUENCE();
		max_increasingSequence.getResultForATimeSerie(new int[] {4,3,5,5,2,1,1,3,3,4,6,6,3,1,3,3},"FEATURE_MAX",0,0);
		
		demarcation_pattern();
		
		//Max_Inflexion
		System.out.println("Test : Max Inflexion / Résultat attendu = [0,0,0,6,0,0,4,5,2,5,1,5,0,3,0,0]");
		System.out.println();
		FEATURE_INFLEXION max_inflexion = new FEATURE_INFLEXION();
		max_inflexion.getResultForATimeSerie(new int[] {1,2,6,6,4,4,3,5,2,5,1,5,3,3,4,4},"FEATURE_MAX",0,0);
		
		demarcation_pattern();
		
		//Max_Peak
		System.out.println("Test : Max Peak / Résultat attendu = [0,0,0,0,0,5,0,0,0,0,6,0,0,0,3,0]");
		System.out.println();
		FEATURE_PEAK max_peak = new FEATURE_PEAK();
		max_peak.getResultForATimeSerie(new int[] {7,5,5,1,4,5,2,2,3,5,6,2,3,3,3,1},"FEATURE_MAX",0,0);
		
		demarcation_pattern();
		
		//Max_StrictlyDecreasingSequence
		System.out.println("Test : Max StrictlyDecreasingSequence / Résultat attendu = [0,0,6,0,0,0,0,0,0,0,6,0,0,0,4,0]");
		System.out.println();
		FEATURE_STRICTLY_DECREASING_SEQUENCE max_strictlyDecreasingSequence = new FEATURE_STRICTLY_DECREASING_SEQUENCE();
		max_strictlyDecreasingSequence.getResultForATimeSerie(new int[] {4,4,6,4,1,1,3,4,4,6,6,5,2,2,4,3},"FEATURE_MAX",0,0);
		
		demarcation_pattern();
		
		//Max_StrictlyIncreasingSequence
		System.out.println("Test : Max StrictlyIncreasingSequence / Résultat attendu = [0,5,0,0,0,0,6,0,0,0,0,0,0,3,0,0]");
		System.out.println();
		FEATURE_STRICTLY_INCREASING_SEQUENCE max_strictlyIncreasingSequence = new FEATURE_STRICTLY_INCREASING_SEQUENCE();
		max_strictlyIncreasingSequence.getResultForATimeSerie(new int[] {4,3,5,5,2,1,1,2,3,4,6,6,3,1,2,3},"FEATURE_MAX",0,0);
		
		demarcation_pattern();
		
		//Max_Summit
		System.out.println("Test : Max Summit / Résultat attendu = [0,0,5,0,0,0,0,0,0,0,0,0,4,0,3,0]");
		System.out.println();
		FEATURE_SUMMIT max_summit = new FEATURE_SUMMIT();
		max_summit.getResultForATimeSerie(new int[] {7,1,5,4,4,3,3,4,6,6,2,3,4,2,3,1},"FEATURE_MAX",0,0);
		
		demarcation_pattern();
	
		//Max_Zigzag
		System.out.println("Test : Max Zigzag / Résultat attendu = [0,0,3,0,0,0,6,0,0,0,7,0,0,0,0,0]");
		System.out.println();
		FEATURE_ZIGZAG max_zigzag = new FEATURE_ZIGZAG();
		max_zigzag.getResultForATimeSerie(new int[] {4,1,3,1,4,6,1,5,5,2,7,2,3,1,6,1},"FEATURE_MAX",0,0);
		
		demarcation_feature();
		
		//Min_BumpOnDecreasingSequence
		System.out.println("Test : Min BumpOnDecreasingSequence / Résultat attendu = [0,0,0,0,5,0,0,0,0,0,0,0,0,2,0,0]");
		System.out.println();
		FEATURE_BUMP_ON_DECREASING_SEQUENCE min_bumpOnDecreasingSequence = new FEATURE_BUMP_ON_DECREASING_SEQUENCE();
		min_bumpOnDecreasingSequence.getResultForATimeSerie(new int[] {7,6,5,6,5,4,1,4,7,5,4,2,5,4,3,3},"FEATURE_MIN",0,0);
		
		demarcation_pattern();
		
		//Min_Decreasing
		System.out.println("Test : Min Decreasing / Résultat attendu = [0,2,0,0,0,0,4,0,3,1,0,0,0,4,0,0]");
		System.out.println();
		FEATURE_DECREASING min_decreasing = new FEATURE_DECREASING();
		min_decreasing.getResultForATimeSerie(new int[] {3,4,2,2,5,6,6,4,4,3,1,1,4,6,4,4},"FEATURE_MIN",0,0);
		
		demarcation_pattern();
		
		//Min_DecreasingSequence
		System.out.println("Test : Min DecreasingSequence / Résultat attendu = [0,2,0,0,0,0,1,0,0,0,0,0,0,4,0,0]");
		System.out.println();
		FEATURE_DECREASING_SEQUENCE min_decreasingSequence = new FEATURE_DECREASING_SEQUENCE();
		min_decreasingSequence.getResultForATimeSerie(new int[] {3,4,2,2,5,6,6,4,4,3,1,1,4,6,4,4},"FEATURE_MIN",0,0);
		
		demarcation_pattern();
		
		//Min_DipOnIncreasingSequence
		System.out.println("Test : Min DipOnIncreasingSequence / Résultat attendu = [0,0,0,0,2,0,0,0,0,0,0,0,0,1,0,0]");
		System.out.println();
		FEATURE_DIP_ON_INCREASING_SEQUENCE min_dipOnIncreasingSequence = new FEATURE_DIP_ON_INCREASING_SEQUENCE();
		min_dipOnIncreasingSequence.getResultForATimeSerie(new int[] {1,2,3,2,5,6,7,4,1,3,4,6,1,2,4,4},"FEATURE_MIN",0,0);
		
		demarcation_pattern();
		
		//Min_Gorge
		System.out.println("Test : Min Gorge / Résultat attendu = [0,0,3,0,0,0,0,0,0,0,0,0,4,0,5,0]");
		System.out.println();
		FEATURE_GORGE min_gorge = new FEATURE_GORGE();
		min_gorge.getResultForATimeSerie(new int[] {1,7,3,4,4,5,5,4,2,2,6,5,4,6,5,7},"FEATURE_MIN",0,0);
		
		demarcation_pattern();
		
		//Min_Increasing
		System.out.println("Test : Min Increasing / Résultat attendu = [0,3,0,0,0,0,1,0,3,4,0,0,0,1,0,0]");
		System.out.println();
		FEATURE_INCREASING min_increasing = new FEATURE_INCREASING();
		min_increasing.getResultForATimeSerie(new int[] {4,3,5,5,2,1,1,3,3,4,6,6,3,1,3,3},"FEATURE_MIN",0,0);
		
		demarcation_pattern();
		
		//Min_IncreasingSequence
		System.out.println("Test : Min IncreasingSequence / Résultat attendu = [0,3,0,0,0,0,1,0,0,0,0,0,0,1,0,0]");
		System.out.println();
		FEATURE_INCREASING_SEQUENCE min_increasingSequence = new FEATURE_INCREASING_SEQUENCE();
		min_increasingSequence.getResultForATimeSerie(new int[] {4,3,5,5,2,1,1,3,3,4,6,6,3,1,3,3},"FEATURE_MIN",0,0);
		
		demarcation_pattern();
		
		//Min_Inflexion
		System.out.println("Test : Min Inflexion / Résultat attendu = [0,0,0,2,0,0,3,5,2,5,1,5,0,3,0,0]");
		System.out.println();
		FEATURE_INFLEXION min_inflexion = new FEATURE_INFLEXION();
		min_inflexion.getResultForATimeSerie(new int[] {1,2,6,6,4,4,3,5,2,5,1,5,3,3,4,4},"FEATURE_MIN",0,0);
		
		demarcation_pattern();
		
		//Min_StrictlyDecreasingSequence
		System.out.println("Test : Min StrictlyDecreasingSequence / Résultat attendu = [0,0,1,0,0,0,0,0,0,0,2,0,0,0,3,0]");
		System.out.println();
		FEATURE_STRICTLY_DECREASING_SEQUENCE min_strictlyDecreasingSequence = new FEATURE_STRICTLY_DECREASING_SEQUENCE();
		min_strictlyDecreasingSequence.getResultForATimeSerie(new int[] {4,4,6,4,1,1,3,4,4,6,6,5,2,2,4,3},"FEATURE_MIN",0,0);
		
		demarcation_pattern();
		
		//Min_StrictlyIncreasingSequence
		System.out.println("Test : Min StrictlyIncreasingSequence / Résultat attendu = [0,3,0,0,0,0,1,0,0,0,0,0,0,1,0,0]");
		System.out.println();
		FEATURE_STRICTLY_INCREASING_SEQUENCE min_strictlyIncreasingSequence = new FEATURE_STRICTLY_INCREASING_SEQUENCE();
		min_strictlyIncreasingSequence.getResultForATimeSerie(new int[] {4,3,5,5,2,1,1,2,3,4,6,6,3,1,2,3},"FEATURE_MIN",0,0);
		
		demarcation_pattern();
		
		//Min_Valley
		System.out.println("Test : Min Valley / Résultat attendu = [0,0,0,0,3,0,0,0,0,0,2,0,0,0,5,0]");
		System.out.println();
		FEATURE_VALLEY min_valley = new FEATURE_VALLEY();
		min_valley.getResultForATimeSerie(new int[] {1,3,7,4,3,6,6,5,3,3,2,6,5,5,5,7},"FEATURE_MIN",0,0);
		
		demarcation_pattern();
		
		//Min_Zigzag
		System.out.println("Test : Min Zigzag / Résultat attendu = [0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0]");
		System.out.println();
		FEATURE_ZIGZAG min_zigzag = new FEATURE_ZIGZAG();
		min_zigzag.getResultForATimeSerie(new int[] {4,1,3,1,4,6,1,5,5,2,7,2,3,1,6,1},"FEATURE_MIN",0,1);
	}
}
