import entities.User;

import java.util.ArrayList;
import java.util.Arrays;
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

		try {
			System.out.println("--------------------------------- GET ---------------------------------");
			User found = usersList.get(1);
			System.out.println("Il secondo elemento della lista è: " + found);
			System.out.println("L'indice di Aldo è: " + usersList.indexOf(aldo));
		} catch (IndexOutOfBoundsException ex) {
			System.err.println(ex.getMessage());
		}

		System.out.println("--------------------------------- CONTAINS ---------------------------------");
		if (usersList.contains(aldo)) { // <-- .contains() internamente utilizza il metodo .equals() degli oggetti in questione, quindi eventualmente posso sovrascriverlo per usare un criterio di comparazione personalizzato
			System.out.println("La lista contiene Aldo");
		} else {
			System.out.println("La lista non contiene Aldo");
		}

		System.out.println("--------------------------------- REMOVE ---------------------------------");
		usersList.remove(0);
		usersList.remove(aldo);
		System.out.println("La lista ha " + usersList.size() + " elementi.");
		for (User user : usersList) {
			System.out.println(user);
		}

		System.out.println("--------------------------------- CLEAR ---------------------------------");
		System.out.println("La lista è vuota? " + usersList.isEmpty()); // Verifico se la lista è vuota o no
		usersList.clear(); // svuoto la lista
		System.out.println("La lista è vuota? " + usersList.isEmpty()); // Verifico se la lista è vuota o no

		System.out.println("--------------------------------- ADD ALL ---------------------------------");
		List<User> newList = new ArrayList<>(Arrays.asList(usersArray));
		usersList.addAll(newList);

		/*		LinkedList<User> newLinkedList = new LinkedList<>();
		newLinkedList.addAll(newList);*/ // Funziona anche sulle LinkedList

		System.out.println("La lista ha " + usersList.size() + " elementi.");
		for (User user : usersList) {
			System.out.println(user);
		}

		System.out.println("--------------------------------- REMOVE ALL ---------------------------------");
		usersList.add(new User("Ajeje", "Brazorf", 50));
		usersList.removeAll(newList); // posso passare una lista di elementi da rimuovere (in questo caso una lista di 3 elementi)
		System.out.println("La lista ha " + usersList.size() + " elementi.");
		for (User user : usersList) {
			System.out.println(user);
		}
		
	}
}