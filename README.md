springMVCWithRest
=================

Project for learn spring

Simple spring application for managing Contacts

- restful
- mvc
- hibernate
- security

 RESPONSE_TYPE:
 - xml
 - json
 
 available REST_METHOS:

~~~ GET ~~~
 - <b>all-contacts</b> - return all contacts
 - <b>get-contact-by-id/{id}</b> - return contact by id
 
 example:  curl -v -H "Accept: application/\<RESPONSE_TYPE\>" http://localhost/restful/contact/\<REST_METHOD\> 
 
 
~~~ POST ~~~
- <b>create</b> - add new user, require formparams:

firstName=CONTACT_NAME

lastName=CONTACT__LAST_NAME

role=CONTACT_ROLE

birthDate=D_O_B

example: curl -v -X POST -d "firstName=TESTUSER&lastName=BLABLA&role=ADMIN&birthDate=1998-09-08" http://localhost:8080/restful/contact/create

~~~ DELETE ~~~
- <b>delete-contact{id}</b> - delete contact by id

example: curl -v -X DELETE http://localhost:8080/restful/contact/delete-contact/1

