package com.rakkaus.web.service;

import com.rakkaus.web.domain.Contact;
import java.util.List;

/**
 * @author <a href="mailto:riuvshin@codenvy.com">Roman Iuvshin</a>
 * @version $Id: 9:44 PM 8/21/13 $
 */
public interface ContactService {

    public List<Contact> findAll();

    public Contact findById(Long id);

    public Contact save(Contact contact);

	public void delete(Contact contact);
}
