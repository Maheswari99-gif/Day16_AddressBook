package com.capgemini.bookaddress;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AddressBookJsonIOServiceTest {
	@Test
	public void given3ContactsWhenWrittenToJsonFileShouldMatchContactEntries() {
		ContactDetails mahi = new ContactDetails("mahi", "koyyani", "palakollu", "AP", 12, 12345, "mahi@gmail.com");
		ContactDetails hari = new ContactDetails("hari", "koyyani", "palakollu", "AP", 12, 7890, "hari@gmail.com");
		ContactDetails sri = new ContactDetails("sri", "koyyani", "palakollu", "AP", 12, 409, "sri@gmail.com");
		List<ContactDetails> contacts = Arrays.asList(new ContactDetails[] { mahi, hari, sri });
		AddressBookJsonIOService addressBookJsonIOService = new AddressBookJsonIOService("addressBook-test-Json.json");
		addressBookJsonIOService.writeContactDetails(contacts);
		List<ContactDetails> readContacts = addressBookJsonIOService.readContactDetails();
		Assert.assertEquals(mahi.toString(), readContacts.get(0).toString());
		Assert.assertEquals(hari.toString(), readContacts.get(1).toString());
		Assert.assertEquals(sri.toString(), readContacts.get(2).toString());
	}

}
