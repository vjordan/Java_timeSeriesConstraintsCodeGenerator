package main;

import java.io.IOException;

import model.generator.Generator;
import model.parameters.decorationTable.DecorationTable;
import model.parameters.seedTemplate.SeedTemplate;
import parser.DecorationTableParser;
import parser.SeedTemplateParser;

public class GeneratorMain {

	public static void main(String[] args) throws IOException {
		
		String dossier_decoration_table = "DecorationTables/";
		String dossier_seed_template = "SeedTemplates/";
		String fichiers_table_extension = "DecorationTable.json";
		String fichiers_seed_extension = "SeedTemplate.json";
		String[] noms_decoration_table = {"Footprint", "Feature"};
		String[] noms_seed_tempalte = {"BumpOnDecreasingSequence", "Decreasing", "DecreasingSequence", "DecreasingTerrace", "DipOnIncreasingSequence", "Gorge", "Increasing", "IncreasingSequence", "IncreasingTerrace", "Inflexion", "Peak", "Plain", "Plateau", "ProperPlain", "ProperPlateau", "Steady", "SteadySequence", "StrictlyDecreasingSequence", "StrictlyIncreasingSequence", "Summit", "Valley", "Zigzag"};
		
		System.out.println("Generateur de code Java pour des series temporelles");
		
		for(String nom_decoration_table : noms_decoration_table) {
			for(String nom_seed_template : noms_seed_tempalte) {
				
				String fileDecorationTable = dossier_decoration_table + nom_decoration_table + fichiers_table_extension;
				String fileSeedTemplate = dossier_seed_template + nom_seed_template + fichiers_seed_extension;
				
				DecorationTable table = DecorationTableParser.parseDecorationTable(fileDecorationTable);
				SeedTemplate seed = SeedTemplateParser.parseSeedTemplate(fileSeedTemplate);
				
				System.out.println("Lancement de la generation de code");
				Generator generator = new Generator(table,seed);
				generator.seeCodeInConsole();
				generator.saveCodeInFile("src/test/"+table.getName().toUpperCase()+"_"+seed.getName().toUpperCase()+".java");
			}
		}
	}
}
