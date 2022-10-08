<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Student Registration Form</title>
</head>

<body>
	<!--  -->
	<form:form action="processForm" modelAttribute="student">

		<!-- student.setFirstName()-->
  First name: <form:input path="firstName" />

		<br><br>
		
		<!-- student.setLastName()-->
  Last name: <form:input path="lastName" />

			<br><br>
		
	          <!--  Drop down list value labelin deyerini gosterir -->
  Country:
  <form:select path="country">
  
  <form:options items="${student.countryOptions}" />
  
  
	<%-- 	<form:option value="Brazil" label="Brazil" />
			<form:option value="India" label="India" />
			<form:option value="Azerbaijan" label="Azerbaijan" />
			<form:option value="Armenia" label="Armenia" /> --%>	

		</form:select>
	<br><br>
	
	
	<!--  Burada Çox vacib bir şey baş verir. Studentin favorite languagesinə (path="favoriteLanguage")
	Studentdə constructorla yaratdiqim hashmapin items="${student.favoriteLanguageOptions}" dan secilen optionu elave edirem
	və beləliklə favoriteLanguage həmin dəyəri almış olur -->
	
		
Favorite Language:	
 <form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"/> 

<%-- radio button in jsp file
Java<form:radiobutton path="favoriteLanguage" value="Java"/>
C#<form:radiobutton path="favoriteLanguage" value="C#"/>
PHP<form:radiobutton path="favoriteLanguage" value="PHP"/>
Python<form:radiobutton path="favoriteLanguage" value="Python"/>
--%>	
	
		<br><br>

Operating Systems:
Linux<form:checkbox path="operatingSystems" value="Linux"/>
MC Windows<form:checkbox path="operatingSystems" value="Windows"/>
Mac<form:checkbox path="operatingSystems" value="Mac"/>

	<br><br>
	
	
		<input type="submit" value="Submit" />
		<!-- When form is submitted Spring first will call setter methods -->

		<!--  Then when form is loaded,and when we call processForm Spring will call student.getFirstName() ,student.getLastName() methods-->

	</form:form>
</body>
</html>