package edu.contoso.petclinic.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import edu.contoso.petclinic.model.Contact;
import edu.contoso.petclinic.repository.ContactRepository;

import org.springframework.validation.BindingResult;

import javax.validation.Valid;

@Controller
public class ContactController {
    
    private final ContactRepository contacts;
    private static final String CONTACT_CREATE_OR_UPDATE_FORM = "contact/createOrUpdateForm";

    public ContactController(ContactRepository contactsData) {
		this.contacts = contactsData;
	}

    @GetMapping("/contact")
    public String contact(Model model){
        /*List<Contact> listContacts = new ArrayList<Contact>();
        Contact contact = new Contact();
        contact.setEmail("test@gmail.com");
        contact.setName("Test");
        contact.setPhone("90000000");
        listContacts.add(contact);*/
        List<Contact> listContacts = this.contacts.findAll();
        model.addAttribute("contacts", listContacts);
        return "contact/index";
    }

    @GetMapping("/contact/create")
    public String create(Model model){
        Contact contact = new Contact();
		model.addAttribute("contact", contact);
        return CONTACT_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/contact/create")
	public String processCreationForm(@Valid Contact objContact, BindingResult result) {
		if(result.hasErrors()) {
			return CONTACT_CREATE_OR_UPDATE_FORM;
		}else{
            this.contacts.save(objContact);
            return CONTACT_CREATE_OR_UPDATE_FORM;
		}
	}
}
