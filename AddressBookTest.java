package com.capgemini.bookaddress;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AddressBookTest {

	@Test
	public void given3Contacts_WhenWrittenToFile_ShouldMatchContactEntries() {

		ContactDetails infoOne = new ContactDetails("mahi", "koyyani", "palakollu", "Andhra", 534260, 123456,
				"mahi@gmail.com");
		ContactDetails infoTwo = new ContactDetails("hari", "koyyani", "palakollu", "Andhra", 534260, 78900,
				"hari@gamil.com");
		ContactDetails infoThree = new ContactDetails("sri", "koyyani", "palakollu", "Telangana",534670, 265341,
				"sri23@gmailcom");
		List<ContactDetails> contactDetailsList = Arrays.asList(new ContactDetails[] { infoOne, infoTwo, infoThree });
		AddressBookFileIOService addressBookFileIOService = new AddressBookFileIOService();
		addressBookFileIOService.writeData(contactDetailsList);
		addressBookFileIOService.printEntries();
		List<ContactDetails> readContacts = addressBookFileIOService.readEntries();
		System.out.println(readContacts);
		Assert.assertEquals(infoOne.toString(), readContacts.get(0).toString());
		Assert.assertEquals(infoTwo.toString(), readContacts.get(1).toString());
		Assert.assertEquals(infoThree.toString(), readContacts.get(2).toString());
	}
}
