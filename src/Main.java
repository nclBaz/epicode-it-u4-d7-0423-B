import entities.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		User aldo = new User("Aldo", "Baglio", 20);
		User giovanni = new User("Giovanni", "Storti", 30);
		User giacomo = new User("Giacomo", "Poretti", 40);

		User[] usersArray = {aldo, giovanni, giacomo};

		ArrayList<User> usersList = new ArrayList<>(); // Tra le parentesi angolari <> vado a specificare il tipo di dato che sarà conservato nella Lista
		List<User> userList2 = new ArrayList<>(); // UPCASTING. Serve per eventualmente sostituire in futuro in maniera agevole questa ArrayList con un'altra List tipo una LinkedList

		// Aggiunta elementi
		usersList.add(aldo);
		usersList.add(giovanni);
		usersList.add(giacomo);
		usersList.add(0, new User("Ajeje", "Brazorf", 50));

		// Creo una lista a partire da un array
		// ArrayList<User> usersList2 = new ArrayList<>(Arrays.asList(usersArray));

		System.out.println("La lista ha " + usersList.size() + " elementi.");

		for (User user : usersList) {
			System.out.println(user);
		}

	}
}