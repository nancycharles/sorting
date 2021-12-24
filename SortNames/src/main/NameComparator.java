package main;

import java.util.Comparator;

class NameComparator implements Comparator<PersonName> {

	public int compare(PersonName person1, PersonName person2)
    {
           return person1.lastName.compareTo(person2.lastName);
    }
}
