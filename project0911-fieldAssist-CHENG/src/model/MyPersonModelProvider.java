package model;

import java.util.ArrayList;
import java.util.List;

import util.UtilFile;

public enum MyPersonModelProvider {
		 //INSTANCE;
		INSTANCE(getFilePath()); // Call a constructor with a parameter. 

		private List<MyPerson> persons;

	        // Load hard-coded data sets. 
		private MyPersonModelProvider() {
			persons = new ArrayList<MyPerson>();
			persons.add(new MyPerson("AFirstName1", "ALastName1", "female", true));
		      persons.add(new MyPerson("CFirstName1", "CLastName1", "female", true));
		      persons.add(new MyPerson("DFirstName1", "DLastName1", "male", true));
		      persons.add(new MyPerson("BFirstName1", "BLastName1", "female", true));
		      persons.add(new MyPerson("AFirstName3", "ALastName3", "female", true));
		      persons.add(new MyPerson("CFirstName3", "CLastName3", "female", true));
		      persons.add(new MyPerson("DFirstName3", "DLastName3", "male", true));
		      persons.add(new MyPerson("BFirstName3", "BLastName3", "female", true));
		      persons.add(new MyPerson("AFirstName2", "ALastName2", "male", false));
		      persons.add(new MyPerson("CFirstName2", "CLastName2", "female", true));
		      persons.add(new MyPerson("DFirstName2", "DLastName2", "female", true));
		      persons.add(new MyPerson("BFirstName2", "BLastName2", "female", true));
		}

	        // Load the data sets from a file dynamically. 
		private MyPersonModelProvider(String inputdata) {
			List<String> contents = UtilFile.readFile(inputdata);
			List<List<String>> tableContents = UtilFile.convertTableContents(contents);

			persons = new ArrayList<MyPerson>();
			for (List<String> iList : tableContents) {
				persons.add(new MyPerson(iList.get(0), iList.get(1), iList.get(2), Boolean.valueOf(iList.get(3))));
			}
		}

		private static String getFilePath() {
			return "C:\\Users\\ksche\\workspaceCSCI4980\\workspaceCSCI4980CHENG\\project0911-fieldAssist-CHENG\\src\\inputdata.txt";
		}

		public List<MyPerson> getPersons() {
			return persons;
		}
	

}
