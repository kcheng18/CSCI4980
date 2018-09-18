package model;

import java.util.ArrayList;
import java.util.List;

import util.UtilFile;

public enum ModelProvider {
	INSTANCE(getFilePath()); // Call a constructor with a parameter.

	private List<Person> persons;

	private ModelProvider() {
		persons = new ArrayList<Person>();
		persons.add(new Person("FirstNameA", "LastNameA", "Address1"));
		persons.add(new Person("FirstNameB", "LastNameB", "Address2"));
		persons.add(new Person("FirstNameC", "LastNameC", "Address3"));
	}
	
	// Load the data sets from a file dynamically. 
		private ModelProvider(String inputdata) {
			List<String> contents = UtilFile.readFile(inputdata);
			List<List<String>> tableContents = UtilFile.convertTableContents(contents);

			persons = new ArrayList<Person>();
			for (List<String> iList : tableContents) {                        
				persons.add(new Person(iList.get(0), iList.get(1), iList.get(2)));
			}
		}

		private static String getFilePath() {
			return "C:\\Users\\ksche\\workspaceCSCI4980\\workspaceCSCI4980CHENG\\project0918-filtering-CHENG\\src\\inputdata.txt";
		}

	public List<Person> getPersons() {
		return persons;
	}
}
