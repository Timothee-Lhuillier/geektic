<%@page import="java.util.List" %>
<%@page import="com.bugsprod.model.Geek" %>
<%@page import="com.bugsprod.model.Interest" %>
<%!
public String printInterest(Geek geek) {
	String interests="intérets = ";
	List<Interest> lInterests = geek.getInterests();
	int nbInterest = geek.getInterests().size();
	for (int i=0; i<nbInterest; i++) {
		interests += geek.getInterests().get(i).toString();
			if (i<nbInterest-1){
				interests += ":";
			}
	}
	return interests;
}
%>