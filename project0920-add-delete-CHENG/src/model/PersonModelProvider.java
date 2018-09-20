package model;

import java.util.ArrayList;
import java.util.List;

import util.UtilFile;

public enum PersonModelProvider {
	//INSTANCE;
	INSTANCE(getFilePath()); // Call a constructor with a parameter.

	private List<Person> persons;

	private PersonModelProvider() {
		persons = new ArrayList<Person>();
		persons.add(new Person("FirstNameA", "LastNameA", "Phone1", "Address1"));
		persons.add(new Person("FirstNameB", "LastNameB", "Phone2", "Address2"));
		persons.add(new Person("FirstNameC", "LastNameC", "Phone3", "Address3"));
	}
	
	// Load the data sets from a file dynamically. 
		private PersonModelProvider(String inputdata) {
			List<String> contents = UtilFile.readFile(inputdata);
			List<List<String>> tableContents = UtilFile.convertTableContents(contents);

			persons = new ArrayList<Person>();
			for (List<String> iList : tableContents) {                        
				persons.add(new Person(iList.get(0), iList.get(1), iList.get(2), iList.get(3)));
			}
		}

		private static String getFilePath() {
			return "C:\\Users\\ksche\\workspaceCSCI4980\\workspaceCSCI4980CHENG\\project0920-add-delete-CHENG\\src\\inputdata.txt";
		}

	public List<Person> getPersons() {
		return persons;
	}
}
